package net.alminoris.almirisweapons.util.helper;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import java.util.Dictionary;
import java.util.Hashtable;

public class WeaponSetsHelper
{
    public static final String[] MATERIALS =
            {
                    "wood", "stone", "iron", "gold", "diamond", "netherite"
            };

    public static final Dictionary<String, ToolMaterial> TOOL_MATERIALS = new Hashtable<>()
            {{
                put("wood", ToolMaterials.WOOD);
                put("stone", ToolMaterials.STONE);
                put("iron", ToolMaterials.IRON);
                put("gold", ToolMaterials.GOLD);
                put("diamond", ToolMaterials.DIAMOND);
                put("netherite", ToolMaterials.NETHERITE);
            }};
}
