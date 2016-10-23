package controller;

import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import cursor.Cursor;
import cursor.Drawable;
import javafx.collections.ListChangeListener;
import parser.ExpressionTree;
import parser.InputParser;
import view.SlogoWindowView;

public class SlogoController {
	
	private SlogoWindowView myDisplay; 
	private InputParser myParser; 
	private String myLastCommand; 
	private ExpressionTree myExpressionTree; 
	private List<Cursor> myCursors; 
	
	public SlogoController(SlogoWindowView view){
		myDisplay = view; 
		myLastCommand = "";
		myCursors=new ArrayList<>();
		myCursors.add(new Cursor());
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
				myExpressionTree = myParser.parse(myLastCommand,myCursors.get(0));
				System.out.println(myExpressionTree);
				AbstractCommand command = myExpressionTree.createCommand();
				command.execute();
				
				//receive information from backend
				
				
				
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
}