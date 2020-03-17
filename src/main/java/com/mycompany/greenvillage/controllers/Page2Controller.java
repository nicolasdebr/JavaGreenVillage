/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.mycompany.greenvillage.dal.Client;
import com.mycompany.greenvillage.dal.ClientDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 80010-59-10
 */
public class Page2Controller implements Initializable {

    @FXML
    private JFXTextField Email_input;
    @FXML
    private JFXTextField Firstname_input;
    @FXML
    private JFXTextField Lastname_input;
    @FXML
    private JFXTextField Adress_input;
    @FXML
    private JFXTextField City_input;
    @FXML
    private JFXTextField Cp_input;
    @FXML
    private JFXTextField Country_input;
    @FXML
    private JFXButton Add_button;
    @FXML
    private JFXButton Cancel_button_add;
    @FXML
    private Label label_verif_email;
    @FXML
    private Label label_verif_firstname;
    @FXML
    private Label label_verif_city;
    @FXML
    private Label label_verif_country;
    @FXML
    private Label label_verif_lastname;
    @FXML
    private Label label_verif_adress;
    @FXML
    private Label label_verif_cp;
    private boolean email;
    private boolean firstname;
    private boolean lastname;
    private boolean adress;
    private boolean city;
    private boolean cp;
    private boolean country;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void Email_released(KeyEvent event) {
        if(Email_input.getText().matches("^(.+)@(.+)$")){
            label_verif_email.setText("Ok");
            label_verif_email.setStyle("-fx-text-fill: green;");
            Email_input.setStyle("-fx-border-color: green ;");
            email = true;
        }
        else{
            label_verif_email.setText("Error");
            label_verif_email.setStyle("-fx-text-fill:red;");
            Email_input.setStyle("-fx-border-color: red ;");
            email = false;
        }
    }

    @FXML
    private void Firstname_released(KeyEvent event) {
        if(Firstname_input.getText().matches("[a-zA-Z]+")){
            label_verif_firstname.setText("Ok");
            label_verif_firstname.setStyle("-fx-text-fill: green;");
            Firstname_input.setStyle("-fx-border-color: green ;");
            firstname = true;
        }
        else{
            label_verif_firstname.setText("Error");
            label_verif_firstname.setStyle("-fx-text-fill:red;");
            Firstname_input.setStyle("-fx-border-color: red ;");
            firstname = false;
        }
    }


    @FXML
    private void Adress_released(KeyEvent event) {
        if(Adress_input.getText().matches("[a-zA-Z 0-9]+")){
            label_verif_adress.setText("Ok");
            label_verif_adress.setStyle("-fx-text-fill: green;");
            Firstname_input.setStyle("-fx-border-color: green ;");
            adress = true ;
        }
        else{
            label_verif_adress.setText("Error");
            label_verif_adress.setStyle("-fx-text-fill:red;");
            Adress_input.setStyle("-fx-border-color: red ;");
            adress = false;
        }
    }

    @FXML
    private void City_released(KeyEvent event) {
        if(City_input.getText().matches("[a-zA-Z]+")){
            label_verif_city.setText("Ok");
            label_verif_city.setStyle("-fx-text-fill: green;");
            City_input.setStyle("-fx-border-color: green ;");
            city = true;
        }
        else{
            label_verif_city.setText("Error");
            label_verif_city.setStyle("-fx-text-fill:red;");
            City_input.setStyle("-fx-border-color: red ;");
            city = false;
        }
    }

    @FXML
    private void Cp_released(KeyEvent event) {
         if(Cp_input.getText().matches("[0-9]{5,5}")){
            label_verif_cp.setText("Ok");
            label_verif_cp.setStyle("-fx-text-fill: green;");
            Cp_input.setStyle("-fx-border-color: green ;");
            cp = true;
        }
        else{
            label_verif_cp.setText("Error");
            label_verif_cp.setStyle("-fx-text-fill:red;");
            Cp_input.setStyle("-fx-border-color: red ;");
            cp = false;
        }
    }

    @FXML
    private void Country_released(KeyEvent event) {
        if(Country_input.getText().matches("[a-zA-Z]+")){
            label_verif_country.setText("Ok");
            label_verif_country.setStyle("-fx-text-fill: green;");
            Country_input.setStyle("-fx-border-color: green ;");
            country = true;
        }
        else{
            label_verif_country.setText("Error");
            label_verif_country.setStyle("-fx-text-fill:red;");
            Country_input.setStyle("-fx-border-color: red ;");
            country = false;
        }   
    }

    @FXML
    private void Add_button_click(ActionEvent event) {
        if(firstname == true && lastname == true && email == true && country == true && cp == true && city == true && adress == true){
            Client g= new Client();
            g.Lastname = Lastname_input.getText();
            g.Firstname = Firstname_input.getText();
            g.City = City_input.getText();
            g.Adress = Adress_input.getText();
            g.Email = Email_input.getText();
            g.role = 4;
            g.cp = Cp_input.getText();
            g.Country = Country_input.getText();
                     
            ClientDao Cli = new ClientDao ();
            Cli.Insert(g);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Ajout réussi GG");
            alert.showAndWait();   
            
            Stage stage =(Stage) Add_button.getScene().getWindow();
            stage.close();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs doivent être validés");
            alert.showAndWait();    
        } 
    }

    @FXML
    private void Cancel_button_add_click(ActionEvent event) {
        Stage stage =(Stage) Cancel_button_add.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Lastname_released(KeyEvent event) {
        if(Lastname_input.getText().matches("[a-zA-Z]+")){
            label_verif_lastname.setText("Ok");
            label_verif_lastname.setStyle("-fx-text-fill: green;");
            Lastname_input.setStyle("-fx-border-color: green ;");
            lastname = true;
        }
        else{
            label_verif_lastname.setText("Error");
            label_verif_lastname.setStyle("-fx-text-fill:red;");
            Lastname_input.setStyle("-fx-border-color: red ;");
            lastname = false ;
        }
    }
    
}
