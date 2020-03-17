/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 80010-59-10
 */
public class Page3Controller implements Initializable {

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
    private JFXButton Modify_button;
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

    @FXML
    private JFXTextField id_client;
    ObservableList<Client> model = FXCollections.observableArrayList();
    List<Client> resultat = new ArrayList<Client>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        

    }    

    public void transferMessage(Client mod) {
        //Display the message
        Email_input.setText(mod.Email);
        Firstname_input.setText(mod.Firstname);
        Lastname_input.setText(mod.Lastname);
        Adress_input.setText(mod.Adress);
        City_input.setText(mod.City);
        Cp_input.setText(mod.cp);
        Country_input.setText(mod.Country);
        id_client.setText(Integer.toString(mod.Id));
        System.out.println(id_client.getText());
    }
    @FXML
    private void Email_released(KeyEvent event) {
        if(Email_input.getText().matches("^(.+)@(.+)$")){
            label_verif_email.setText("Ok");
            label_verif_email.setStyle("-fx-text-fill: green;");
            Email_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_email.setText("Error");
            label_verif_email.setStyle("-fx-text-fill:red;");
            Email_input.setStyle("-fx-border-color: red ;");
        }
    }

    @FXML
    private void Firstname_released(KeyEvent event) {
         if(Firstname_input.getText().matches("[a-zA-Z]+")){
            label_verif_firstname.setText("Ok");
            label_verif_firstname.setStyle("-fx-text-fill: green;");
            Firstname_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_firstname.setText("Error");
            label_verif_firstname.setStyle("-fx-text-fill:red;");
            Firstname_input.setStyle("-fx-border-color: red ;");
        }
    }

    @FXML
    private void Lastname_released(KeyEvent event) {
       if(Lastname_input.getText().matches("[a-zA-Z]+")){
            label_verif_lastname.setText("Ok");
            label_verif_lastname.setStyle("-fx-text-fill: green;");
            Lastname_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_lastname.setText("Error");
            label_verif_lastname.setStyle("-fx-text-fill:red;");
            Lastname_input.setStyle("-fx-border-color: red ;");
        } 
    }

    @FXML
    private void Adress_released(KeyEvent event) {
        if(Adress_input.getText().matches("[a-zA-Z 0-9]+")){
            label_verif_adress.setText("Ok");
            label_verif_adress.setStyle("-fx-text-fill: green;");
            Firstname_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_adress.setText("Error");
            label_verif_adress.setStyle("-fx-text-fill:red;");
            Adress_input.setStyle("-fx-border-color: red ;");
        }
    }

    @FXML
    private void City_released(KeyEvent event) {
        if(City_input.getText().matches("[a-zA-Z]+")){
            label_verif_city.setText("Ok");
            label_verif_city.setStyle("-fx-text-fill: green;");
            City_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_city.setText("Error");
            label_verif_city.setStyle("-fx-text-fill:red;");
            City_input.setStyle("-fx-border-color: red ;");
        }
    }

    @FXML
    private void Cp_released(KeyEvent event) {
        if(Cp_input.getText().matches("[0-9]{5,5}")){
            label_verif_cp.setText("Ok");
            label_verif_cp.setStyle("-fx-text-fill: green;");
            Cp_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_cp.setText("Error");
            label_verif_cp.setStyle("-fx-text-fill:red;");
            Cp_input.setStyle("-fx-border-color: red ;");
        }
    }

    @FXML
    private void Country_released(KeyEvent event) {
        if(Country_input.getText().matches("[a-zA-Z]+")){
            label_verif_country.setText("Ok");
            label_verif_country.setStyle("-fx-text-fill: green;");
            Country_input.setStyle("-fx-border-color: green ;");
        }
        else{
            label_verif_country.setText("Error");
            label_verif_country.setStyle("-fx-text-fill:red;");
            Country_input.setStyle("-fx-border-color: red ;");
        }   
    }

    @FXML
    private void Modify_button_click(ActionEvent event) {
        if(Firstname_input.getText().matches("[a-zA-Z]+") && Lastname_input.getText().matches("[a-zA-Z]+") && Email_input.getText().matches("^(.+)@(.+)$") && Country_input.getText().matches("[a-zA-Z]+") && Cp_input.getText().matches("[0-9]{5,5}") && City_input.getText().matches("[a-zA-Z]+") && Adress_input.getText().matches("[a-zA-Z 0-9]+")){
            Client g= new Client();
                g.Email = Email_input.getText();
                g.Lastname = Lastname_input.getText();
                g.Firstname = Firstname_input.getText();
                g.City = City_input.getText();
                g.cp = Cp_input.getText();
                g.Adress = Adress_input.getText();
                g.Country = Country_input.getText();
                g.Id= Integer.parseInt(id_client.getText().trim());
                System.out.println(g.Id);
                ClientDao Cli = new ClientDao ();
                Cli.update(g);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Modification réussie GG");
                alert.showAndWait();   
                Stage stage =(Stage) Modify_button.getScene().getWindow();
                stage.close();
        }
    }

    @FXML
    private void Cancel_button_mod_click(ActionEvent event) {
        Stage stage =(Stage) Cancel_button_add.getScene().getWindow();
        stage.close();
    }
    
}
