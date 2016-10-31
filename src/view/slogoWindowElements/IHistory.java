package view.slogoWindowElements;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public interface IHistory {

	public void setBinding(ListChangeListener bind);
	
	public void clear();
	
	public String getRecentCommand();
	
	public ObservableList<String> getAllCommands();
	
	public TextArea getTextArea();
	
	public VBox getHistory();
	
	public void addHistory(String input);
}
