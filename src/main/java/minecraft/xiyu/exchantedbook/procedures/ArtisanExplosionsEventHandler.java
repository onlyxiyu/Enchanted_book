package minecraft.xiyu.exchantedbook.procedures;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class ArtisanExplosionsEventHandler {
	private static final Random RANDOM = new Random();


	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event) {
		// 获取死亡实体和伤害来源实体
		LivingEntity killedEntity = event.getEntityLiving();
		LivingEntity attacker = killedEntity.getLastHurtByMob();

		if (attacker != null && attacker instanceof Player playerAttacker) {
			ItemStack mainHandItem = playerAttacker.getMainHandItem();
			int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ARTISANEXPLOSION.get(), mainHandItem);

			// 判断是否持有ARTISANEXPLOSION附魔且有一定概率触发爆炸效果
			if (enchantmentLevel > 0 && RANDOM.nextDouble() < ((float) enchantmentLevel / ExchantedBookModEnchantments.ARTISANEXPLOSION.get().getMaxLevel())) {
				// 给攻击者添加临时的爆炸抗性（这里以5秒为例）
				playerAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, enchantmentLevel * 2));

				// 触发死亡实体的爆炸效果
				Level level = killedEntity.level;
				if (!level.isClientSide()) {
					float explosionRadius = 1.5f + enchantmentLevel;
					level.explode(null, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), explosionRadius, Explosion.BlockInteraction.NONE);
				}
			}
		}
	}
}