/**
 * 
 */
package view;

import javafx.collections.ListChangeListener;
import view.slogoWindowElements.IHistory;
import view.slogoWindowElements.IVariablesAndCommands;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface ISlogoWindowView {

	public IHistory getHistory();
	
	public IVariablesAndCommands getVariablesAndCommands();
	
	public Display getTurtleDisplay();
	
	public String getLanguage();
	
	public void setHistoryBinding(ListChangeListener bind);
}
