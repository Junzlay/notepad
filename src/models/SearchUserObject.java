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
public class SearchUserObject {
    private String name;
    private int userSearchID;

  

    public SearchUserObject(String name, int ID) {
        this.name = name;
        this.userSearchID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserSearchID() {
        return userSearchID;
    }

    public void setUserSearchID(int userSearchID) {
        this.userSearchID = userSearchID;
    }

   
    
}
