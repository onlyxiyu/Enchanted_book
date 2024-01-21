package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.Random;

@EventBusSubscriber(modid = "exchanted_book") // 替换为你的模组ID
public class ExperienceAndDurabilityHandler {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !event.player.level.isClientSide) { // 只在服务器端末尾阶段执行
			Player player = event.player;

			for (EquipmentSlot slot : EquipmentSlot.values()) {
				if (slot.getType() == EquipmentSlot.Type.ARMOR) { // 只检查盔甲槽位
					ItemStack armorPiece = player.getItemBySlot(slot);
					if (!armorPiece.isEmpty() && EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ARMOR_NEGATIVE_DEMON.get(), armorPiece) != 0) {
						int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ARMOR_NEGATIVE_DEMON.get(), armorPiece);
						int experienceToTakePerTick = enchantmentLevel * 2; // 根据需求决定每级附魔每tick扣除的经验值，这里假设是每级2点经验
						int durabilityLossPerTick = enchantmentLevel ; // 每级附魔每tick扣除的耐久度

						// 扣除经验值
						int newTotalXp = Math.max(0, player.totalExperience - experienceToTakePerTick); // 防止经验变为负数
						player.giveExperiencePoints(newTotalXp - player.totalExperience);

						// 扣除装备耐久度
						if (armorPiece.getDamageValue() + durabilityLossPerTick <= armorPiece.getMaxDamage()) {
							armorPiece.hurt(durabilityLossPerTick, new Random(), null);
						} else if (armorPiece.getDamageValue() < armorPiece.getMaxDamage()) {
							// 当耐久小于等于3时停止扣除
							int remainingDurability = armorPiece.getMaxDamage() - armorPiece.getDamageValue();
							armorPiece.setDamageValue(armorPiece.getDamageValue() + Math.min(remainingDurability, durabilityLossPerTick));
						}

						// 如果耐久降为0，则消耗掉该物品（如果是堆叠物品则减少一个）
						if (armorPiece.getDamageValue() >= armorPiece.getMaxDamage()) {
							armorPiece.shrink(1);
							player.setItemSlot(slot, ItemStack.EMPTY);
						}
					}
				}
			}
		}
	}
}