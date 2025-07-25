package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemGroups
{
    public static final ItemGroup ASEAT_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AlmirisWeapons.MOD_ID, "almweaptab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.almweaptab"))
                    .icon(() -> new ItemStack(Items.IRON_SWORD)).entries((displayContext, entries) ->
                    {
                        for (String name : MATERIALS)
                        {
                            entries.add(ModItems.HALBERDS.get(name));
                            entries.add(ModItems.RAPIERS.get(name));
                            entries.add(ModItems.CLAYMORES.get(name));
                            entries.add(ModItems.BATTLE_AXES.get(name));
                            entries.add(ModItems.SAI.get(name));
                            entries.add(ModItems.MACES.get(name));

                            entries.add(ModItems.DAGGERS.get(name));
                            entries.add(ModItems.GLAIVES.get(name));
                            entries.add(ModItems.KATANAS.get(name));
                            entries.add(ModItems.BATTLE_STAVES.get(name));
                            entries.add(ModItems.SCYTHES.get(name));
                            entries.add(ModItems.ODACHIS.get(name));
                        }
                    }).build());

    public static void registerItemGroups()
    {

    }
}
