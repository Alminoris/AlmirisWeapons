package net.alminoris.almirisweapons.entity;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities
{
    public static final EntityType<BulletEntity> BULLET = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(AlmirisWeapons.MOD_ID, "bullet"),
            FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}