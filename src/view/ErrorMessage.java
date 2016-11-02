package view;

import java.awt.Dimension;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

/**
 * @author Noel Moon (nm142)
 *
 * Citations: http://code.makery.ch/blog/javafx-dialogs-official/
 *
 */
public class ErrorMessage implements IErrorMessage {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(1000, 700);
	
	private Alert myAlert;
	private String errorMessage;
	
	public ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		myAlert = new Alert(AlertType.INFORMATION, this.errorMessage);
		myAlert.setTitle("Error");
		myAlert.setHeaderText(null);
	}

	public void showError() {
		myAlert.showAndWait();
	}

}
