import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter
{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e)
	{
		String msg = e.getMessage().getContentRaw();
		
		//don't respond to self
		if(e.getAuthor().equals(e.getJDA().getSelfUser()))
			return;
		
		//stop command
		if(msg.equalsIgnoreCase(Main.PREFIX + "golfstop"))
		{
			e.getChannel().sendMessage("***Shutting down...***").queue();
			Main.jda.shutdown();
			System.exit(0);
		}
		
		e.getChannel().sendMessage("Interesting thought, my man.").queue();
	}
}
