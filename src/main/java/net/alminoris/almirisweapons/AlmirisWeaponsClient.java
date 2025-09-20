package net.alminoris.almirisweapons;

import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.entity.client.projectile.BulletEntityRenderer;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.item.render.FirearmItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AlmirisWeaponsClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.ARQUEBUS, new FirearmItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.BLUNDERBUSS, new FirearmItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.MATCHLOCK_PISTOL, new FirearmItemRenderer());
    }
}