package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataGenerator dataGenerator)
    {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.SMALL_STICK, Models.GENERATED);

        for (String name : MATERIALS)
        {
            itemModelGenerator.register(ModItems.HALBERDS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.CLAYMORES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.DAGGERS.get(name), Models.HANDHELD);
            itemModelGenerator.register(ModItems.GLAIVES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.BATTLE_STAVES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.ODACHIS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.KATANAS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.SCYTHES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.BATTLE_AXES.get(name), Models.HANDHELD);
            itemModelGenerator.register(ModItems.MACES.get(name), Models.HANDHELD);

            itemModelGenerator.register(ModItems.STABBING_TIPS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.MACE_TIPS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.AXE_TIPS.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.CURVED_BLADES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.SINGLEEDGE_BLADES.get(name), Models.GENERATED);
            itemModelGenerator.register(ModItems.DOUBLEEDGE_BLADES.get(name), Models.GENERATED);
        }
    }
}