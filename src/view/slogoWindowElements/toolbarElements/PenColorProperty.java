package view.slogoWindowElements.toolbarElements;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class PenColorProperty extends Property {

	private ComboBox<String> myComboBox;
	private String myPenColor;
	
	public PenColorProperty() {
		super();
		myComboBox = new ComboBox<String>();
		setRoot(makePenColorDisplay());
		
	}
	
	public String getPenColor() {
		return myPenColor;
	}
	
	private ComboBox<String> makePenColorDisplay() {
        myComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myPenColor = newValue;
            	close();
            	
            	
            	
            }
        });
		return myComboBox;
	}

}
