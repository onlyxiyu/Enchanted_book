
package minecraft.xiyu.exchantedbook.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;

import java.util.List;

public class AttackspeedlowEnchantment extends Enchantment {
	public AttackspeedlowEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return !List.of(ExchantedBookModEnchantments.ATTACKSPEED.get()).contains(ench);
	}

	@Override
	public boolean isCurse() {
		return true;
	}
}
