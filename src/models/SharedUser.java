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
public class SharedUser {
    private int status;
    private String user;

    public SharedUser(int status, String user) {
        this.status = status;
        this.user = user;
    }

    public SharedUser() {
    }
    
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getAllusers(){
        return "SharedUser{" + "status=" + status + ", user=" + user + '}';
    }

    @Override
    public String toString() {
        return user;
    }

   
    
    
    
}
