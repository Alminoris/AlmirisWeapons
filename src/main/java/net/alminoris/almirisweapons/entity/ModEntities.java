package net.alminoris.almirisweapons.entity;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities
{
    public static final EntityType<BulletEntity> BULLET = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AlmirisWeapons.MOD_ID, "bullet"),
            FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}