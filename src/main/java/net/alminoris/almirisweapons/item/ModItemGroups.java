package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class ModItemGroups
{
    public static final ItemGroup ALMIRIS_WEAPONS_TAB = FabricItemGroupBuilder.build(new Identifier(AlmirisWeapons.MOD_ID, "almweaptab"),
            () -> new ItemStack(ModItems.HALBERDS.get("iron"))).setName("itemgroup.almweaptab");

    public static void registerItemGroups()
    {

    }
}
