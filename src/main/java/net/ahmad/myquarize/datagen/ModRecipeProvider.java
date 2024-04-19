package net.ahmad.myquarize.datagen;

import net.ahmad.myquarize.block.ModBlocks;
import net.ahmad.myquarize.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public static final List<ItemConvertible> RUBY_SMELTABLE = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE);
    public static final List<ItemConvertible> STEEL_SMELTABLE = List.of(Blocks.IRON_BLOCK);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");
        offerSmelting(exporter, STEEL_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "steel");
        offerBlasting(exporter, STEEL_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "steel");
        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.MISC, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL, RecipeCategory.MISC, ModBlocks.STEEL_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_HOE, 1)
                .pattern("##")
                .pattern(" I")
                .pattern(" I")
                .input('#', ModItems.STEEL)
                .input('I', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_HOE)));
    }
}
