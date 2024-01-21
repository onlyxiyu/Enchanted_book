package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Random;

public class ANDProcedure {
	public static void execute(Entity entity) {
		if (entity == null || !(entity instanceof LivingEntity livingEntity)) {
			return;
		}

		NonNullList<ItemStack> armorItems = (NonNullList<ItemStack>) livingEntity.getArmorSlots();

		for (ItemStack armor : armorItems) {
			int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ARMOR_NEGATIVE_DEMON.get(), armor);
			if (enchantmentLevel != 0) {
				if (entity instanceof Player player) {
					player.giveExperienceLevels(-(5));
				}

				Random random = new Random();
				if (armor.hurt(3, random, null)) {
					armor.shrink(1);
					armor.setDamageValue(0);
				}
			}
		}
	}
}