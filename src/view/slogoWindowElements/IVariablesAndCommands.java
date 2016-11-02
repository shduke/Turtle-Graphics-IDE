/**
 * 
 */
package view.slogoWindowElements;

import java.util.HashMap;

import command.utility.IVariable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface IVariablesAndCommands {

	public VBox getVCDisplay();
	
	public void update(HashMap<String, IVariable> variables);
	
	public void clear();
	
	public void addOutput(String output);
	
}
