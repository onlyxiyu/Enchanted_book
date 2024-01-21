package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class DisarmenchantedProcedure {
    public static void execute(Level world, double x, double y, double z, LivingEntity entityHit, LivingEntity sourceEntity) {
        if (entityHit == null || sourceEntity == null) return;

        // 检查攻击者（sourceEntity）的主手物品是否带有Disarm附魔
        ItemStack sourceItemStack = sourceEntity.getMainHandItem();
        int disarmLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.DISARM.get(), sourceItemStack);

        if (disarmLevel != 0 && !world.isClientSide()) {
            // 创建掉落物实体
            ItemEntity itemToSpawn = new ItemEntity(world, x, y, z, entityHit.getMainHandItem());
            itemToSpawn.setPickUpDelay(10);
            world.addFreshEntity(itemToSpawn);

            // 目标实体失去手持物品
            ItemStack emptyStack = new ItemStack(Blocks.AIR);
            entityHit.setItemInHand(InteractionHand.MAIN_HAND, emptyStack);

            // 如果目标是玩家，则更新其背包状态
            if (entityHit instanceof Player player) {
                player.getInventory().setChanged();
            }
        }
    }
}