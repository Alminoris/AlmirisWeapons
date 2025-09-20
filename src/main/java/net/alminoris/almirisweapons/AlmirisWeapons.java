package net.alminoris.almirisweapons;

import net.alminoris.almirisweapons.item.ModItemGroups;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlmirisWeapons implements ModInitializer
{
	public static final String MOD_ID = "almirisweapons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();

		LOGGER.info("Almiris Weapons MOD Initialization");
	}
}