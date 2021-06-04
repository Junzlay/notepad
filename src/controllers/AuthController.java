/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ToastMessage;
import models.User;
import services.DatabaseConnection;
import views.auth.Login;

/**
 *
 * @author 2ndyrGroupB
 */
public class AuthController {

    public static void login(User user, DatabaseConnection db, Login login) {
        ResultSet queryResult = null;
        try {
            String sql = "Select * from users where email='" + user.getEmail() + "' and password='" + user.getPassword() + "'";
            queryResult = db.Query(sql);
            if (queryResult.next()) {
                
                new ToastMessage(login.getRootPane(), "Hello! "+queryResult.getString("username"), "success");
                new NoteController().main(queryResult.getInt(1),queryResult.getString("username"),queryResult.getString("email"));
            login.setVisible(false);
            } else {
                new ToastMessage(login.getRootPane(), "Invalid username or password", "error");
            }

        } catch (SQLException ex) {
            System.out.println("Server error : " + ex);
            ex.printStackTrace();

        }
    }

    public static void logout(Login login ,DatabaseConnection db) {

        db.disconnect();
        login.setVisible(true);
    }
}
