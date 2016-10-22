package controller;

import javafx.collections.ListChangeListener;
import parser.ExpressionTree;
import parser.InputParser;
import view.SlogoWindowView;

public class SlogoController {
	
	private SlogoWindowView myDisplay; 
	private InputParser myParser; 
	private String myLastCommand; 
	private ExpressionTree myExpressionTree; 
	
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
				myExpressionTree = myParser.parse(myLastCommand);
				System.out.println(myExpressionTree);
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
}
