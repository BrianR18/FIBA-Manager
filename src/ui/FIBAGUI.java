package ui;

import java.io.IOException;

import Thread.Progress;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import model.FIBA;



public class FIBAGUI {

    @FXML
    private ProgressBar jProgressbar1;

    @FXML
    private BorderPane pane;

    private FIBA FIBA;

    public FIBAGUI(FIBA controller) {
        FIBA = controller;
    }




    @FXML
    public void init(ActionEvent event) throws IOException, InterruptedException {
        Progress pr = new Progress(this, jProgressbar1);
        pr.start();

    }



    public void loadLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        fxmlLoader.setController(this);
        Parent login1 = fxmlLoader.load();
        pane.setCenter(login1);
        pane.setLayoutX(180);
        pane.setLayoutY(180);

    }




    @FXML
    void addPlayer(ActionEvent event) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPlayer.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        pane.setCenter(form);

    }

    @FXML
    void confi(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Config.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        pane.setCenter(form);

    }

    @FXML
    void sherchPlayer(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Serch.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        pane.setCenter(form);

    }

    @FXML
    void behind(ActionEvent event) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        fxmlLoader.setController(this);
        Parent login1 = fxmlLoader.load();
        pane.setCenter(login1);

    }


}
