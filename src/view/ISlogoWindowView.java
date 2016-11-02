/**
 * 
 */
package view;

import java.util.HashMap;

import command.utility.IVariable;
import cursor.ICursorManagerDisplay;
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

	public void updateInformation(ICursorManagerDisplay myCursorManager, HashMap<String, IVariable> variables);
}
