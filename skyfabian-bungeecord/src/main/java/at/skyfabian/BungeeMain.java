package at.skyfabian;

import net.md_5.bungee.api.plugin.Plugin;

public final class BungeeMain extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("TEST-Bungee-ON");
    }

    @Override
    public void onDisable() {
        System.out.println("TEST-Bungee-off");
    }
}
