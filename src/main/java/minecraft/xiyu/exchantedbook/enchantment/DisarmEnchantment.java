
package minecraft.xiyu.exchantedbook.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;

public class DisarmEnchantment extends Enchantment {
	public DisarmEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return !List.of(Enchantments.FIRE_PROTECTION).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
