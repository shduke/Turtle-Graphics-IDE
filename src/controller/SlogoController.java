package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import command.AbstractCommand;
import command.utility.IVariable;
import cursor.CreatedItem;
import cursor.Cursor;
import cursor.IDrawable;
import cursor.CursorManager;
import cursor.ICursor;
import cursor.ICursorManagerDisplay;
import javafx.collections.ListChangeListener;
import javafx.scene.paint.Color;
import parser.ExpressionTree;
import parser.InputParser;
import view.ErrorMessage;
import view.IErrorMessage;
import view.ISlogoWindowView;

public class SlogoController {
	
	private ISlogoWindowView myDisplay; 
	private ICursorManagerDisplay myCursorManager;
	private ICursor myCursor; 
	private InputParser myParser; 
	private String myLastCommand; 

	private ExpressionTree myExpressionTree;  
	private HashMap<String, IVariable> myGlobalVariableMap; 

	
	public SlogoController(ISlogoWindowView view){
		myDisplay = view; 
		myLastCommand = "";
		myCursorManager= new CursorManager();
		myCursor = (ICursor) myCursorManager; 
		myGlobalVariableMap = new HashMap<>(); 
		myParser = new InputParser(myDisplay.getLanguage(), myGlobalVariableMap);
		bindUserInput(); 
	}
	
	public void bindUserInput(){
		ListChangeListener bind = new ListChangeListener(){
			@Override
			public void onChanged(ListChangeListener.Change c) {
				// TODO Link fully to backend and command tree
				try{
					myLastCommand = myDisplay.getHistory().getRecentCommand();
					myExpressionTree = myParser.parse(myLastCommand,myCursor);
					System.out.println(myExpressionTree);
					AbstractCommand command = myExpressionTree.createCommand();
					double result = command.execute();
					
					String consolePrint = command.toString()+" " + result; 
					System.out.println("im testing: "+consolePrint);
					
					//receive information from backend
					myDisplay.updateInformation(myCursorManager, myGlobalVariableMap);
					myDisplay.getVariablesAndCommands().addOutput(consolePrint);
					
					Color bgColor = myDisplay.getToolbar().getColor(myCursorManager.getBackGround());
					myDisplay.getTurtleDisplay().setBackgroundColor(bgColor);
					
					Color penColor = myDisplay.getToolbar().getColor(myCursorManager.getPen().getPenColor());
					myDisplay.getTurtleDisplay().setPenColor(penColor);
				}
				catch (Exception e){
					showErrorMessage(e.getMessage());
				}
				
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
	private void showErrorMessage(String message) {
		IErrorMessage em = new ErrorMessage(message);
		em.showError();
	}
	
	
}