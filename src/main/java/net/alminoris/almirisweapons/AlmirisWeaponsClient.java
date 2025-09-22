package net.alminoris.almirisweapons;

import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.entity.client.projectile.BulletEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AlmirisWeaponsClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
    }
}
