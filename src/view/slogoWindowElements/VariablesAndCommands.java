package view.slogoWindowElements;

import java.util.HashMap;

import command.utility.IVariable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class VariablesAndCommands implements IVariablesAndCommands {

	private TextArea myVariableTextArea;
	private TextArea myCommandTextArea;
	private TextArea myOutputTextArea;
	private VBox myVCDisplay;
	
	public VariablesAndCommands() {
		makeVCDisplay();
	}
	
    public VBox getVCDisplay() {
    	return myVCDisplay;
    }
    
    private VBox makeVCDisplay() {
    	myVCDisplay = new VBox();
    	myVariableTextArea = initTextArea(myVariableTextArea);
    	myCommandTextArea = initTextArea(myCommandTextArea);
    	myOutputTextArea = initTextArea(myOutputTextArea);
    	myVCDisplay.getChildren().add(new Label("Variables"));
    	myVCDisplay.getChildren().add(myVariableTextArea);
    	myVCDisplay.getChildren().add(new Label("Commands"));
    	myVCDisplay.getChildren().add(myCommandTextArea);
    	myVCDisplay.getChildren().add(new Label("Console Output"));
    	myVCDisplay.getChildren().add(myOutputTextArea);
    	return myVCDisplay;
    }
    
    private TextArea initTextArea(TextArea ta) {
    	ta = new TextArea();
		ta.setPrefWidth(300);
		ta.setEditable(false);
		return ta;
    }
    
    public void clear() {
    	myVariableTextArea.clear();
    	myCommandTextArea.clear();
    	myOutputTextArea.clear();
    }
    
    private void addVariable(String varName, String varValue) {
    	myVariableTextArea.appendText(varName + " = " + varValue + "\n");
    	//myVariableTextArea.appendText(varName + "\n");
    }
    
    private void addCommand(String commandName) {
    	myCommandTextArea.appendText(commandName + "\n");
    }
    
    public void addOutput(String output) {
    	myOutputTextArea.appendText(output+"\n");
    }

	@Override
	public void update(HashMap<String, IVariable> variables) {
		clear();
		for (String name : variables.keySet()) {
			if (name.startsWith(":")){
				if (variables.get(name).getLastResult() == 0.0){
					addVariable(name, "Processing...");
				} else {
					addVariable(name, String.valueOf((variables.get(name).getLastResult())));
				}
				
			}
			else {
				addCommand(name);
			}
		}
		
	}
	
}
