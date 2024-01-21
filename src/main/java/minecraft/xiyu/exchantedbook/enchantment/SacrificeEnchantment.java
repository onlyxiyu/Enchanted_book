
package minecraft.xiyu.exchantedbook.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SacrificeEnchantment extends Enchantment {
	public SacrificeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return level * 10;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}
