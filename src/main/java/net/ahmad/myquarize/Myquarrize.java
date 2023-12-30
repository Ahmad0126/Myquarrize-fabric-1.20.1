package net.ahmad.myquarize;

import net.ahmad.myquarize.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Myquarrize implements ModInitializer {
	public static final String MOD_ID = "myquarrize";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Myquarrize mod...");
		ModItems.registerModItems();
	}
}