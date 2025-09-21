package net.alminoris.almirisweapons.item.custom;

import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.item.render.FirearmItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractFirearmItem extends Item
{

    public AbstractFirearmItem(Settings settings)
    {
        super(settings);
    }

    protected abstract FirearmConfig getConfig();

    protected abstract Map<UUID, Integer> getPullTicks();

    private final Map<UUID, Integer> reloadTimers = new HashMap<>();

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (user.getItemCooldownManager().isCoolingDown(this))
            return TypedActionResult.fail(user.getStackInHand(hand));
        getPullTicks().put(user.getUuid(), 0);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if (!(entity instanceof PlayerEntity player) || world.isClient) return;

        UUID uuid = player.getUuid();

        if (getPullTicks().containsKey(uuid))
        {
            int ticks = getPullTicks().get(uuid) + 1;
            getPullTicks().put(uuid, ticks);

            if (ticks >= getConfig().minUseTicks())
            {
                getPullTicks().remove(uuid);
                player.stopUsingItem();
                fire(world, player, player.getStackInHand(player.getActiveHand()), player.getActiveHand());
            }
        }

        if (reloadTimers.containsKey(uuid))
        {
            int ticksLeft = reloadTimers.get(uuid) - 1;
            if (ticksLeft <= 0)
            {
                playSound(world, player,
                        getConfig().reloadSound(),
                        getConfig().reloadVolume(),
                        getConfig().reloadPitch());

                reloadTimers.remove(uuid);
            }
            else
            {
                reloadTimers.put(uuid, ticksLeft);
            }
        }
    }

    private void startReload(World world, PlayerEntity player, ItemStack stack, Hand hand)
    {
        int reloadTime = getConfig().reloadTicks();

        player.getItemCooldownManager().set(this, reloadTime);
        reloadTimers.put(player.getUuid(), reloadTime);

        if (world instanceof ServerWorld serverWorld && getConfig().reloadParticle() != null)
        {
            serverWorld.spawnParticles(getConfig().reloadParticle(),
                    player.getX(), player.getEyeY() - 0.2, player.getZ(),
                    getConfig().reloadParticleCount(), 0.05, 0.05, 0.05, 0.01);
        }

        if (world.isClient)
        {
            FirearmItemRenderer.startReload(player.getUuid(), hand, reloadTime);
        }
    }

    private void playSound(World world, PlayerEntity player, SoundEvent sound, float volume, float pitch)
    {
        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                sound, player.getSoundCategory(), volume, pitch);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks)
    {
        if (!(user instanceof PlayerEntity player) || world.isClient) return;

        UUID uuid = player.getUuid();
        int usedTicks = getPullTicks().getOrDefault(uuid, 0);
        getPullTicks().remove(uuid);

        if (usedTicks >= getConfig().minUseTicks())
        {
            fire(world, player, stack, player.getActiveHand());
        }
    }

    private void fire(World world, PlayerEntity player, ItemStack stack, Hand hand)
    {
        if (player.getItemCooldownManager().isCoolingDown(this))
        {
            return;
        }

        if (world.random.nextFloat() < getConfig().misfireChance())
        {
            player.sendMessage(Text.translatable("message.almirisweapons.misfire"), true);
            playSound(world, player, getConfig().misfireSound(), 1f, 1f);
            startReload(world, player, stack, hand);
            return;
        }

        ItemStack ammo = findAmmo(player);
        if (ammo.isEmpty() || ammo.getCount() < getConfig().ammoPerShot())
        {
            player.sendMessage(Text.translatable("message.almirisweapons.no_ammo"), true);
            return;
        }
        ammo.decrement(getConfig().ammoPerShot());

        for (int i = 0; i < getConfig().projectilesPerShot(); i++)
        {
            ItemStack bulletStack = new ItemStack(ModItems.BULLET);
            BulletEntity bullet = new BulletEntity(world, player, bulletStack, stack);
            bullet.setDamage(getConfig().damage());
            bullet.setVelocity(player,
                    player.getPitch(),
                    player.getYaw() + (world.random.nextFloat() - 0.5F) * getConfig().spreadAngle(),
                    0.0F,
                    getConfig().velocity(),
                    getConfig().inaccuracy());
            world.spawnEntity(bullet);
        }

        stack.damage(1, player, EquipmentSlot.MAINHAND);

        playSound(world, player, getConfig().shootSound(), getConfig().soundVolume(), getConfig().soundPitch());

        if (world instanceof ServerWorld serverWorld)
        {
            serverWorld.spawnParticles(getConfig().smokeParticle(),
                    player.getX(), player.getEyeY(), player.getZ(),
                    getConfig().smokeCount(), getConfig().smokeSpread(), getConfig().smokeSpread(),
                    getConfig().smokeSpread(), getConfig().smokeSpeed());

            if (getConfig().flameParticle() != null)
            {
                serverWorld.spawnParticles(getConfig().flameParticle(),
                        player.getX(), player.getEyeY(), player.getZ(),
                        getConfig().flameCount(), 0.05, 0.05, 0.05, 0.01);
            }
        }

        if (world.isClient)
        {
            FirearmItemRenderer.triggerRecoil(player.getUuid(), hand, getConfig().recoilStrength());
        }

        applyRecoil(player);
        startReload(world, player, stack, hand);
    }

    protected void applyRecoil(LivingEntity user)
    {
        double yawRad = Math.toRadians(user.getYaw());
        double rx = -Math.sin(yawRad) * getConfig().recoilStrength();
        double rz = Math.cos(yawRad) * getConfig().recoilStrength();
        double ry = getConfig().recoilVertical();
        user.setVelocity(user.getVelocity().add(rx, ry, rz));
    }

    private ItemStack findAmmo(PlayerEntity player)
    {
        if (player.getOffHandStack().isOf(ModItems.BULLET)) return player.getOffHandStack();
        if (player.getMainHandStack().isOf(ModItems.BULLET)) return player.getMainHandStack();
        for (ItemStack stack : player.getInventory().main)
        {
            if (stack.isOf(ModItems.BULLET)) return stack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        super.appendTooltip(stack, context, tooltip, type);

        FirearmConfig cfg = getConfig();

        tooltip.add(Text.empty());

        tooltip.add(Text.translatable("item.modifiers.mainhand").formatted(Formatting.GRAY));

        tooltip.add(Text.literal(" ")
                .append(cfg.damage() + " ").formatted(Formatting.DARK_GREEN)
                .append(Text.translatable("tooltip.almirisweapons.damage")
                        .formatted(Formatting.DARK_GREEN)));

        tooltip.add(Text.literal(" ")
                .append((cfg.reloadTicks() / 20f) + "s ").formatted(Formatting.DARK_GREEN)
                .append(Text.translatable("tooltip.almirisweapons.reload_time")
                        .formatted(Formatting.DARK_GREEN)));

        tooltip.add(Text.literal(" ")
                .append(cfg.ammoPerShot() + " ").formatted(Formatting.DARK_GREEN)
                .append(Text.translatable("tooltip.almirisweapons.ammo_per_shot")
                        .formatted(Formatting.DARK_GREEN)));

        tooltip.add(Text.literal(" ")
                .append((int)(cfg.misfireChance() * 100) + "% ").formatted(Formatting.DARK_GREEN)
                .append(Text.translatable("tooltip.almirisweapons.misfire")
                        .formatted(Formatting.DARK_GREEN)));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) { return getConfig().useAction(); }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) { return getConfig().maxUseTime(); }
}