package red.redtea.discordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import red.redtea.discordbot.Main;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String message = e.getMessage().getContentRaw();
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        long start = System.currentTimeMillis();
        if (args[0].equalsIgnoreCase(Main.commandprefix)) {
            if (args[1].equalsIgnoreCase("ping")) {
                Logger.getLogger("Teapot").info(e.getAuthor().getAsTag() + " <" + e.getAuthor().getId() + "> sent the \"/teapot ping\" command");

                e.getChannel().sendMessage("Getting ping..").queue();
                try{sleep(700);} catch (Exception error){}

                e.getChannel().sendMessage("Pong!").queue(
                        msg->e.getChannel().sendMessage(new EmbedBuilder()
                                .setColor(0x6a1b9a)
                                .addField("Ping:","**Discord API:** " + e.getJDA().getGatewayPing() + "ms\n" +
                                        "**You:** " + (msg.getTimeCreated().getNano() / 1000000 - (e.getMessage().getTimeCreated().getNano() / 1000000)) +"ms",false)
                                .build()).queue());

            }
        }
    }
}
