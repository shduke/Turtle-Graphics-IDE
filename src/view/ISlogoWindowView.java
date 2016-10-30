/**
 * 
 */
package view;

import javafx.collections.ListChangeListener;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface ISlogoWindowView {

	public History getHistory();
	
	public Display getTurtleDisplay();
	
	public String getLanguage();
	
	public VariablesAndCommands getVariablesAndCommands();
	
	public void setHistoryBinding(ListChangeListener bind);
}
