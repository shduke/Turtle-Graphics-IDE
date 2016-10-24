package controller;

import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import cursor.CreatedItem;
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
	private List<Drawable> myDrawables;
	
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
				System.out.println(myCursors.get(0).getCoordinate());
				List<CreatedItem>createdItems = myCursors.get(0).myCreatedItems; 
				List<Drawable>toFrontEnd = convertToDrawable(createdItems);
				
				myDisplay.getTurtleDisplay().redrawAll(toFrontEnd);
				
				
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