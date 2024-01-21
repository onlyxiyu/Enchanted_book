package minecraft.xiyu.exchantedbook.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

import static minecraft.xiyu.exchantedbook.ExchantedBookMod.MODID;

import static minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments.ATTACKSPEED;
import static java.lang.Math.log;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttackspeedEnchantmentEventHandler {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (!event.player.level.isClientSide && event.phase == TickEvent.Phase.END) {
			LivingEntity player = event.player;
			ItemStack currentItem = player.getMainHandItem();
			updateAttackSpeed(player, currentItem);
		}
	}

	private static void updateAttackSpeed(LivingEntity player, ItemStack itemStack) {
		int attackspeedLevel = getAttackspeedEnchantmentLevel(itemStack);

		AttributeInstance attackSpeedAttribute = player.getAttribute(Attributes.ATTACK_SPEED);
		float baseSpeed = (float) attackSpeedAttribute.getValue();
		float speedBoost = (float) (log(Math.E) / (attackspeedLevel + 1));

		attackSpeedAttribute.setBaseValue(baseSpeed + speedBoost);
	}

	private static int getAttackspeedEnchantmentLevel(ItemStack itemStack) {
		return 0;
	}
}