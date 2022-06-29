package me.soarz.discordbridge.discord

import me.soarz.discordbridge.DiscordBridge
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.bukkit.ChatColor

class BotListener(private val instance: DiscordBridge) : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        instance.logger.info("Discord Bot connected!")
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (!event.isFromGuild) return
        if(event.author.isBot) return

        val channel: TextChannel = event.textChannel
        val author: User = event.author
        val content: String = event.message.contentRaw

        val channelId: Long = instance.config.getLong("main.chatChannelId")
        if(channel.idLong != channelId) return

        var formattedMessage: String = instance.config.getString("main.messages.test") ?: return
        formattedMessage = ChatColor.translateAlternateColorCodes('&', formattedMessage)

        formattedMessage.replace("%user%", author.name)
        formattedMessage.replace("%message%", content)

        channel.sendMessage(formattedMessage).queue()
    }


}