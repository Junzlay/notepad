/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 2ndyrGroupB
 */
public class User {
    
   
    private String password;
    private String email;

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /*
    * @param password the password to set
    */
    public void setPassword(String password) {
        this.password = password;
    }
}
