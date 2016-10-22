package controller;

import javafx.collections.ListChangeListener;
import parser.InputParser;
import view.SlogoWindowView;

public class SlogoController {
	
	private SlogoWindowView myDisplay; 
	private InputParser myParser; 
	private String myLastCommand; 
	
	public SlogoController(SlogoWindowView view){
		myDisplay = view; 
		myLastCommand = "";
		myParser = new InputParser();
		bindUserInput(); 
	}
	
	public void bindUserInput(){
		ListChangeListener bind = new ListChangeListener(){
			@Override
			public void onChanged(ListChangeListener.Change c) {
				// TODO Link fully to backend and command tree
				myLastCommand = myDisplay.getHistory().getRecentCommand();
				String lastCommandSymbol = myParser.getSymbol(myLastCommand);
				System.out.println(myLastCommand);
				System.out.println(lastCommandSymbol);
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
}
