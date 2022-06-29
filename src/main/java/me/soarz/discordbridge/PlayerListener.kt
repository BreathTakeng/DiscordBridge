package me.soarz.discordbridge

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerListener(private val instance: DiscordBridge) : Listener {

    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        // TBD
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        // TBD
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        // TBD
    }

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        // TBD
    }

}