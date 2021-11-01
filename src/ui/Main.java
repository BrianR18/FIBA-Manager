package ui;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.FIBA;


public class Main extends Application{
	
	private FIBAGUI FIBAGUI;
	private FIBAGUIEmergent fe;
	private FIBA FIBA;
	
	public Main() throws ClassNotFoundException, IOException {
		FIBA = new FIBA();
		fe = new FIBAGUIEmergent(FIBA);
		FIBAGUI = new FIBAGUI(FIBA,fe);
		
	}
		public static void main(String[] args) {
			launch(args);

		}
		
		@Override
	    public void start(Stage primaryStage) throws Exception {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Load.fxml"));

			fxmlLoader.setController(FIBAGUI);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 1160, 650);
			Image icon= new Image("/ui/image/FIBA.jpeg");
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Federacion Internacional de Baloncesto");
			primaryStage.setResizable(false);
			primaryStage.show();
	    }
}
