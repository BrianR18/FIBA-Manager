package ui;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FIBA;


public class Main extends Application {

    private FIBAGUI FIBAGUI;
    private FIBA FIBA;

    public Main() throws ClassNotFoundException, IOException {
        FIBA = new FIBA();
        FIBAGUI = new FIBAGUI(FIBA);

    }
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Load.fxml"));

        fxmlLoader.setController(FIBAGUI);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);



        primaryStage.setScene(scene);


        primaryStage.setTitle("Federacion Internacional de Baloncesto");

        primaryStage.show();

    }



}
