package net.ahmad.myquarize.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MineralDetectorItem extends Item {
    public MineralDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(!world.isClient()){
            
            boolean isCrops =
                state.isOf(Blocks.CARROTS);

            if(isCrops){
                BlockState newCrops = state.getBlock().getDefaultState();
                world.setBlockState(pos, newCrops);
                ItemStack crops = new ItemStack(Items.CARROT);
                PlayerInventory inventory = new PlayerInventory((PlayerEntity) miner);
                inventory.removeOne(crops);
            }

        }

        stack.damage(1, miner,
                livingEntity -> livingEntity.sendToolBreakStatus(livingEntity.getActiveHand()));

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
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, LivingEntity player, Block block) {
        player.sendMessage(Text.literal(
                "Found " + block.asItem().getName().getString() + " at " + blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.GRANITE) || state.isOf(Blocks.DIORITE) || state.isOf(Blocks.ANDESITE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Cangkul sakti auto replant"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
