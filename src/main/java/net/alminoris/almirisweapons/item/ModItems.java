package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.util.helper.WeaponSetsHelper;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Dictionary;
import java.util.Hashtable;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.TOOL_MATERIALS;

public class ModItems
{
    public static final Dictionary<String, Item> HALBERDS = new Hashtable<>();
    public static final Dictionary<String, Item> RAPIERS = new Hashtable<>();
    public static final Dictionary<String, Item> CLAYMORES = new Hashtable<>();
    public static final Dictionary<String, Item> BATTLE_AXES = new Hashtable<>();
    public static final Dictionary<String, Item> SAI = new Hashtable<>();
    public static final Dictionary<String, Item> MACES = new Hashtable<>();

    static
    {
        for(String name : WeaponSetsHelper.MATERIALS)
        {
            HALBERDS.put(name, registerItem(name+"_halberd", new SwordItem(TOOL_MATERIALS.get(name), 4, -3.0f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            RAPIERS.put(name, registerItem(name+"_rapier", new SwordItem(TOOL_MATERIALS.get(name), 2, -2.0f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            CLAYMORES.put(name, registerItem(name+"_claymore", new SwordItem(TOOL_MATERIALS.get(name), 5, -3.0f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            BATTLE_AXES.put(name, registerItem(name+"_battle_axe", new SwordItem(TOOL_MATERIALS.get(name), 6, -3.1f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            SAI.put(name, registerItem(name+"_sai", new SwordItem(TOOL_MATERIALS.get(name), 1, -1.5f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            MACES.put(name, registerItem(name+"_mace", new SwordItem(TOOL_MATERIALS.get(name), 6, -3.5f, new Item.Settings()
                    .maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
        }
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(AlmirisWeapons.MOD_ID, name), item);
    }

    public static void registerItems()
    {

    }
}
