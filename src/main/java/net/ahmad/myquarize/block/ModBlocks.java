package net.ahmad.myquarize.block;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.block.custom.CursedThunderBlock;
import net.ahmad.myquarize.block.custom.PinkGarnetLampBlock;
import net.ahmad.myquarize.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
        new SlabBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
        new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
        new FenceBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
        new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK), WoodType.OAK));
    public static final Block RUBY_WALL = registerBlock("ruby_wall",
        new WallBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_DOOR = registerBlock("ruby_door",
        new DoorBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK), BlockSetType.IRON));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
        new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK), BlockSetType.IRON));
    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
        new ButtonBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK), BlockSetType.IRON, 10, true));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK), BlockSetType.IRON));

    public static final Block THUNDER_BLOCK = registerBlock("thunder_block",
        new SoundBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block THUNDER_STEEL = registerBlock("thunder_steel",
        new CursedThunderBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(2, 5)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block STEEL_SLAB = registerBlock("steel_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block STEEL_STAIRS = registerBlock("steel_stairs",
            new StairsBlock(ModBlocks.STEEL_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block STEEL_FENCE = registerBlock("steel_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block STEEL_FENCE_GATE = registerBlock("steel_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f), WoodType.OAK));
    public static final Block STEEL_WALL = registerBlock("steel_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block STEEL_DOOR = registerBlock("steel_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f), BlockSetType.IRON));
    public static final Block STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f), BlockSetType.IRON));
    public static final Block STEEL_BUTTON = registerBlock("steel_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f), BlockSetType.IRON, 10, true));
    public static final Block STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f), BlockSetType.IRON));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Myquarrize.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(
            Registries.ITEM, new Identifier(Myquarrize.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings())
        );
    }
    public static void registerModItems(){
        Myquarrize.LOGGER.info("Registering blocks for " + Myquarrize.MOD_ID);
    }
}
