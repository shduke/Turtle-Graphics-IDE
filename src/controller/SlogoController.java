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
		bindUserInput(); 
	}
	
	public void bindUserInput(){
		ListChangeListener bind = new ListChangeListener(){
			@Override
			public void onChanged(ListChangeListener.Change c) {
				// TODO Auto-generated method stub
				SlogoController.this.myLastCommand = SlogoController.this.myDisplay.getHistory().getRecentCommand();
				System.out.println(SlogoController.this.myLastCommand);
			};
		};
		myDisplay.setHistoryBinding(bind);
	}
	
}
