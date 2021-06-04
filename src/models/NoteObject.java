/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JLabel;

/**
 *
 * @author 2ndyrGroupB
 */
public class NoteObject {
    private int id;
    private String title;
    private String date;
    private String time;
    private String favicon;
    private String content;

    public NoteObject(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public NoteObject(int id, String title, String date, String time, String favicon, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.favicon = favicon;
        this.content = content;
    }

    public NoteObject(int id, String title, String date, String time,  String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.content = content;
    }

    public NoteObject(String title, String date,  String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public NoteObject(int id, String title, String date,String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }
    

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
}
