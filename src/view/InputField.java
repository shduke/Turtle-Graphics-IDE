package view;

import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class InputField extends TextField {
    
    private ResourceBundle myResources;
    private TextField myInputField;
    
    
    public InputField(String language){
        myResources = ResourceBundle.getBundle(SlogoView.DEFAULT_RESOURCE_PACKAGE + language);
        HBox result = new HBox();
        EventHandler<ActionEvent> showHandler = new ShowPage();
        result.getChildren().add(makeButton("EnterCommand", showHandler));
        myInputField = makeInputField(40, showHandler);
        result.getChildren().add(myInputField);
    }
    
    private class ShowPage implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            //
        }
    }
    
    private TextField makeInputField (int width, EventHandler<ActionEvent> handler) {
        TextField result = new TextField();
        result.setPrefColumnCount(width);
        result.setOnAction(handler);
        return result;
    }
    
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        // represent all supported image suffixes
        final String IMAGEFILE_SUFFIXES =
                String.format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));

        Button result = new Button();
        String label = myResources.getString(property);
        if (label.matches(IMAGEFILE_SUFFIXES)) {
            result.setGraphic(new ImageView(
                                  new Image(getClass().getResourceAsStream(SlogoView.DEFAULT_RESOURCE_PACKAGE + label))));
        }
        else {
            result.setText(label);
        }
        result.setOnAction(handler);
        return result;
    }
}
