import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class RequestInfo extends ListenerAdapter
{
    public static Map<String, Integer> scoreBoard = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getContentRaw().contains("!post"))
        {
            event.getChannel().sendTyping().queue();

            if (!scoreBoard.containsKey(getNameOfSender(event)))
            {
                scoreBoard.put(getNameOfSender(event), 0);
                event.getChannel().sendMessage("Welcome to the spam game " + getNameOfSender(event) + "!").queue();
            }
            else
            {
                scoreBoard.put(getNameOfSender(event), scoreBoard.get(getNameOfSender(event)) + 1);
                event.getChannel().sendMessage("I have been called " + scoreBoard.get(getNameOfSender(event))
                        + isFirstTime(event) + getNameOfSender(event) + ", Noice!").queue();
            }
        }
    }

    private String isFirstTime(MessageReceivedEvent event)
    {
        return scoreBoard.get(getNameOfSender(event)) == 1 ? " time by " : " times by ";
    }

    private String getNameOfSender(MessageReceivedEvent event) { return event.getAuthor().getName(); }
}
