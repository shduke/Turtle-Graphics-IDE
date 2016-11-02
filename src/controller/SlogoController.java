package controller;

import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import cursor.CreatedItem;
import cursor.Cursor;
import cursor.CursorManager;
import cursor.Drawable;
import cursor.ICursor;
import javafx.collections.ListChangeListener;
import parser.ExpressionTree;
import parser.InputParser;
import view.ISlogoWindowView;

public class SlogoController {
	
	private ISlogoWindowView myDisplay; 
	private ICursor myCursor;
	private InputParser myParser; 
	private String myLastCommand; 
	private ExpressionTree myExpressionTree;  
	private List<Drawable> myDrawables;
	
	public SlogoController(ISlogoWindowView view){
		myDisplay = view; 
		myLastCommand = "";
		myCursor= new CursorManager();
		myParser = new InputParser(myDisplay.getLanguage());
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
					
					
					//receive information from backend
//					List<Drawable>createdItems = myCursors.get(0).myCreatedItems; 
					
					//List<Drawable>toFrontEnd = convertToDrawable(createdItems);
					
//					myDisplay.getTurtleDisplay().redrawAll(createdItems);
					myDisplay.getVariablesAndCommands().addOutput(consolePrint);
					//myDisplay.getVariablesAndCommands().updateTextArea();
				}
				catch (Exception e){
					
				}
				
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
	private List<Drawable> convertToDrawable(List<CreatedItem> items){
		List<Drawable>toFrontEnd=new ArrayList<>(); 
		for(int i=0;i<items.size();i++){
			toFrontEnd.add(items.get(i));
		}
		return toFrontEnd; 
	}
	
}