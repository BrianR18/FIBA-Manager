package ui;

import java.io.IOException;

import Thread.Progress;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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



	    
	    @FXML
	        public void initializeTabbleViewAccessories() {
//	        	ObservableList<Accessories> observableList;
//	        	observableList =  FXCollections.observableArrayList(market.getAcc());
//
//	        	tableAccessoriesSeller.setItems(observableList);
//	        	tcNameAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Name"));
//	        	tcCodeAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Code"));
//	        	tcPriceAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,Double>("Price"));
//	        	tcBrandAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Brand"));
//	        	tcTypeAccessoriesSeller.setCellValueFactory(new PropertyValueFactory<Accessories,String>("Type"));
	        }


}
