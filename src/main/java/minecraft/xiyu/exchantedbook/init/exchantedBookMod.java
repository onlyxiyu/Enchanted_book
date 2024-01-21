package minecraft.xiyu.exchantedbook.init;

import minecraft.xiyu.exchantedbook.enchantment.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static minecraft.xiyu.exchantedbook.init.ExchantedBookModEnchantments.REGISTRY;

@Mod(exchantedBookMod.MODID)
public class exchantedBookMod {

	public static final String MODID = "exchanged_book";

	// DeferredRegister for Enchantments
	public static final DeferredRegister<Enchantment> ENCHANTMENT_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

	// Register enchantments
	public static final RegistryObject<Enchantment> DISARM = ENCHANTMENT_REGISTRY.register("disarm", () -> new DisarmEnchantment());
	public static final RegistryObject<AttackspeedEnchantment> ATTACKSPEED = REGISTRY.register("attacks peed", () -> new AttackspeedEnchantment());
	public static final RegistryObject<AttackspeedlowEnchantment> ATTACKSPEEDLOW = REGISTRY.register("attackspeedlow", () -> new AttackspeedlowEnchantment());

	public static final RegistryObject<Enchantment> FROSTYTHORNS = ENCHANTMENT_REGISTRY.register("frostythorns", () -> new FrostythornsEnchantment());
	public static final RegistryObject<Enchantment> FIGHTBACKTHORNS = ENCHANTMENT_REGISTRY.register("fightbackthorns", () -> new FightbackthornsEnchantment());
	public static final RegistryObject<Enchantment> ETERNITY = ENCHANTMENT_REGISTRY.register("eternity", () -> new EternityEnchantment());
	public static final RegistryObject<Enchantment> SACRIFICE = ENCHANTMENT_REGISTRY.register("sacrifice", () -> new SacrificeEnchantment());
	public static final RegistryObject<Enchantment> ARTISANEXPLOSION = ENCHANTMENT_REGISTRY.register("artisanexplosion", () -> new ArtisanexplosionEnchantment());
	public static final RegistryObject<Enchantment> NTPT = ENCHANTMENT_REGISTRY.register("ntpt", () -> new NTPTEnchantment());
	public static final RegistryObject<Enchantment> ARMOR_NEGATIVE_DEMON = ENCHANTMENT_REGISTRY.register("armor_negative_demon", () -> new ArmorNegativeDemonEnchantment());

	public exchantedBookMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ENCHANTMENT_REGISTRY.register(modEventBus);

		// 注册事件处理器
		modEventBus.addListener(this::onCommonSetup);
	}

	private void onCommonSetup(FMLCommonSetupEvent event) {
		// Initialize the static references to the enchantments (请注意这里可能并不需要直接引用RegistryObject的实例)
		// ATTACKSPEEDLOW_ENCHANTMENT = ATTACKSPEEDLOW.get();
		// ATTACKSPEED_ENCHANTMENT = ATTACKSPEED.get();
	}
}