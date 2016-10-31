package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PenColorWindow implements Window {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);

	private Scene myScene;
	private ComboBox<String> myComboBox;
	private Stage myStage;
	private String myPenColor;
	
	public PenColorWindow() {
		BorderPane root = new BorderPane();
		myComboBox = new ComboBox<String>();
		root.setCenter(makeBackgroundColorDisplay());
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}

	@Override
	public Scene getScene() {
		return myScene;
	}
	
	public void start() {
		myStage = new Stage();
		myStage.setTitle("Choose Pen Color");
		myStage.setScene(getScene());
		myStage.show();
	}
	
	public void close() {
		myStage.close();
	}
	
	private ComboBox<String> makeBackgroundColorDisplay() {
        myComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myPenColor = newValue;
            	myStage.close();
            	
            	
            	
            }
        });
		return myComboBox;
	}

}
