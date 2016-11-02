package controller;

import java.util.HashMap;
import java.util.List;

import command.AbstractCommand;
import command.ICommand;
import command.IFirstCommand;
import command.utility.IVariable;
import cursor.CursorManager;
import cursor.ICursor;
import cursor.ICursorManagerDisplay;
import javafx.collections.ListChangeListener;
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
					IFirstCommand command = myExpressionTree.createCommand();
					
					String consolePrint = executeAndformOutput(command.getInnerCommands());
					
					//receive information from backend
					myDisplay.updateInformation(myCursorManager, myGlobalVariableMap);
					myDisplay.getVariablesAndCommands().addOutput(consolePrint);
				}
				catch (Exception e){
					showErrorMessage("Syntax Error!");
				}
				
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
	private String executeAndformOutput(List<ICommand>toExecute){
		String consoleOutput = "";
		for(int i=0;i<toExecute.size();i++){
			consoleOutput+=toExecute.get(i).toString()+" "+toExecute.get(i).execute()+"\n";
		}
		return consoleOutput; 
	}
	
	private void showErrorMessage(String message) {
		IErrorMessage em = new ErrorMessage(message);
		em.showError();
	}
	
	
}