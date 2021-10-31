package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Thread.Progress;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.FIBA;
import model.Player;

public class FIBAGUI {

	@FXML
	private ProgressBar jProgressbar1;

	@FXML
	private BorderPane pane;
	private FIBA FIBA;

	//Main Interface attributes
	@FXML private Button addPlayerPrincipalButton;
	@FXML private Button searchPlayerPrincipal;
	@FXML private Button configPlayerPrincipal;

	//Search Interface attributes
	@FXML private Button addPlayerSceneButton;
	@FXML private Button configurationSceneButton;
	@FXML private Button addPlayerButton;
	@FXML private ImageView searchPlayerButton;
	@FXML private Button searchPlayerSceneButton;
	@FXML private Button configurationButton;
	@FXML private TextField searchValue;
	@FXML private ChoiceBox<String> searchCriteria;
	@FXML private ListView<Player> playerFound;

	//Add Player Variables
	@FXML private TextField addName;
	@FXML private TextField AddYear;
	@FXML private TextField AddEquipo;
	@FXML private TextField addEsta1; //pointMatch
	@FXML private TextField addEsta2; //assistGame
	@FXML private TextField addEsta3; //reboundsGame
	@FXML private TextField addEsta4; //steelGame
	@FXML private TextField addEsta5; //blockGame
	//~~~~~~~~~~~~~~~~~~~~~~

	public FIBAGUI(FIBA controller) {
		FIBA = controller;
	}


	//__________________________Abrir y navegar por las interfaces_________________________

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


		//pane.setLayoutX(180);
		//pane.setLayoutY(180);

	}
	//A


	private void loadSearchCriteria(){
		List<String> c = new ArrayList<>();
		c.add("BLOQUEOS");
		c.add("PUNTOS");
		c.add("ASISTENCIAS");
		c.add("ROBOS");
		c.add("REBOTES");
		ObservableList<String> criterian  = FXCollections.observableList(c);
		searchCriteria.setItems(criterian);
	}//End loadSearchCriteria


	@FXML
	void addPlayer(ActionEvent event) throws IOException{

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPlayer.fxml"));
		fxmlLoader.setController(this);
		Parent form = fxmlLoader.load();
		pane.setCenter(form);
		Stage st = (Stage) form.getScene().getWindow();
		st.setWidth(1200);
		st.setHeight(690);

	}

	@FXML
	void confi(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Config.fxml"));
		fxmlLoader.setController(this);
		Parent form = fxmlLoader.load();
		pane.setCenter(form);
		Stage st = (Stage) form.getScene().getWindow();
		st.setWidth(1200);
		st.setHeight(690);

	}

	@FXML
	public void credits(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText(null);
		alert.setContentText("Creditos a" +
				"\nBrian Stiven Romero" +
				"\nDaniel Ramirez" +
				"\nSebastian Navia");

		alert.showAndWait();
	}

	@FXML
	void infoApli(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("FIBA-Manager");
		alert.setHeaderText(null);
		alert.setContentText("        " +
				"\nAplicacion para gestionar base de datos" +
				"\nde jugadores de basketbol,  registrados " +
				"\nen la FIBA");

		alert.showAndWait();
	}


	@FXML
	void sherchPlayer(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search.fxml"));
		fxmlLoader.setController(this);
		Parent form = fxmlLoader.load();
		pane.setCenter(form);
		Stage st = (Stage) form.getScene().getWindow();
		st.setWidth(1200);
		st.setHeight(690);
		loadSearchCriteria();
	}//End sherchPlayer

	@FXML
	public void behind(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}
	@FXML
	public void focusButton(){
		searchPlayerButton.setOpacity(0.68);
	}//End focusButton
	@FXML
	public void unFocusButton(){
		searchPlayerButton.setOpacity(1);
	}//End focusButton
	//Tremendo commit inutil
	@FXML
	public void searchPlayer(){
		if(!searchValue.getText().isEmpty() && searchCriteria.getValue() != null){
			try {
				int key = Integer.parseInt(searchValue.getText());
				ArrayList<Player> p = FIBA.searchPlayers(key,searchCriteria.getValue());
				ObservableList<Player> player = FXCollections.observableList(p);
				playerFound.setItems(player);
			}catch(NumberFormatException  e){
				launchAlert("Valor incorrecto","El valor de busquedad debe ser un entero");
			}catch (IOException e){
				launchAlert("Error inesperado","Ha ocurrido un error inesperado");
			}//End try..catch
		}else{
			launchAlert("Valores incorrectos","Debes de llenar todos los campos");
		}//end else
	}//End searchPlayer

	@FXML
	public void launchAlert(String title,String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	/*@FXML
    void behind(ActionEvent event)throws Exception{

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Exit.fxml"));
            Parent root = fxmlLoader.load();


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex) {

            Logger.getLogger(FIBAGUI.class.getName()).log(Level.SEVERE,null, ex);

        }
    }*/
	@FXML
	void Cancel(ActionEvent event) {

	}

	@FXML
	void SaveExit(ActionEvent event) {

	}

	//alerts~~~~~~~~~~~~~
	@FXML
	public void youNeedToFillTextFields(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText(null);
		alert.setContentText("Please fill in all the corresponding fields");
		alert.showAndWait();
	}

	@FXML
	public void userSuccessfullyRegistered(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Usuario existosamente registrado");
		alert.showAndWait();
	}

	@FXML
	public void verifyIsNumeric(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText(null);
		alert.setContentText("Porfavor verifique que los campos de estadisticas y años sean numericos");

		alert.showAndWait();
	}
//~~~~~~~~~~~~~~~~~~~~~~~

	@FXML
	void Imp(ActionEvent event) {

	}

	public void addPlayerMethod(ActionEvent event) throws IOException {
		if (!addName.getText().equals("") && !AddYear.getText().equals("") && !AddEquipo.getText().equals("") &&
				!addEsta1.getText().equals("") && !addEsta2.getText().equals("") && !addEsta3.getText().equals("") &&
				!addEsta4.getText().equals("") && !addEsta5.getText().equals("")) {
			boolean isPointMatchNumeric = addEsta1.getText().matches("[+-]?\\d*(\\.\\d+)?");
			boolean isAssistGameNumeric = addEsta2.getText().matches("[+-]?\\d*(\\.\\d+)?");
			boolean isReboundGameNumeric = addEsta3.getText().matches("[+-]?\\d*(\\.\\d+)?");
			boolean isSteelGameNumeric = addEsta4.getText().matches("[+-]?\\d*(\\.\\d+)?");
			boolean isBlockGameNumeric = addEsta5.getText().matches("[+-]?\\d*(\\.\\d+)?");
			boolean isYearNumeric = AddYear.getText().matches("[+-]?\\d*(\\.\\d+)?");
			if(isPointMatchNumeric==true && isAssistGameNumeric ==true && isReboundGameNumeric==true &&
					isSteelGameNumeric==true && isBlockGameNumeric==true && isYearNumeric==true) {
				int pointMatch = Integer.parseInt(addEsta1.getText());
				int assistGame = Integer.parseInt(addEsta2.getText());
				int reboundsGame = Integer.parseInt(addEsta3.getText());
				int steelGame = Integer.parseInt(addEsta4.getText());
				int blockGame = Integer.parseInt(addEsta5.getText());
				int year = Integer.parseInt(AddYear.getText());
				FIBA.addPlayer(addName.getText(), year, AddEquipo.getText(), pointMatch, assistGame, reboundsGame, steelGame, blockGame);
				userSuccessfullyRegistered(event);
				emptyFieldAddPlayer();
			}else{
				verifyIsNumeric(event);
			}
		} else {
			youNeedToFillTextFields(event);
		}
	}

	public void emptyFieldAddPlayer(){
		addName.setText("");
		AddYear.setText("");
		AddEquipo.setText("");
		addEsta1.setText("");
		addEsta5.setText("");
		addEsta4.setText("");
		addEsta3.setText("");
		addEsta2.setText("");
	}


	   /* public void addClotheShirt(ActionEvent event) throws IOException {
	        if (!txtShirtFabricType.getText().equals("") && !txtShirtStyle.getText().equals("") && !txtShirtType.getText().equals("")) {
	            int price = Integer.parseInt(txtClothesPrice.getText());
	            int quantity = Integer.parseInt(txtClothesQuantity.getText());
	            market.addClothingShirt(txtShirtFabricType.getText(), txtShirtType.getText(), txtClothesName.getText(), txtClothesCode.getText(), txtClothesMark.getText(), price, txtClothesSize.getText(), txtClothePathImage.getText(), txtClothesDescription.getText(), quantity, txtClothesColor.getText(), txtClothesGender.getText(), txtClothesType.getText());
	            market.saveDataClothings();
	            clothingCorrectlyCreated(event);
	            emptyFieldsClothing();
	            emptyFieldsShirt();
	            loadAddClothes(event);
	        } else {
	            youNeedToFillTextFields(event);
	        }
	    }*/







	/*@FXML
	private void initializeTableViewPlayers() {
		ObservableList<Player> observableList;
		observableList = FXCollections.observableArrayList(FIBA.getPlayer());
		tablePlayers.setItems(observableList);

		colName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		colAge.setCellValueFactory(new PropertyValueFactory<Player, String>("age"));
		colTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("Team"));
		colPointMatch.setCellValueFactory(new PropertyValueFactory<Player, String>("pointMatch"));
		colReboundsGame.setCellValueFactory(new PropertyValueFactory<Player, String>("reboundsGame"));
		colAssistsGame.setCellValueFactory(new PropertyValueFactory<Player, String>("assistsGame"));
		colStealGame.setCellValueFactory(new PropertyValueFactory<Player, String>("stealGame"));
		colBlockGame.setCellValueFactory(new PropertyValueFactory<Player, String>("blockGame"));


	}*/



}
