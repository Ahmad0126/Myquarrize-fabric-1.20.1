package net.ahmad.myquarize.item;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.block.custom.ModArmorItem;
import net.ahmad.myquarize.item.custom.CounterToolItem;
import net.ahmad.myquarize.item.custom.DataTabletItem;
import net.ahmad.myquarize.item.custom.MetalDetectorItem;
import net.ahmad.myquarize.item.custom.MineralDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item STEEL = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item COKLAT_BATANG = registerItem("coklat_batang", new Item(new FabricItemSettings().food(ModFoodComponents.COKLAT_BATANG)));

    public static final Item STEEL_HOE = registerItem("steel_hoe", new MineralDetectorItem(new FabricItemSettings().maxDamage(384)));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(152)));
    public static final Item DATA_STICK = registerItem("data_stick", new DataTabletItem(new FabricItemSettings().maxCount(1)));
    public static final Item COUNTER_COMPASS = registerItem("counter_compass", new CounterToolItem(new FabricItemSettings().maxCount(1)));

    public static final Item RUBY_STAFF = registerItem("ruby_staff", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY, 2, -2.8f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY, 5, -3f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY, 1, -2f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY, 4, -2.4f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY, 1, 0f, new FabricItemSettings()));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Myquarrize.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Myquarrize.LOGGER.info("Registering items for " + Myquarrize.MOD_ID);
    }
}
