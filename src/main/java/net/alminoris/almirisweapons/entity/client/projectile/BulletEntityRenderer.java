package net.alminoris.almirisweapons.entity.client.projectile;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends ProjectileEntityRenderer<BulletEntity>
{
    public static final Identifier TEXTURE = Identifier.of(AlmirisWeapons.MOD_ID, "textures/entity/projectiles/bullet.png");

    public BulletEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context);
    }

    @Override
    public Identifier getTexture(BulletEntity entity)
    {
        return TEXTURE;
    }
}