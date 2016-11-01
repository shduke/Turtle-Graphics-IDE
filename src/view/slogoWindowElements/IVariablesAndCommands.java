/**
 * 
 */
package view.slogoWindowElements;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface IVariablesAndCommands {

	public VBox getVCDisplay();
	
	public void clear();
	
	public void addVariable(String varName, String varValue);
	
	public void addCommand(String commandName);
	
	public void addOutput(String output);
	
}
