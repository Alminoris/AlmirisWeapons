package net.alminoris.almirisweapons;

import net.alminoris.almirisweapons.datagen.ModModelProvider;
import net.alminoris.almirisweapons.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AlmirisWeaponsDataGenerator implements DataGeneratorEntrypoint
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		fabricDataGenerator.addProvider(ModModelProvider::new);
		fabricDataGenerator.addProvider(ModRecipeProvider::new);
	}
}
