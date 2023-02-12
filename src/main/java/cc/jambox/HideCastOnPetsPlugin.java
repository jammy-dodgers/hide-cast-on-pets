package cc.jambox;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@PluginDescriptor(
	name = "Hide casts on pets",
	description = "Hide ability to manually cast on pets"
)
public class HideCastOnPetsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Subscribe
	protected void onClientTick(ClientTick tick) {
		MenuEntry[] menuEntries = client.getMenuEntries();
		if (menuEntries.length == 0) return;
		MenuEntry[] optsWithoutFollowerCast =
				Arrays.stream(menuEntries).filter(x -> !(x.getNpc() != null && x.getNpc().getComposition().isFollower() && Text.standardize(x.getOption()).equals("cast"))).toArray(MenuEntry[]::new);
		for (MenuEntry menu: optsWithoutFollowerCast) {
 			client.setMenuEntries(optsWithoutFollowerCast);
		}
	}
}
