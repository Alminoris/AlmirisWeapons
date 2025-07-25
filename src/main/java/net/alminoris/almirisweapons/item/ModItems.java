package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.util.helper.WeaponHelper;
import net.alminoris.almirisweapons.util.helper.WeaponSetsHelper;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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

    static
    {
        for(String name : WeaponSetsHelper.MATERIALS)
        {
            HALBERDS.put(name, registerItem(name+"_halberd", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4, -3.0D)))));
            RAPIERS.put(name, registerItem(name+"_rapier", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 2, -2.0D)))));
            CLAYMORES.put(name, registerItem(name+"_claymore", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 5, -3.0D)))));
            BATTLE_AXES.put(name, registerItem(name+"_battle_axe", new AxeItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 6, -3.1D)))));
            SAI.put(name, registerItem(name+"_sai", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 1, -1.5D)))));
            MACES.put(name, registerItem(name+"_mace", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 6, -3.5D)))));

            DAGGERS.put(name, registerItem(name+"_dagger", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 1.5D, -1.75D)))));
            GLAIVES.put(name, registerItem(name+"_glaive", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 3.5D, -2.5D)))));
            KATANAS.put(name, registerItem(name+"_katana", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4.75D, -2.25D)))));
            BATTLE_STAVES.put(name, registerItem(name+"_battle_staff", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4.5D, -2.7D)))));
            SCYTHES.put(name, registerItem(name+"_scythe", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4D, -2.6D)))));
            ODACHIS.put(name, registerItem(name+"_odachi", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 5.75D, -3.25D)))));
        }
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(AlmirisWeapons.MOD_ID, name), item);
    }

    public static void registerItems()
    {

    }
}
