package view.slogoWindowElements;

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
    
    public void addVariable(String varName, String varValue) {
    	myVariableTextArea.appendText(varName + " = " + varValue);
    }
    
    public void addCommand(String commandName) {
    	myVariableTextArea.appendText(commandName);
    }
    
    public void addOutput(String output) {
    	myOutputTextArea.appendText(output+"\n");
    }
	
}
