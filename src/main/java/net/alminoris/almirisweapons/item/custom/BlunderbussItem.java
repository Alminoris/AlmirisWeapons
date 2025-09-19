package net.alminoris.almirisweapons.item.custom;

import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BlunderbussItem extends Item {
    public BlunderbussItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 50;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            for (int i = 0; i < 5; i++) {
                BulletEntity bullet = new BulletEntity(world, user, stack, null);
                bullet.setDamage(6.0D);

                bullet.setVelocity(user, user.getPitch(), user.getYaw() + (world.random.nextFloat() - 0.5F) * 10.0F, 0.0F, 3.5F, 1.2F);
                world.spawnEntity(bullet);
            }
        }
    }
}