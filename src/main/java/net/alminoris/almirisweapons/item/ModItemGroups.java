package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemGroups
{
    public static final ItemGroup ASEAT_TAB = FabricItemGroup.builder(new Identifier(AlmirisWeapons.MOD_ID, "almweaptab"))
            .displayName(Text.translatable("itemgroup.almweaptab"))
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

                            entries.add(ModItems.STABBING_TIPS.get(name));
                            entries.add(ModItems.AXE_TIPS.get(name));
                            entries.add(ModItems.MACE_TIPS.get(name));
                            entries.add(ModItems.SINGLEEDGE_BLADES.get(name));
                            entries.add(ModItems.DOUBLEEDGE_BLADES.get(name));
                            entries.add(ModItems.CURVED_BLADES.get(name));
                        }

                        entries.add(ModItems.SMALL_STICK);
                    }).build();

    public static void registerItemGroups()
    {

    }
}
