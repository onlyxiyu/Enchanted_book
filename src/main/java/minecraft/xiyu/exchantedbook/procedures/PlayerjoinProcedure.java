package minecraft.xiyu.exchantedbook.procedures;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerjoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("=============================================================="), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u6B64\u9644\u9B54\u5DE5\u827A\u6A21\u7EC4\u7531\u9969\u96E8\u5236\u4F5C"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u5982\u6709\u60F3\u6CD5\u8BF7\u5728\u8BC4\u8BBA\u533A\u7559\u8A00"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u5982\u6709\u7591\u95EE\u6216\u8005\u53CD\u9988\uFF0C\u90A3\u5C31\u8BA9\u5B83\u4EEC\u70C2\u5728\u5634\u91CC\u5427\uFF01"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u795D\u4F60\u6E38\u73A9\u6109\u5FEBawa"), false);
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "function exchanted_book:loadmasseg");
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u70B9\u90A3\u4E2A\u94FE\u63A5\uFF08\u7F51\u6613\u7684\u8BDD\u53EF\u80FD\u4F1A\u663E\u793A******************\uFF09\u652F\u6301\u4E0B\u6211\u53EF\u4EE5\u5417\uFF1F\u5C51\u5C51qwq"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("=============================================================="), false);
	}
}
