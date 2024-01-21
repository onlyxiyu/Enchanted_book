package minecraft.xiyu.exchantedbook.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments;

public class AttackspeedlowsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity sss = null;
		if (EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ATTACKSPEED.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ATTACKSPEEDLOW.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ATTACKSPEEDLOW.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "attribute @s minecraft:generic.attack_speed base set 2.9");
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ATTACKSPEEDLOW.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "attribute @s minecraft:generic.attack_speed base set 2.7");
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(ExchantedBookModEnchantments.ATTACKSPEEDLOW.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "attribute @s minecraft:generic.attack_speed base set 2.5");
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "attribute @s minecraft:generic.attack_speed base set 4");
			}
		}
	}
}
