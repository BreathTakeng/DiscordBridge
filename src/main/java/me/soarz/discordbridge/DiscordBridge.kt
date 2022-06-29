package me.soarz.discordbridge

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class DiscordBridge : JavaPlugin(), Listener {
    private var instance: DiscordBridge? = null

    override fun onEnable() {
        if (!dataFolder.exists()) dataFolder.mkdir()

        // Setup global variables
        instance = this

        // Config
        this.saveDefaultConfig()

        // Setup Listener
        server.pluginManager.registerEvents(PlayerListener(this), this)

    }

    override fun onDisable() {
        // Shutdown Bot
    }

}