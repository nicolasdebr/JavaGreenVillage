package com.mycompany.greenvillage.controllers;

import com.jfoenix.controls.JFXButton;
import com.mycompany.greenvillage.dal.Client;
import com.mycompany.greenvillage.dal.ClientDao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Page1Controller implements Initializable {

    @FXML
    private JFXButton Add_Button;
    @FXML
    private JFXButton Modify_Button;
    @FXML
    private JFXButton Detail_Button;
    @FXML
    private JFXButton Delete_Button;
    @FXML
    public TableView<Client> Lst_clients;
    @FXML
    private TableColumn<Client,String> col_Email;
    @FXML
    private TableColumn<Client,String> col_Lastname;
    @FXML
    private TableColumn<Client,String> col_Firstname;
    @FXML
    private TableColumn<Client,String> col_Adress;
    @FXML
    private TableColumn<Client,String> col_City;
    @FXML
    private TableColumn<Client,String> col_Country;
    @FXML
    private TableColumn<Client,String> col_Cp;
    @FXML
    private TableColumn<Client,Integer> col_role;
    ObservableList<Client> model = FXCollections.observableArrayList();
    List<Client> resultat = new ArrayList<Client>();
    @FXML
    private JFXButton refresh_button;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClientDao repo = new ClientDao ();
        resultat = repo.List();
        LoadTable(resultat);         
    }    
       

    @FXML
    private void Click_Add_Button(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../views/page2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Click_Modify_Button(ActionEvent event) throws IOException {
        Client mod =  Lst_clients.getSelectionModel().getSelectedItem(); 
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/page3.fxml"));
        Parent root = loader.load();
        Page3Controller controller3 =loader.getController(); 
        controller3.transferMessage(mod);
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();           
    }

    @FXML
    private void Click_Detail_Button(ActionEvent event) {
    }

    @FXML
    private void Click_Delete_Button(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Delete this client?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            ClientDao Cli = new ClientDao ();
            
            Client suppr =  Lst_clients.getSelectionModel().getSelectedItem();         
 
            Cli.delete(Cli.find(suppr.getId()));
            ClientDao repo = new ClientDao ();
            resultat = repo.List();
            LoadTable(resultat);   
        
        } else {
            // ... user chose CANCEL or closed the dialog
        }
            }

    @FXML
    private void refresh_button_click(ActionEvent event) {
        ClientDao repo = new ClientDao ();
        resultat = repo.List();
        LoadTable(resultat);   
    }
     public  void LoadTable (List resultat){
            model=FXCollections.observableArrayList(resultat);
            col_Email.setCellValueFactory(new PropertyValueFactory<Client,String>("Email"));       
            col_Lastname.setCellValueFactory(new PropertyValueFactory<Client,String>("Lastname"));
            col_Firstname.setCellValueFactory(new PropertyValueFactory<Client,String>("Firstname"));
            col_Adress.setCellValueFactory(new PropertyValueFactory<Client,String>("Adress"));
            col_City.setCellValueFactory(new PropertyValueFactory<Client,String>("City"));
            col_Cp.setCellValueFactory(new PropertyValueFactory<Client,String>("cp"));
            col_Country.setCellValueFactory(new PropertyValueFactory<Client,String>("Country"));
            col_role.setCellValueFactory(new PropertyValueFactory<Client,Integer>("role"));
            Lst_clients.setItems(model);
            
        }
        }
