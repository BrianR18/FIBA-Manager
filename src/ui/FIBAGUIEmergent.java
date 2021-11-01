package ui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class FIBAGUIEmergent {
    private FIBA fiba;
    private Player currentPlayer;

    public FIBAGUIEmergent(FIBA f){
        fiba = f;
    }//End constructor

    @FXML
    public void showPlayerInformationWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Information.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion del jugador");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/image/FIBA.jpeg"));
        form.showAndWait();
    }//End showPlayerInformationWindow

    public void setCurrentPlayer(Player p){
        currentPlayer = p;
    }//End setCurrentPlayer

}//FIBAGUIEmergent
