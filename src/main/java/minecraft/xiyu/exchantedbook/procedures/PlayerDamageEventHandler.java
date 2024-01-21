package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class PlayerDamageEventHandler {

	@SubscribeEvent
	public void onPlayerHurt(LivingDamageEvent event) {
		LivingEntity attackedEntity = event.getEntityLiving();
		Entity attacker;

		// 根据伤害源类型尝试获取攻击者实体
		DamageSource damageSource = event.getSource();
		if (damageSource.getEntity() instanceof Player || damageSource.getEntity() instanceof LivingEntity) {
			attacker = damageSource.getEntity();
		} else {

			return;
		}

		handleFightbackThorns(attackedEntity, (LivingEntity) attacker);
	}

	private static void handleFightbackThorns(LivingEntity attackedEntity, LivingEntity attacker) {
		// 获取装备栏能力
		IItemHandler itemHandler = attackedEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP)
				.orElse(null);

		for (int _idx = 0; _idx < itemHandler.getSlots(); _idx++) {
			ItemStack itemStack = itemHandler.getStackInSlot(_idx).copy();

			int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.FIGHTBACKTHORNS.get(), itemStack);

			if (enchantmentLevel > 0) {
				Vec3 attackerToAttacked = attacker.position().subtract(attackedEntity.position()).normalize();
				double knockbackDistance = enchantmentLevel * 1.5 + 0.75;

				DamageSource damageSource = DamageSource.playerAttack((Player) attacker);
				if (!attacker.isInvulnerableTo(damageSource)) {
					attacker.hurt(damageSource, enchantmentLevel);
				}

				// 添加击退效果
				attacker.push(attackerToAttacked.x * knockbackDistance, 0.1D, attackerToAttacked.z * knockbackDistance);
			}
		}
	}
}