package mattmc.mankini.module;

import mattmc.mankini.MankiniBot;
import mattmc.mankini.utils.MinecraftServer;
import mattmc.mankini.utils.ModUtils;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Project MrBot
 * Created by MattsMc on 6/2/14.
 */

public class ModuleMinecraft extends ListenerAdapter<PircBotX> {
    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        if(event.getMessage().split(" ")[0].equalsIgnoreCase("!players")){
            if(ModUtils.moderators.contains(event.getUser().getNick()) || event.getUser().getNick().equalsIgnoreCase(MankiniBot.Owner) || (boolean)ModuleRegular.class.getMethod("isRegular", String.class).invoke(ModuleRegular.class.newInstance(), event.getUser().getNick())){
                if(event.getMessage().length() >=2){
                    MinecraftServer server = new MinecraftServer("runew0lf.com");
                    if(!server.parseData(MinecraftServer.Connection.PING).equalsIgnoreCase("Nothing Found! Please check if the server is on!")){
                        event.getChannel().send().message(server.parseData(MinecraftServer.Connection.PLAYERS_ONLINE));
                    } else {
                        event.respond("Nothing Found! Please check if the server is on!");
                }
                }
            }
        }
    }
}
