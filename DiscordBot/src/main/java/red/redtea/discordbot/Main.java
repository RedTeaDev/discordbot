package red.redtea.discordbot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import red.redtea.discordbot.commands.Help;
import red.redtea.discordbot.commands.Ping;
import red.redtea.discordbot.commands.Stop;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.Thread.sleep;


public class Main {


    public static JDA jda;
    public static String commandprefix = "/teapot";
    public static String Color_RED = "\u001B[31m"; // Color Red
    public static String Color_RESET = "\u001B[0m"; // Reset color
    public static String Color_GREEN = "\u001B[32m";  // Color Green
    public static String Color_PURPLE = "\u001B[35m"; // Color Purple


    public static void main(String[] args) throws LoginException {
        System.out.print("Starting... \n");
        System.out.print("Power By RedTea,ColaIan\n");
        try{sleep(100);} catch (Exception error){}
        System.out.print(
                " #######               ######                   ######           ######                #######\n" +
                "    #    ######   ##   #     #  ####  #####      #     # #   #    #     # ###### #####     #    ######   ##\n" +
                "    #    #       #  #  #     # #    #   #        #     #  # #     #     # #      #    #    #    #       #  #\n" +
                "    #    #####  #    # ######  #    #   #        ######    #      ######  #####  #    #    #    #####  #    #\n" +
                "    #    #      ###### #       #    #   #        #     #   #      #   #   #      #    #    #    #      ######\n" +
                "    #    #      #    # #       #    #   #        #     #   #      #    #  #      #    #    #    #      #    #\n" +
                "    #    ###### #    # #        ####    #        ######    #      #     # ###### #####     #    ###### #    #\n"
        );
        //Logger
        Logger logger = Logger.getLogger("Teapot");
        FileHandler fh;

        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-2s] %5$s %n");

        // check did /logs file exists
        File directory = new File(FileSystems.getDefault().getPath("logs").toAbsolutePath().toString());
        File file  = new File(FileSystems.getDefault().getPath("logs/Teapot.log").toAbsolutePath().toString());
        if(!directory.exists()){
            directory.mkdir();
            if(!file.exists()){
                file.getParentFile().mkdir();
                try {
                    file.createNewFile();
                } catch (Exception e) {}
            }
        }

        //Logger

        try {
            // This block configure the logger with handler and formatter
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            fh = new FileHandler(FileSystems.getDefault().getPath("logs/Teapot_" + dateformat.format(timestamp) + ".log").toAbsolutePath().toString());
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //JDA
        jda = new JDABuilder(AccountType.BOT)
                .setToken("NjEyNjM0NzU4NzQ0MTEzMTgy.XVl-lA.H0SMVa4WNwvK317PLoEbRusMxYI") // DO NOT SHOW THIS Token to other
                .build();
        Logger.getLogger("Teapot").info("JDA - Login Successful!");
        jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.listening(" Bot Starting... "));
        Logger.getLogger("Teapot").info("JDA WebSocketClient - Connected to WebSocket");
        try{sleep(5000);} catch (Exception error){}

        Logger.getLogger("Teapot").info("JDA - Finished Loading!");

        Logger.getLogger("Teapot").info("loading EventLister...");

        //EventListener
        jda.addEventListener(new Help());
        jda.addEventListener(new Ping());
        jda.addEventListener(new Stop());

        Logger.getLogger("Teapot").info("Teapot has been successfully started!");
        while (true) { // change status
            try{sleep(10000);} catch (Exception error){}
            jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.listening( jda.getGuilds().size() + " Server(s) |  /teapot help  |  redtea.red"));
            try{sleep(10000);} catch (Exception error){}
            jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing( "with " + jda.getGuilds().size() + " Server(s) |  /teapot help  |  By RedTea | Thanks for using!"));
        }
    }
}