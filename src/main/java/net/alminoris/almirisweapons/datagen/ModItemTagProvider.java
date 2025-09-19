package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        for (String name : MATERIALS)
        {
            getOrCreateTagBuilder(ItemTags.SWORDS)
                    .add(ModItems.HALBERDS.get(name))
                    .add(ModItems.SAI.get(name))
                    .add(ModItems.CLAYMORES.get(name))
                    .add(ModItems.SCYTHES.get(name))
                    .add(ModItems.ODACHIS.get(name))
                    .add(ModItems.KATANAS.get(name))
                    .add(ModItems.KATARS.get(name))
                    .add(ModItems.DAGGERS.get(name))
                    .add(ModItems.GLAIVES.get(name))
                    .add(ModItems.BATTLE_STAVES.get(name))
                    .add(ModItems.RAPIERS.get(name));

            getOrCreateTagBuilder(ItemTags.AXES)
                    .add(ModItems.BATTLE_AXES.get(name))
                    .add(ModItems.DANE_AXES.get(name))
                    .add(ModItems.BEARDED_AXES.get(name));

            getOrCreateTagBuilder(ItemTags.MACE_ENCHANTABLE)
                    .add(ModItems.MACES.get(name));
        }
    }
}