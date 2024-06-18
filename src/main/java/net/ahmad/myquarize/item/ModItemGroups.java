package net.ahmad.myquarize.item;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MODS = Registry.register(
        Registries.ITEM_GROUP, new Identifier(Myquarrize.MOD_ID, "mods"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mods"))
            .icon(() -> new ItemStack(ModItems.RUBY))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.COKLAT_BATANG);
                entries.add(ModItems.STEEL_HOE);
                entries.add(ModItems.METAL_DETECTOR);
                entries.add(ModItems.RUBY_STAFF);

                entries.add(ModItems.RUBY);
                entries.add(ModItems.RAW_RUBY);
                entries.add(ModBlocks.RUBY_ORE);
                entries.add(ModBlocks.RUBY_BLOCK);
                entries.add(ModBlocks.THUNDER_BLOCK);
                entries.add(ModBlocks.RUBY_SLAB);
                entries.add(ModBlocks.RUBY_STAIRS);
                entries.add(ModBlocks.RUBY_DOOR);
                entries.add(ModBlocks.RUBY_TRAPDOOR);
                entries.add(ModBlocks.RUBY_FENCE);
                entries.add(ModBlocks.RUBY_FENCE_GATE);
                entries.add(ModBlocks.RUBY_WALL);
                entries.add(ModBlocks.RUBY_BUTTON);
                entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                entries.add(ModItems.RUBY_SWORD);
                entries.add(ModItems.RUBY_PICKAXE);
                entries.add(ModItems.RUBY_AXE);
                entries.add(ModItems.RUBY_SHOVEL);
                entries.add(ModItems.RUBY_HOE);

                entries.add(ModItems.STEEL);
                entries.add(ModBlocks.STEEL_BLOCK);
                entries.add(ModBlocks.THUNDER_STEEL);
                entries.add(ModBlocks.STEEL_SLAB);
                entries.add(ModBlocks.STEEL_STAIRS);
                entries.add(ModBlocks.STEEL_DOOR);
                entries.add(ModBlocks.STEEL_TRAPDOOR);
                entries.add(ModBlocks.STEEL_FENCE);
                entries.add(ModBlocks.STEEL_FENCE_GATE);
                entries.add(ModBlocks.STEEL_WALL);
                entries.add(ModBlocks.STEEL_BUTTON);
                entries.add(ModBlocks.STEEL_PRESSURE_PLATE);
            }
        ).build()
    );
    public static void registerModItemGroup(){
        Myquarrize.LOGGER.info("Registering item group for " + Myquarrize.MOD_ID);
    }
}
