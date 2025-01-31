package net.ahmad.myquarize.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModInventoryUtil {
    public static boolean hasPlayerStackInInventory(PlayerEntity player, Item item){
        for(int i = 0; i < player.getInventory().size(); i++){
            ItemStack currentStack = player.getInventory().getStack(i);

            if(!currentStack.isEmpty() && ItemStack.areItemsEqual(currentStack, new ItemStack(item))){
                return true;
            }
        }

        return false;
    }

    public static int getFirstInventorySlot(PlayerEntity player, Item item){
        for(int i = 0; i < player.getInventory().size(); i++){
            ItemStack currentStack = player.getInventory().getStack(i);

            if(!currentStack.isEmpty() && ItemStack.areItemsEqual(currentStack, new ItemStack(item))){
                return i;
            }
        }

        return -1;
    }
}
