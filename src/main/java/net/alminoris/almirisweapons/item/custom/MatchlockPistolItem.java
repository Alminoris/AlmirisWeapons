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

public class MatchlockPistolItem extends Item {
    public MatchlockPistolItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 20;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
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
            BulletEntity bullet = new BulletEntity(world, user, stack, null);
            bullet.setDamage(8.0D);
            bullet.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 5.0F, 1.0F);
            world.spawnEntity(bullet);
        }
    }
}
