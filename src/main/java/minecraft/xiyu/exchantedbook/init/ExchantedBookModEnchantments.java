

package minecraft.xiyu.exchantedbook.init;

import minecraft.xiyu.exchantedbook.enchantment.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;


import minecraft.xiyu.exchantedbook.ExchantedBookMod;

public class ExchantedBookModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ExchantedBookMod.MODID);
	public static final RegistryObject<Enchantment> DISARM = REGISTRY.register("disarm", () -> new DisarmEnchantment());
	public static final RegistryObject<Enchantment> ATTACKSPEED = REGISTRY.register("attackspeed", () -> new AttackspeedEnchantment());
	public static final RegistryObject<Enchantment> ATTACKSPEEDLOW = REGISTRY.register("attackspeedlow", () -> new AttackspeedlowEnchantment());
	public static final RegistryObject<Enchantment> FROSTYTHORNS = REGISTRY.register("frostythorns", () -> new FrostythornsEnchantment());
	public static final RegistryObject<Enchantment> FIGHTBACKTHORNS = REGISTRY.register("fightbackthorns", () -> new FightbackthornsEnchantment());
	public static final RegistryObject<Enchantment> ETERNITY = REGISTRY.register("eternity", () -> new EternityEnchantment());
	public static final RegistryObject<Enchantment> SACRIFICE = REGISTRY.register("sacrifice", () -> new SacrificeEnchantment());
	public static final RegistryObject<Enchantment> ARTISANEXPLOSION = REGISTRY.register("artisanexplosion", () -> new ArtisanexplosionEnchantment());
	public static final RegistryObject<Enchantment> NTPT = REGISTRY.register("ntpt", () -> new NTPTEnchantment());
	public static final RegistryObject<Enchantment> ARMOR_NEGATIVE_DEMON = REGISTRY.register("armor_negative_demon", () -> new ArmorNegativeDemonEnchantment());

}
