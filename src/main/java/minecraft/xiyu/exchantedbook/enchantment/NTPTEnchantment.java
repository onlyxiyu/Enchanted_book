
package minecraft.xiyu.exchantedbook.enchantment;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;

public class NTPTEnchantment extends Enchantment {
	public NTPTEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR_CHEST, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return !List.of(ExchantedBookModEnchantments.FROSTYTHORNS.get(), ExchantedBookModEnchantments.FIGHTBACKTHORNS.get(), Enchantments.THORNS).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
