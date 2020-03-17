/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;

/**
 *
 * @author 80010-59-10
 */
public class ClientDao {
    
    public   String url = "jdbc:mysql://localhost:3306/rouge?serverTimezone=UTC";

    public ClientDao(){
      
    }
     
    public void Insert(Client c) {

        try {
            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement stm = con.prepareStatement("INSERT INTO customer (cus_email, cus_name,cus_prenom,cus_adress,cus_cdp,cus_ville,cus_pays,cus_role) VALUES (?,?,?,?,?,?,?,?)");

            stm.setString(1, c.getEmail());
            stm.setString(2, c.getLastname());
            stm.setString(3, c.getFirstname());
            stm.setString(4, c.getAdress()); 
            stm.setString(5, c.getCp()); 
            stm.setString(6, c.getCity());
            stm.setString(7, c.getCountry());
            stm.setInt(8, c.getRole()); 
            stm.execute();

            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(e.getMessage());
        }
        
    }
       
    
    public void update(Client c){
       
       try{     
       Connection con = DriverManager.getConnection(url, "root", "");     
       PreparedStatement stm = con.prepareStatement("UPDATE customer SET cus_email=?,cus_name=?,cus_prenom=?,cus_adress=?,cus_cdp=?,cus_ville=?,cus_pays=?,cus_role=? WHERE cus_id =? ");
       
       stm.setString(1,c.getEmail());
       stm.setString(2,c.getLastname());
       stm.setString(3,c.getFirstname());
       stm.setString(4,c.getAdress());
       stm.setString(5,c.getCp());
       stm.setString(6,c.getCity());
       stm.setString(7,c.getCountry());
       stm.setInt(8,c.getRole());
       stm.setInt(9,c.getId());
       
       stm.execute();
       stm.close();
       con.close();
       
       }catch(Exception e){
          System.out.println("Error while updating entity 'client'");
          System.out.println(e.getMessage()); 
       }
    }    
    public void delete(Client c){
    try{     
       Connection con = DriverManager.getConnection(url, "root", "");    
       PreparedStatement stm = con.prepareStatement("DELETE FROM customer WHERE cus_id=?");
       stm.setInt(1,c.getId());
       stm.execute();
       stm.close();
       con.close();
    
    
    
    
    }catch(Exception e){
          System.out.println("Error while updating entity 'customer'");
          System.out.println(e.getMessage()); 
       }       
            
    }
    public Client find(int id){
            Client detail = new Client();

    try {

            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM customer WHERE cus_id=?");
       
            stm.setInt(1,id);
            ResultSet result =stm.executeQuery ();
             while (result.next()) {
                detail.setId(result.getInt("cus_id"));
                detail.setEmail(result.getString("cus_email"));
                detail.setLastname(result.getString("cus_name"));
                detail.setFirstname(result.getString("cus_prenom"));
                detail.setAdress(result.getString("cus_adress"));
                detail.setCp(result.getString("cus_cdp"));
                detail.setCity(result.getString("cus_ville"));
                detail.setCountry(result.getString("cus_pays"));
                detail.setRole(result.getInt("cus_role"));

             }
            stm.close();
            result.close();
            con.close();
    }catch(Exception e){
          System.out.println("Error while updating entity 'customer'");
          System.out.println(e.getMessage()); 
       }          
         return detail;
   
    }
    public List <Client>List(){
        List<Client> resultat = new ArrayList<Client>();
        
        try {

            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM customer");

            while (result.next()) {
                Client c = new Client();
                c.setId(result.getInt("cus_id"));
                c.setEmail(result.getString("cus_email"));
                c.setLastname(result.getString("cus_name"));
                c.setFirstname(result.getString("cus_prenom"));
                c.setAdress(result.getString("cus_adress"));
                c.setCp(result.getString("cus_cdp"));
                c.setCity(result.getString("cus_ville"));
                c.setCountry(result.getString("cus_pays"));
                c.setRole(result.getInt("cus_role"));
                resultat.add(c);
            }

            stm.close();
            result.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error while reading 'client'");
            System.out.println(e.getMessage());
        }
        
        return resultat;
    }
        
    
}
