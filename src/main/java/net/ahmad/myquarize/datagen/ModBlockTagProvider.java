package net.ahmad.myquarize.datagen;

import net.ahmad.myquarize.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.THUNDER_BLOCK)
                .add(ModBlocks.THUNDER_STEEL)
                .add(ModBlocks.RUBY_BUTTON)
                .add(ModBlocks.RUBY_PRESSURE_PLATE)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.THUNDER_STEEL)
                .add(ModBlocks.RUBY_SLAB)
                .add(ModBlocks.RUBY_STAIRS)
                .add(ModBlocks.RUBY_FENCE)
                .add(ModBlocks.RUBY_FENCE_GATE)
                .add(ModBlocks.RUBY_WALL)
                .add(ModBlocks.RUBY_DOOR)
                .add(ModBlocks.RUBY_TRAPDOOR)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.THUNDER_BLOCK)
        ;
    }
}
