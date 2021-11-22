package ui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class FIBAGUIEmergent {
    private FIBA fiba;
    private Player currentPlayer;
    @FXML private Label ChanceName;
    @FXML private Label ChanceYear;
    @FXML private Label ChanceEquipo;
    @FXML private Label pointMatchChance;
    @FXML private Label reboundsGamechance;
    @FXML private Label assistsGamechance;
    @FXML private Label stealGamechance;
    @FXML private Label blockGamechance;

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
        loadPlayerInformation();
        form.showAndWait();
    }//End showPlayerInformationWindow

    public void setCurrentPlayer(Player p){
        currentPlayer = p;
    }//End setCurrentPlayer

    private void loadPlayerInformation(){
        ChanceName.setText(currentPlayer.getName());
        ChanceYear.setText(currentPlayer.getAge()+"");
        ChanceEquipo.setText(currentPlayer.getTeam()+"");
        pointMatchChance.setText(currentPlayer.getPointMatch()+"");
        reboundsGamechance.setText(currentPlayer.getReboundsGame()+"");
        assistsGamechance.setText(currentPlayer.getAssistsGame()+"");
        stealGamechance.setText(currentPlayer.getStealGame()+"");
        blockGamechance.setText(currentPlayer.getBlockGame()+"");
    }
}//FIBAGUIEmergent
