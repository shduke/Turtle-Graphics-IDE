package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

import javafx.scene.control.TextArea;

public class VariablesAndCommands {

	private TextArea myTextArea;
	private Map<String, String> myVariables;
	private List<String> myCommands;
	private List<String> myResults; 
	
	public VariablesAndCommands() {
		myTextArea = new TextArea();
		myTextArea.setPrefWidth(300);
		myTextArea.setEditable(false);
		myVariables = new TreeMap<String, String>();
		myCommands = new ArrayList<String>();
		myResults = new ArrayList<String>();
	}
	
    public TextArea getTextArea(){
    	updateTextArea();
    	return myTextArea;
    }
    
    public void clear() {
    	myTextArea.clear();
    	myVariables.clear();
    	myCommands.clear();
    	myResults.clear(); 
    }
    
    public void updateTextArea(){
    	myTextArea.clear();
    	myTextArea.appendText("Variables\n\n");
    	for (String var : myVariables.keySet()) {
    		myTextArea.appendText(var + " = " + myVariables.get(var) + "\n");
    	}
    	myTextArea.appendText("------------------------\n" + "Commands\n\n");
    	for (String commandName : myCommands) {
    		myTextArea.appendText(commandName + "\n");
    	}
    	myTextArea.appendText("------------------------\n" + "Console\n\n");
    	for(String result: myResults){
    		myTextArea.appendText(result + "\n");
    	}
    }
    
    public void addVariable(String varName, String varValue) {
    	myVariables.put(varName, varValue);
    }
    
    public void addCommand(String commandName) {
    	myCommands.add(commandName);
    }
    
    public void addResults(String result){
    	myResults.add(result);
    }
	
}
