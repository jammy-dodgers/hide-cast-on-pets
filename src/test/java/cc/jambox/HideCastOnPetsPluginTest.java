package cc.jambox;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HideCastOnPetsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HideCastOnPetsPlugin.class);
		RuneLite.main(args);
	}
}