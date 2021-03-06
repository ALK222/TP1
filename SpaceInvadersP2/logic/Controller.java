package logic;

import java.io.IOException;
import java.util.Scanner;

import commands.Command;
import commands.CommandGenerator;
import exceptions.*;
import utils.BoardPrinter;
import utils.Stringifier;
import interfaces.GamePrinter;;

public class Controller {

	/*
	 * 
	 * Logic behind the game
	 * 
	 */

	// ATTRIBUTES

	private Game game;

	private Scanner in;

	private GamePrinter printer;

	private String prompt = "Command >";

	// CONSTRUCTOR

	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.printer = new BoardPrinter(game, Game.DIM_Y, Game.DIM_X);
	}

	public void run() {
		while (!game.isFinished()) {
			System.out.print(prompt);
			String[] words = in.nextLine().trim().split("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						game.update();
						printGame();
					} else if (words[0].charAt(0) == 'r') {
						printGame();
					}
				}
			} catch (CommandParseException | CommandExecuteException | IOException | CommandMovementException ex) {
				System.out.format((ex).getMessage() + "%n%n");
			}
		}
	}

	public void printGame() {
		if (game.getPrinterOption() == 'b') {
			this.printer = new BoardPrinter(this.game, Game.DIM_Y, Game.DIM_X);
			System.out.println(printer.toString(game));
		} else {
			this.printer = new Stringifier(game);
			System.out.println(printer.toString(game));
		}
	}

}
