package net.ahmad.myquarize.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CounterToolItem extends Item {
    public CounterToolItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getStackInHand(hand);
        int count = item.hasNbt() ? item.getNbt().getInt("myquarrize.counter") : 0;

        NbtCompound nbtData = new NbtCompound();
        nbtData.putInt("myquarrize.counter", count + 1);

        item.setNbt(nbtData);

        return TypedActionResult.success(item, true);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        Hand hand = context.getHand();

        if(user.getStackInHand(hand).hasNbt()) {
            user.getStackInHand(hand).setNbt(new NbtCompound());
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        int jumlah = stack.hasNbt() ? stack.getNbt().getInt("myquarrize.counter") : 0;

        tooltip.add(Text.literal("Count: " + jumlah));
    }
}
