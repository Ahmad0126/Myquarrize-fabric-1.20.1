package net.ahmad.myquarize.item;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.item.custom.MetalDetectorItem;
import net.ahmad.myquarize.item.custom.MineralDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item STEEL = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem("steel_hoe", new MineralDetectorItem(new FabricItemSettings().maxDamage(384)));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(152)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Myquarrize.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Myquarrize.LOGGER.info("Registering items for " + Myquarrize.MOD_ID);
    }
}
