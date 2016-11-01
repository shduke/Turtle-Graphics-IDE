package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Noel Moon (nm142)
 *
 */
public class BackgroundColorProperty extends Property {	
	
	private ComboBox<String> myComboBox;
	private Stage stage;
	private String myBackgroundColor;
	
	public BackgroundColorProperty() {
		super();
		myComboBox = new ComboBox<String>();
		setRoot(makeBackgroundColorDisplay());
	}
	
	public String getBackgroundColor() {
		return myBackgroundColor;
	}
	
	private ComboBox<String> makeBackgroundColorDisplay() {
        myComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myBackgroundColor = newValue;
            	stage.close();
            	
            	
            	
            }
        });
		return myComboBox;
	}

}
