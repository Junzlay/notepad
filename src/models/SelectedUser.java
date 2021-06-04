/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 2ndyrGroupB
 */
public class SelectedUser {

    private SharedUser [] users;
     private int count;
    private int max;
    private List user=new ArrayList<>();
    private String displayUser;

   
    
     public SelectedUser() {
//        this(10);
    }
    public SelectedUser(int max) {
        this.max = max;
        users = new SharedUser[this.max];
    }

    public List getUser() {
        return user;
    }
//
//    public void setUser(List user) {
//        this.user = user;
//    }
 public boolean addUser(SharedUser p) {
        if (!isFull()) {
            this.users[this.count++] = p;
            return true;
        }
        return false;
    }
 
   private boolean isFull() {
        return count == max;
    }

    public void insertUser(String newUser) {
        this.user.add(newUser);
    }

    public String showList() {
        String show = "";
        for (Object el : this.user) {
            show += el + ",";
        }
        return show;
    }

    public SharedUser[] getUsers() {
        return users;
    }

    public void setUsers(SharedUser[] users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

   

   public String allUsers(){
       String show="";
         for (int i = 0; i < count; ++i) {
            show += users[i].getUser() + ",";
        }
         return show;
   }

//    @Override
//    public String toString() {
//       String show="[";
//         for (int i = 0; i < count; ++i) {
//            show += "{ name="+users[i].getUser() + ", status="+users[i].getStatus()+"},";
//        }
//         return show+']';
//    }

//      @Override
//    public String toString() {
//       String show="[";
//         for (int i = 0; i < count; ++i) {
//            show += "{ 'name'="+"+users[i].getUser() + "+", 'status'="+users[i].getStatus()+"},";
//        }
//         return show+']';
//    }
//
//   

}
