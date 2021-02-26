import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main
{
    public static String token = "YOUR KEY HERE";

    public static void main(String[] args) throws LoginException
    {
        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.setActivity(Activity.playing("YouTube"));
        jdaBuilder.addEventListeners(new RequestInfo());
        jdaBuilder.build();
    }
}
