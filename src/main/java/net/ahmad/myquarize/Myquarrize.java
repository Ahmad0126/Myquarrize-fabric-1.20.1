package net.ahmad.myquarize;

import net.ahmad.myquarize.block.ModBlocks;
import net.ahmad.myquarize.item.ModItemGroups;
import net.ahmad.myquarize.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Myquarrize implements ModInitializer {
	public static final String MOD_ID = "myquarrize";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Myquarrize mod...");
		ModItemGroups.registerModItemGroup();
		FuelRegistry.INSTANCE.add(ModItems.STEEL_HOE, 100);
		FuelRegistry.INSTANCE.add(Blocks.HAY_BLOCK, 175);
		ModBlocks.registerModItems();
		ModItems.registerModItems();
	}
}