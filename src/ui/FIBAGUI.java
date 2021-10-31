package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Thread.Progress;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.FIBA;
import model.Player;

public class FIBAGUI {
	
	@FXML
	private ProgressBar jProgressbar1;
	
	@FXML
    private BorderPane pane;
	private FIBA FIBA;

	@FXML private TextField searchValue;
	@FXML private ChoiceBox<String> searchCriteria;
	@FXML private ListView<Player> playerFound;

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
	    void addPlayer(ActionEvent event) throws Exception{
		 
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
	    void behind(ActionEvent event) throws Exception {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
			fxmlLoader.setController(this);
			Parent login1 = fxmlLoader.load();
			pane.setCenter(login1);

	    }

		@FXML
		public void searchPlayer(){
		 	if(!searchValue.getText().isEmpty() && searchCriteria.getValue() != null){
				 try {
					 int key = Integer.parseInt(searchValue.getText());
					 ArrayList<Player> player = FIBA.searchPlayers(key,searchCriteria.getValue());
				 }catch(NumberFormatException  e){
					 launchAlert("Valor incorrecto","El valor de busquedad debe ser un entero");
				 }catch (IOException e){
					 launchAlert("Error inesperado","Ha ocurrido un error inesperado");
				 }
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
	    
	    //________________________________________________
	    
	    //_______-Daniel
	    @FXML
	    public void youNeedToFillTextFields(ActionEvent event) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Alert");
	        alert.setHeaderText(null);
	        alert.setContentText("Please fill in all the corresponding fields");
	        alert.showAndWait();
	    }
	    
	    
	    @FXML
	    public void userSuccesfullyRegistered(ActionEvent event) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Information");
	        alert.setHeaderText(null);
	        alert.setContentText("User successfully registered");
	        alert.showAndWait();
	    }



	@FXML
	void Exp(ActionEvent event) {

	}

	@FXML
	void Imp(ActionEvent event) {

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
	    }



	    
	    @FXML
	        public void initializeTabbleViewAccessories() {
	        	ObservableList<Accessories> observableList;
	        	observableList =  FXCollections.observableArrayList(market.getAcc());

	        	tableAccessoriesSeller.setItems(observableList);
	        	tcNameAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Name"));
	        	tcCodeAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Code"));
	        	tcPriceAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,Double>("Price"));
	        	tcBrandAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Brand"));
	        	tcTypeAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Type"));
	        }*/


}
