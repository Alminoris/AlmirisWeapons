package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataGenerator dataGenerator)
    {
        super(dataGenerator);
    }

    @Override
    protected void generateTags()
    {
        for (String name : MATERIALS)
        {
            getOrCreateTagBuilder(ConventionalItemTags.SWORDS)
                    .add(ModItems.HALBERDS.get(name))
                    .add(ModItems.SAI.get(name))
                    .add(ModItems.MACES.get(name))
                    .add(ModItems.CLAYMORES.get(name))
                    .add(ModItems.RAPIERS.get(name));

            getOrCreateTagBuilder(ConventionalItemTags.AXES)
                    .add(ModItems.BATTLE_AXES.get(name));
        }
    }
}