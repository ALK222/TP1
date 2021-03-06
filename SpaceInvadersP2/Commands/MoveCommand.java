package commands;

import exceptions.CommandMovementException;
import exceptions.CommandParseException;
import logic.Game;

public class MoveCommand extends Command {

	private static String _name = "Move";
	private static String _shortcut = "m";
	private static String _details = "Moves the ship";
	private static String _help = "Introduce first the direction and then the speed";

	String dir;
	int vel;

	public MoveCommand(String name, String shortcut, String details, String help, String dir, String speed) {
		super(name, shortcut, details, help);
		this.dir = dir;
		this.vel = Integer.parseInt(speed);
	}

	public MoveCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) throws CommandMovementException {

		try {
			game.move(dir, vel);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public Command parse(String[] commandWord) throws CommandParseException, CommandMovementException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 3) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		} else if (!commandWord[2].equalsIgnoreCase("left") && !commandWord[2].equalsIgnoreCase("right")) {
			throw new CommandMovementException("I don't understand that direction");
		}
		return new MoveCommand(name, shortcut, details, help, commandWord[2], commandWord[1]);
	}

}
