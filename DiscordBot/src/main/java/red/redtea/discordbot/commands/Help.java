package red.redtea.discordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import red.redtea.discordbot.Main;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;
import static red.redtea.discordbot.Main.jda;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
    String[] args = e.getMessage().getContentRaw().split("\\s+");
    if (args[0].equalsIgnoreCase(Main.commandprefix)){
        if (args[1].equalsIgnoreCase("help")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Teapot Help");
            info.setDescription("Work in progress, bot by RedTea.");
            info.addField("Developer", "RedTea",false);
            info.setColor(0x6a1b9a);
            info.setFooter("Teapot v0.2 • By RedTea • " + e.getMessage().getTimeCreated(), e.getMember().getUser().getAvatarUrl());

            e.getChannel().sendTyping().queue();

            try{sleep(500);} catch (Exception error){}

            e.getChannel().sendMessage(info.build()).queue();
            info.clear();
            Logger.getLogger("Teapot").info(" Command \"/teapot help\" was successfully executed!");
        }
    }
}
}
