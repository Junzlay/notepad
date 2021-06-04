/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.NoteObject;
import services.DatabaseConnection;
import views.Notes;
import views.card.Notecard;

/**
 *
 * @author 2ndyrGroupB
 */
public class NoteController {

    DatabaseConnection database = new DatabaseConnection();

    public static void main(int id, String name, String email) {
        System.out.println(name);
        new Notes().userID = id;
        new Notes().userName = name;
        new Notes().email = email;
        new Notes().loggedIN = true;
        new Notes().setVisible(true);
    }

    public int registerUser(JTextField name, JTextField email, JPasswordField password) throws Exception {
        Statement statement;
        int result = 0;
        String qry = "Insert into users(username,email,password)"
                + " values('" + name.getText() + "','" + email.getText() + "','" + String.valueOf(password.getPassword()) + "')";
        try {
            result = database.getStatement().executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if (database.getConnection() != null) {
                database.closeConnection();
            }
        }
        return result;
    }

    public void createNote(JTextField title, JTextArea content, int favorite, int id) throws Exception {
        String qry = "Insert into notes(userID,noteTitle, noteContent,status,isFavorite,date_created)"
                + " values('" + id + "','" + title.getText() + "','" + content.getText() + "','" + 0 + "','" + favorite + "','" + new Date() + " at " + new Date().getTime() + "')";
        try {
            database.getStatement().executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if (database.getConnection() != null) {
                database.closeConnection();
            }
        }
    }

    public void updateNote(JTextField title, JTextArea content, int favorite, int id) throws Exception {
        String qry = "update notes set noteTitle='" + title.getText() + "', noteContent='" + content.getText() + "',status='" + 0 + "',isFavorite='" + favorite + "',date_created='" + new Date() + " at " + new Date().getTime() + "' where noteID='" + id + "'";
        try {
            database.getStatement().executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if (database.getConnection() != null) {
                database.closeConnection();
            }
        }
    }

    public void getNotifications() {

    }

    public void deleteNote(int id) throws Exception {
        String qry = "delete from notes where noteID='" + id + "'";
        try {
            database.getStatement().executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if (database.getConnection() != null) {
                database.closeConnection();
            }
        }
    }

    public int getAllNote(int userID, JList list, String type) {
        DefaultListModel<NoteObject> model = new DefaultListModel<>();
        String sql = "";
        if (type.equals("favorite")) {
            sql = "Select * from notes where userID='" + userID + "' and isFavorite='" + 1 + "'";
        } else {
            sql = "Select * from notes where userID='" + userID + "' order by noteID desc";
        }
        int count = 0;
        String favicon = "";
        String date = "";
        try {
            ResultSet rs = database.Query(sql);
            while (rs.next()) {
                if (Integer.parseInt(rs.getString(6)) == 1) {
                    favicon = "/src/heart.png";
                } else {
                    favicon = "/src/heart-outline.png";
                }
                String time = rs.getString(7);
                String rx = "\\w+\\s+\\w*" + "at";
                Pattern p = Pattern.compile(rx);
                Matcher matcher = p.matcher(time);
                if (matcher.find()) {
                    date = matcher.group(0);
                }
                date = getFirst(time, "at");
                time = time.substring(time.indexOf("at") + 3);
                model.addElement(new NoteObject(rs.getInt(1), rs.getString(3), date, time, favicon, rs.getString(4)));
                count++;
            };
            list.setModel(model);
            list.setCellRenderer(new Notecard());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return count;
    }

    public String getFirst(String input, String word) {
        return input.substring(0, input.indexOf(word));
    }

    public int shareTo(String people, int noteID, int status) throws Exception {
        int result = 0;
        String qry = "Insert into shared(noteID,sharesTo,status)"
                + " values('" + noteID + "','" + people + "','" + status + "')";
        try {
            result = database.getStatement().executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if (database.getConnection() != null) {
                database.closeConnection();
            }
        }
        return result;
    }

}
