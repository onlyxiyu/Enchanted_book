
package minecraft.xiyu.exchantedbook.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;

import java.util.List;

public class AttackspeedEnchantment extends Enchantment {
	public AttackspeedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return !List.of(ExchantedBookModEnchantments.ATTACKSPEEDLOW.get()).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}
