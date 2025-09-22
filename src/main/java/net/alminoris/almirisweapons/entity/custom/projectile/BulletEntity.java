package net.alminoris.almirisweapons.entity.custom.projectile;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BulletEntity extends PersistentProjectileEntity
{
    private double damage = 8.0D;

    public BulletEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public BulletEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom)
    {
        super(ModEntities.BULLET, owner, world);
        this.pickupType = PickupPermission.DISALLOWED;
    }

    @Override
    protected SoundEvent getHitSound()
    {
        return ModSounds.EMPTY;
    }

    @Override
    public void tick()
    {
        super.tick();
        if (this.getWorld().isClient && !this.inGround)
        {
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(),
                    0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        super.onEntityHit(entityHitResult);

        if (!this.getWorld().isClient)
        {
            if (entityHitResult.getEntity() instanceof LivingEntity target)
            {
                DamageSource source = new ProjectileDamageSource(
                        "bullet", // ключ для типу дамаґу
                        this,    // снаряд (bullet)
                        this.getOwner() instanceof LivingEntity shooter ? shooter : null
                ).setProjectile();

                target.damage(source, (float) this.damage);

                this.discard();
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult)
    {
        super.onBlockHit(blockHitResult);
        int count = this.random.nextInt(0, 2);
        dropStack(new ItemStack(Items.IRON_NUGGET, count));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("BulletDamage"))
        {
            this.damage = nbt.getDouble("BulletDamage");
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BULLET);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt)
    {
        super.writeCustomDataToNbt(nbt);
        nbt.putDouble("BulletDamage", this.damage);
    }

    public void setDamage(double damage)
    {
        this.damage = damage;
    }
}