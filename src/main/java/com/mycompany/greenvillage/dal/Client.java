/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage.dal;

public class Client {
    public int Id;
    public String Email;
    public String Lastname;
    public String Firstname;
    public String City;
    public String Adress;
    public String Country;
    public String cp;
    public int role;

    
    
    public String getEmail() {
    return Email;
    }

    public String getCp() {
        return cp;
    }

    public int getRole() {
        return role;
    }

    public int getId() {
        return Id;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getCity() {
        return City;
    }

    public String getAdress() {
        return Adress;
    }

    public String getCountry() {
        return Country;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
  
       public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setRole(int role) {
        this.role = role;
    }
       
}
