package Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public abstract class Commands {
	
	//ATTRIBUTES
	
	protected final String name;
	protected final String shortcut;
	private final String details;
	private final String help;
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String IncorrectArgsMsg = "Incorrect argument format";
	
	//CONSTRUCTOR
	public Commands(String name, String shortcut, String details2, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details2;
		this.help = help;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	public abstract Commands parse(String[] commandWord) throws CommandParseException;
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) ||this.name.equalsIgnoreCase(name);
	}
	
	public String helpText() {
		return details + ": " + help + "\n";
	}
}
