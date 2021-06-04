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
public class NotificationMessage {
    private int sharedID;
    private String name;
    private String message;
    private boolean editable;
    private int noteID;
    private int status;

    public NotificationMessage(String name, String message, boolean editable, int noteID) {
        this.name = name;
        this.message = message;
        this.editable = editable;
        this.noteID = noteID;
    }

    public NotificationMessage(String name, String message, boolean editable, int noteID, int status) {
        this.name = name;
        this.message = message;
        this.editable = editable;
        this.noteID = noteID;
        this.status = status;
    }

    public NotificationMessage(int sharedID, String name, String message, boolean editable, int noteID, int status) {
        this.sharedID = sharedID;
        this.name = name;
        this.message = message;
        this.editable = editable;
        this.noteID = noteID;
        this.status = status;
    }

    public int getSharedID() {
        return sharedID;
    }

    public void setSharedID(int sharedID) {
        this.sharedID = sharedID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
    

    public NotificationMessage(String name) {
        this.name = name;
    }

    public NotificationMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
