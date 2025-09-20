package net.alminoris.almirisweapons.item.custom;

import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.item.render.FirearmItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BlunderbussItem extends net.minecraft.item.Item {

    private static final Map<UUID, Integer> pullTicks = new HashMap<>();
    protected final FirearmConfig config;

    public BlunderbussItem(Settings settings, FirearmConfig config) {
        super(settings);
        this.config = config;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        pullTicks.put(user.getUuid(), 0);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player) || world.isClient) return;

        UUID uuid = player.getUuid();
        if (pullTicks.containsKey(uuid)) {
            int ticks = pullTicks.get(uuid) + 1;
            pullTicks.put(uuid, ticks);

            if (ticks >= config.minUseTicks()) {
                pullTicks.remove(uuid);
                player.stopUsingItem();
                fire(world, player, player.getStackInHand(player.getActiveHand()), player.getActiveHand());
            }
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player) || world.isClient) return;

        UUID uuid = player.getUuid();
        int usedTicks = pullTicks.getOrDefault(uuid, 0);
        pullTicks.remove(uuid);

        if (usedTicks >= config.minUseTicks()) {
            fire(world, player, stack, player.getActiveHand());
        }
    }

    private void fire(World world, PlayerEntity player, ItemStack stack, Hand hand) {
        if (player.getItemCooldownManager().isCoolingDown(this)) return;

        if (world.random.nextFloat() < config.misfireChance()) {
            playSound(world, player, config.misfireSound(), 1f, 1f);
            startReload(world, player, stack, hand);
            return;
        }

        ItemStack ammo = findAmmo(player);
        if (ammo.isEmpty() || ammo.getCount() < config.ammoPerShot()) return;
        ammo.decrement(config.ammoPerShot());

        for (int i = 0; i < config.projectilesPerShot(); i++) {
            ItemStack bulletStack = new ItemStack(ModItems.BULLET);
            BulletEntity bullet = new BulletEntity(world, player, bulletStack, stack);
            bullet.setDamage(config.damage());
            bullet.setVelocity(player,
                    player.getPitch(),
                    player.getYaw() + (world.random.nextFloat() - 0.5F) * config.spreadAngle(),
                    0.0F,
                    config.velocity(),
                    config.inaccuracy());
            world.spawnEntity(bullet);
        }

        playSound(world, player, config.shootSound(), config.soundVolume(), config.soundPitch());

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(config.smokeParticle(),
                    player.getX(), player.getEyeY(), player.getZ(),
                    config.smokeCount(), config.smokeSpread(), config.smokeSpread(),
                    config.smokeSpread(), config.smokeSpeed());

            if (config.flameParticle() != null) {
                serverWorld.spawnParticles(config.flameParticle(),
                        player.getX(), player.getEyeY(), player.getZ(),
                        config.flameCount(), 0.05, 0.05, 0.05, 0.01);
            }
        }

        if (world.isClient) {
            FirearmItemRenderer.triggerRecoil(player.getUuid(), hand, config.recoilStrength());
        }

        applyRecoil(player);
        startReload(world, player, stack, hand);
    }

    private void startReload(World world, PlayerEntity player, ItemStack stack, Hand hand) {
        player.getItemCooldownManager().set(this, config.reloadTicks());
        playSound(world, player, config.reloadSound(), config.reloadVolume(), config.reloadPitch());

        if (world instanceof ServerWorld serverWorld && config.reloadParticle() != null) {
            serverWorld.spawnParticles(config.reloadParticle(),
                    player.getX(), player.getEyeY() - 0.2, player.getZ(),
                    config.reloadParticleCount(), 0.05, 0.05, 0.05, 0.01);
        }

        if (world.isClient) {
            FirearmItemRenderer.startReload(player.getUuid(), hand, config.reloadTicks());
        }
    }

    protected void applyRecoil(LivingEntity user) {
        double yawRad = Math.toRadians(user.getYaw());
        double rx = -Math.sin(yawRad) * config.recoilStrength();
        double rz = Math.cos(yawRad) * config.recoilStrength();
        double ry = config.recoilVertical();
        user.setVelocity(user.getVelocity().add(rx, ry, rz));
    }

    private ItemStack findAmmo(PlayerEntity player) {
        if (player.getOffHandStack().isOf(ModItems.BULLET)) return player.getOffHandStack();
        if (player.getMainHandStack().isOf(ModItems.BULLET)) return player.getMainHandStack();
        for (ItemStack stack : player.getInventory().main) {
            if (stack.isOf(ModItems.BULLET)) return stack;
        }
        return ItemStack.EMPTY;
    }

    private void playSound(World world, PlayerEntity player, SoundEvent sound, float volume, float pitch) {
        world.playSound(
                null,                       // target entity (null = усі слухачі)
                player.getX(),
                player.getY(),
                player.getZ(),
                sound,
                player.getSoundCategory(),
                volume,
                pitch
        );
    }


    @Override
    public UseAction getUseAction(ItemStack stack) { return config.useAction(); }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) { return config.maxUseTime(); }
}
