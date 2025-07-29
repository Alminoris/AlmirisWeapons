package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.util.helper.WeaponSetsHelper;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    public static final Dictionary<String, Item> SCYTHES = new Hashtable<>();
    public static final Dictionary<String, Item> KATANAS = new Hashtable<>();
    public static final Dictionary<String, Item> ODACHIS = new Hashtable<>();
    public static final Dictionary<String, Item> BATTLE_STAVES = new Hashtable<>();
    public static final Dictionary<String, Item> DAGGERS = new Hashtable<>();
    public static final Dictionary<String, Item> GLAIVES = new Hashtable<>();

    public static final Dictionary<String, Item> STABBING_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> MACE_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> AXE_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> DOUBLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, Item> SINGLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, Item> CURVED_BLADES = new Hashtable<>();

    public static final Item SMALL_STICK = registerItem("small_stick", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB)));

    public static final Dictionary<String, Item> MATERIAL_ITEMS = new Hashtable<>();

    static
    {
        MATERIAL_ITEMS.put("iron", Items.IRON_INGOT);
        MATERIAL_ITEMS.put("diamond", Items.DIAMOND);
        MATERIAL_ITEMS.put("gold", Items.GOLD_INGOT);
        MATERIAL_ITEMS.put("netherite", Items.NETHERITE_INGOT);

        for(String name : WeaponSetsHelper.MATERIALS)
        {
            STABBING_TIPS.put(name, registerItem(name+"_stabbing_tip", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            MACE_TIPS.put(name, registerItem(name+"_mace_tip", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            AXE_TIPS.put(name, registerItem(name+"_axe_tip", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            DOUBLEEDGE_BLADES.put(name, registerItem(name+"_doubleedge_blade", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            SINGLEEDGE_BLADES.put(name, registerItem(name+"_singleedge_blade", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            CURVED_BLADES.put(name, registerItem(name+"_curved_blade", new Item(new Item.Settings().group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));

            HALBERDS.put(name, registerItem(name+"_halberd", new SwordItem(TOOL_MATERIALS.get(name), 4, -3.0f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            RAPIERS.put(name, registerItem(name+"_rapier", new SwordItem(TOOL_MATERIALS.get(name), 2, -2.0f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            CLAYMORES.put(name, registerItem(name+"_claymore", new SwordItem(TOOL_MATERIALS.get(name), 5, -3.0f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            BATTLE_AXES.put(name, registerItem(name+"_battle_axe", new SwordItem(TOOL_MATERIALS.get(name), 6, -3.1f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            SAI.put(name, registerItem(name+"_sai", new SwordItem(TOOL_MATERIALS.get(name), 1, -1.5f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            MACES.put(name, registerItem(name+"_mace", new SwordItem(TOOL_MATERIALS.get(name), 6, -3.5f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));

            DAGGERS.put(name, registerItem(name+"_dagger", new SwordItem(TOOL_MATERIALS.get(name), 1, -1.75f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            GLAIVES.put(name, registerItem(name+"_glaive", new SwordItem(TOOL_MATERIALS.get(name), 3, -2.5f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            KATANAS.put(name, registerItem(name+"_katana", new SwordItem(TOOL_MATERIALS.get(name), 5, -2.25f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            BATTLE_STAVES.put(name, registerItem(name+"_battle_staff", new SwordItem(TOOL_MATERIALS.get(name), 5, -2.7f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            SCYTHES.put(name, registerItem(name+"_scythe", new SwordItem(TOOL_MATERIALS.get(name), 4, -2.6f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
            ODACHIS.put(name, registerItem(name+"_odachi", new SwordItem(TOOL_MATERIALS.get(name), 6, -3.25f, new Item.Settings().maxCount(1).group(ModItemGroups.ALMIRIS_WEAPONS_TAB))));
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