/**
 * 
 */
package view.slogoWindowElements;

import javafx.scene.control.TextArea;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface IVariablesAndCommands {

	public TextArea getTextArea();
	
	public void clear();
	
	public void updateTextArea();
	
	public void addVariable(String varName, String varValue);
	
	public void addCommand(String commandName);
	
	public void addResults(String result);
	
}
