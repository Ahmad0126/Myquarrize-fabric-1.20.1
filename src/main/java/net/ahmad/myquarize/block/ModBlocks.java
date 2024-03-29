package net.ahmad.myquarize.block;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.block.custom.CursedThunderBlock;
import net.ahmad.myquarize.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block THUNDER_BLOCK = registerBlock("thunder_block",
        new SoundBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block THUNDER_STEEL = registerBlock("thunder_steel",
        new CursedThunderBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(2, 5)));
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10f, 12f)));

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
