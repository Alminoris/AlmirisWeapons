package net.alminoris.almirisweapons.item.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BlunderbussItem extends AbstractFirearmItem
{
    private static final Map<UUID, Integer> pullTicks = new HashMap<>();

    private final FirearmConfig config;

    public BlunderbussItem(Settings settings, FirearmConfig config)
    {
        super(settings.maxDamage(75));
        this.config = config;
    }

    @Override
    protected Map<UUID, Integer> getPullTicks()
    {
        return pullTicks;
    }

    @Override
    protected FirearmConfig getConfig()
    {
        return config;
    }
}