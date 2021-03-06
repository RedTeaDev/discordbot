package red.redtea.discordbot;

//Import jda

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

//import TeaPot commands,Please Do NOT REMOVE IT! it will cause Crash! 
//WARN: Remove it will cause Crash

import red.redtea.discordbot.commands.Help;
import red.redtea.discordbot.commands.Ping;
import red.redtea.discordbot.commands.Stop;
import red.redtea.discordbot.commands.dcapi;

//Import logger and some useful thing,Don't Remove it unless you know what you are doing!

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

//Main class,Remove will cause Bug

public class Main {

    //Command prefix and Colored Text

    public static JDA jda;
    public static String commandprefix = "/teapot"; // command prefix
    public static String Color_RED = "\u001B[31m"; // Color Red
    public static String Color_RESET = "\u001B[0m"; // Reset color
    public static String Color_GREEN = "\u001B[32m";  // Color Green
    public static String Color_PURPLE = "\u001B[35m"; // Color Purple

    public static void main(String[] args) throws LoginException {
        system.out.print("Logging in... Please Wait,DO NOT TRUN OFF YOUR PC!")
        System.out.print("Starting... \n");
        System.out.print("Power By RedTea,ColaIan\n");
        try{sleep(500);} catch (Exception error){}
        System.out.print(
                " #######               ######                   ######           ######                #######\n" +
                "    #    ######   ##   #     #  ####  #####      #     # #   #    #     # ###### #####     #    ######   ##\n" +
                "    #    #       #  #  #     # #    #   #        #     #  # #     #     # #      #    #    #    #       #  #\n" +
                "    #    #####  #    # ######  #    #   #        ######    #      ######  #####  #    #    #    #####  #    #\n" +
                "    #    #      ###### #       #    #   #        #     #   #      #   #   #      #    #    #    #      ######\n" +
                "    #    #      #    # #       #    #   #        #     #   #      #    #  #      #    #    #    #      #    #\n" +
                "    #    ###### #    # #        ####    #        ######    #      #     # ###### #####     #    ###### #    #\n" +
                " \n" +
                " Power By RedTea And Colaian(SuperColaTyphoon) \n"
        );
        //Logger

        Logger logger = Logger.getLogger("Teapot");
        FileHandler fh;

        // Set Logger Format
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-2s] %5$s %n");

        // check did /logs file exists or not,if NOT,Create it
        File directory = new File(FileSystems.getDefault().getPath("logs").toAbsolutePath().toString());
        File file  = new File(FileSystemjda.addEventListener(new Stop());s.getDefault().getPath("logs/Teapot.log").toAbsolutePath().toString());
        if(!directory.exists()){
            directory.mkdir();
            if(!file.exists()){
                file.getParentFile().mkdir();
                try {
                    file.createNewFile(); // Create a File,and rename it as /log
                } catch (Exception e) {} 
            }
        }

        //Logger

        try {

            // Logger Configuration (TimeStamp and DateFormat)

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            DateFormat dateformat = new DateFormat("yyyy-MM-dd_HH-mm-ss");
            fh = new FileHandler(FileSystems.getDefault().getPath("logs/Teapot_" + dateformat.format(timestamp) + ".log").toAbsolutePath().toString());
            logger.addHandler(fh);
            Formatter formatter = new Formatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) { //#NeedHelp What?! Security Exception? idk what is this... 
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace();
        }

        Logger.getLogger("Teapot").info("loading libraries..");

        //JDA - Configuration For Token and EventListener
        jda = new JDABuilder(AccountType.BOT)



                .setToken("Replace here") // DO NOT SHOW THIS Token to other

                .build();
        Logger.getLogger("Teapot").info("JDA - Login Successful!");
        Logger.getLogger("Teapot").info("TeaPot - a Discord Bot make with Java!");
        jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.listening(" Bot Starting... | Loading command.. "));
        Logger.getLogger("Teapot").info("JDA WebSocketClient - Connected to WebSocket");
        try{Logger.getLogger("Teapot").warning("Can NOT Login to Discord API,is token change or having rate limit?");} catch (Exception error){}

        Logger.getLogger("Teapot").info("JDA - Finished Loading!");

        Logger.getLogger("Teapot").info("loading EventLister...");

        //EventListener (add Command Here when you create a new file)
        //All command was saved at /Command file!
        
        jda.addEventListener(new Help());  // Command/Help.java
        jda.addEventListener(new Ping());  // Command/Ping.java
        jda.addEventListener(new Stop());  // Command/Stop.java
        jda.addEventListener(new dcapi()); // Command/dcapi.java

        Logger.getLogger("Teapot").info("all Command has been loaded!")
        Logger.getLogger("Teapot").info("Teapot has been successfully started!");

        //AutoChangeStatus

        while (true) { // change status,every 10 sec!
            try{sleep(10000);} catch (Exception error){}
            jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.listening( jda.getGuilds().size() + " Server(s) |  /teapot help  |  redtea.red"));
            try{sleep(10000);} catch (Exception error){}
            jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing( "with " + jda.getGuilds().size() + " Server(s) |  /teapot help  |  By RedTea | Thanks for using!"));
        }
    }
}
