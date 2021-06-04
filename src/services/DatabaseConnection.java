/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2ndyrGroupB
 */
public class DatabaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement;
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String DB_PATH="jdbc:mysql://localhost:3306/yournotepad";
    private String userName="root";
    private String password="";

    public DatabaseConnection(){
        this.openConnection();
    }

  
    public void openConnection(){
     try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(this.DB_PATH, this.userName, this.password);
//            this.setStatement(this.connection.createStatement());
            statement = connection.createStatement();
//             System.out.println("Connected to DB");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting in database." + e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

  
    public void closeConnection()throws SQLException, Exception {
        statement.close();
        connection.close();
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }



//    sql injection by undefined
    public ResultSet Query(String query) {
        ResultSet queryResult = null;
        try {
             statement = connection.createStatement();
            queryResult = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Exception in query method:\n" + e.getMessage());
        }
        return queryResult;
    }//end sql injection

     public void disconnect() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (Exception e) {
                System.out.println("Error in closing.../n" + e);
            }
        }
    }

}
