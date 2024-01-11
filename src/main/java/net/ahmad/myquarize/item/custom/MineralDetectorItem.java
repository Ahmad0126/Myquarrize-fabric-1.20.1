package net.ahmad.myquarize.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MineralDetectorItem extends Item {
    public MineralDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(!world.isClient()){
            
            boolean isCrops =
                state.isOf(Blocks.CARROTS) ||
                state.isOf(Blocks.WHEAT) ||
                state.isOf(Blocks.BEETROOTS) ||
                state.isOf(Blocks.POTATOES);

            if(isCrops){
                BlockState newCrops = state.getBlock().getDefaultState();
                world.setBlockState(pos, newCrops);
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.literal("No Minerals Found!"));
            }
        }
        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, LivingEntity player, Block block) {
        player.sendMessage(Text.literal(
                "Found " + block.asItem().getName().getString() + " at " + blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.GRANITE) || state.isOf(Blocks.DIORITE) || state.isOf(Blocks.ANDESITE);
    }
}
