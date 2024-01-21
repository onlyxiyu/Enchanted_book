package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class FrostythornsSProcedure {
	public static void execute(Level world, Entity entity, @Nullable Entity sourceentity) {
		if (sourceentity == null || !sourceentity.isAlive()) return;

		// 获取实体装备栏能力
		IItemHandler itemHandler = entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
				.orElse(null);

		if (itemHandler != null) {
			for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
				ItemStack itemStack = itemHandler.getStackInSlot(slot).copy();

				int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.FROSTYTHORNS.get(), itemStack);

				if (enchantmentLevel > 0) {
					float damageMultiplier = enchantmentLevel >= 3 ? 7F : enchantmentLevel * 2 + 1; // 根据附魔等级计算伤害倍数
					sourceentity.hurt(DamageSource.GENERIC, damageMultiplier);

					if (sourceentity instanceof LivingEntity livingEntity) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, enchantmentLevel + 1, false, false));
					}
				}
			}
		}
	}

	public static void execute() {
	}
}