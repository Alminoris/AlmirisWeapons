package net.alminoris.almirisweapons.entity.custom.projectile;

import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BulletEntity extends PersistentProjectileEntity {
    private double damage = 8.0D;

    public BulletEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, owner, world, stack, shotFrom);
    }

    public BulletEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, x, y, z, world, stack, shotFrom);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && !this.inGround) {
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(),
                    0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        if (!this.getWorld().isClient) {
            if (entityHitResult.getEntity() instanceof LivingEntity target) {

                DamageSource source = this.getWorld().getDamageSources().arrow(this, this.getOwner() instanceof LivingEntity shooter ? shooter : null);

                target.damage(source, (float) this.damage);

                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 1));

                this.discard();
            }
        }
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.BULLET);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("BulletDamage")) {
            this.damage = nbt.getDouble("BulletDamage");
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putDouble("BulletDamage", this.damage);
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}