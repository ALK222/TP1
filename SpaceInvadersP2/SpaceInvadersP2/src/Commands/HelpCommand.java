package Commands;

import logic.Game;

public class HelpCommand extends Commands{
	
	
	//CONSTRUCTOR
		public HelpCommand (String name, String shortcut, String details, String help) {
			super(name, shortcut, details, help);
		}

		@Override
		public boolean execute(Game game) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Commands Parse(String[] commandWord) {
			// TODO Auto-generated method stub
			return null;
		}
}