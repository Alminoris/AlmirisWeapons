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
    public static final ItemGroup ASEAT_TAB = FabricItemGroup.builder(Identifier.of(AlmirisWeapons.MOD_ID, "almweaptab"))
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
                        }
                    }).build();

    public static void registerItemGroups()
    {

    }
}
