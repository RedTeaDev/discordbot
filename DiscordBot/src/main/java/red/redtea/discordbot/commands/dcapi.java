package red.redtea.discordbot.commands;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import red.redtea.discordbot.Main;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;
import static red.redtea.discordbot.Main.jda;

public class dcapi extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Main.commandprefix)) {
            if (args[1].equalsIgnoreCase("dcapi")) {
                if (e.getAuthor().getId().equals("216127021028212737") || e.getAuthor().getId().equals("351149593888686081")) { //ColaIan = 216127021028212737 || RedTea = 351149593888686081 //
                    Logger.getLogger("Teapot").warning(e.getAuthor().getName() + e.getAuthor().getAsTag() + " <" + e.getAuthor().getId() + "> sent the \"/teapot dcapi\" command");
                    jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.playing("Disconnecting form Discord API...  "));
                    try{sleep(5000);} catch (Exception error){}
                    jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.playing("Disconnecting form Discord API...  "));
                    e.getChannel().sendMessage("Disconnecting form Discord API... Thank you and goodbye!").queue();
                    jda.shutdown();
                    Logger.getLogger("Teapot").warning("Teapot has been disconnected from Discord!");
                    Logger.getLogger("Teapot").info("System is Now Idle!");
                } else {
                    e.getChannel().sendMessage("Error:You do not have permission to execute this command!").queue();
                    Logger.getLogger("Teapot").warning(e.getAuthor().getAsTag() + " <" + e.getAuthor().getId() + "> tried the \"/teapot dcapi\" command, but failed. ( No Permission )");
                }
            }
        }
    }
}
