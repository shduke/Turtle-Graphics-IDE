/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @author Noel Moon (nm142)
 *
 */
public class ImagePalette extends Palette {

	public ImagePalette(List<String> imageList) {
		super();
		setRoot(makePalette(makeImageList(imageList)));
	}
	
	private List<Node> makeImageList(List<String> imageList) {
		List<Node> list = new ArrayList<Node>();
		for (int i=0; i<5; i++) {
			Image image;
			try {
				image = new Image(new FileInputStream(imageList.get(i)));
				ImageView iv = new ImageView(image);
				iv.setFitWidth(100);
				iv.setFitHeight(100);
				list.add(iv);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
