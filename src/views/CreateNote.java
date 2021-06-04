/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.NoteController;
import dialogs.RequestAccess;
import services.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.FocusManager;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import views.auth.Login;
import utilities.MyFont;
import utilities.ToastMessage;
import models.Date;

/**
 *
 * @author 2ndyrGroupB
 */
public class CreateNote extends javax.swing.JFrame {

    NoteController controller = new NoteController();
    DatabaseConnection db = new DatabaseConnection();
    public static String status;
    Login user = new Login();
    private int userID = new Notes().userID;
    private int noteID = new Notes().viewID;
    private boolean sharedType = new Notes().sharedType;
     public static String sharedUser=new Notes().sharedUser;
    private static boolean isFavorite = false;

    /**
     * Creates new form CreateNote
     */
    public CreateNote() {
        initComponents();
     
        noteHandler();
        configureFont();
    }

    private void configureFont() {
        new MyFont(noteTitle, 16, "medium");
        new MyFont(noteContent, 15);
    }

    public void noteHandler() {

        setTitle("MiNote");
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        getContentPane().requestFocusInWindow();

        if (new Notes().view.equals("userNote")) {
            noteTitle.setEditable(false);
            noteContent.setEditable(false);
            save.setVisible(false);
            favoriteBtn.setVisible(false);
            edit.setVisible(true);
            delete.setVisible(true);
            share.setVisible(true);
            noteContent.setForeground(new Color(153, 153, 153));
            setTitle("Update Note");
             owners.setText("Personal Note");
            noteContent.setForeground(Color.BLACK);
            noteTitle.setForeground(Color.white);
            getData();
            save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/content-save-edit.png")));
        } else if (new Notes().view.equals("sharedNote")) {
            noteTitle.setEditable(false);
            noteContent.setEditable(false);
            noteTitle.setEditable(false);
            noteContent.setEditable(false);
            save.setVisible(false);
            favoriteBtn.setVisible(false);
            edit.setVisible(true);
            delete.setVisible(false);
            share.setVisible(false);
            owners.setText("owned by "+sharedUser);
            setTitle("View Note");
            getData();
            save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/content-save-edit.png")));
        } else {
            delete.setVisible(false);
            share.setVisible(false);
            edit.setVisible(false);
            setTitle("Create Notes");
            owners.setText("Personal Note");
            noteTitle.requestFocus();
        }
        timeToday.setText(new Date().getTime());
    }

    public void getData() {

        String sql = "Select * from notes where noteID='" + noteID + "'";
        try {
            db.openConnection();
            ResultSet rs = db.Query(sql);
            while (rs.next()) {
                noteTitle.setText(rs.getString(3));
                noteContent.setText(rs.getString(4));
                isFavorite = rs.getInt(6) == 1 ? true : false;
                favoriteBtn.setIcon(rs.getInt(6) == 1 ? new javax.swing.ImageIcon(getClass().getResource("/src/heart.png")) : new javax.swing.ImageIcon(getClass().getResource("/src/heart-outline.png")));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        menubar = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        noteTitle = new javax.swing.JTextField();
        edit = new javax.swing.JLabel();
        favoriteBtn = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        delete = new javax.swing.JLabel();
        share = new javax.swing.JLabel();
        noteContentPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteContent = new javax.swing.JTextArea();
        timeToday = new javax.swing.JLabel();
        owners = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Note");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jLabel1.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        menubar.setBackground(new java.awt.Color(51, 51, 255));
        menubar.setLayout(new javax.swing.BoxLayout(menubar, javax.swing.BoxLayout.LINE_AXIS));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/back.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(30, 30));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        menubar.add(back);

        noteTitle.setBackground(new java.awt.Color(51, 51, 255));
        noteTitle.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        noteTitle.setForeground(new java.awt.Color(204, 204, 204));
        noteTitle.setText("Title");
        noteTitle.setBorder(null);
        noteTitle.setCaretPosition(0);
        noteTitle.setOpaque(false);
        noteTitle.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                noteTitleAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        noteTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noteTitleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noteTitleFocusLost(evt);
            }
        });
        noteTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteTitleMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noteTitleMouseExited(evt);
            }
        });
        noteTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteTitleActionPerformed(evt);
            }
        });
        noteTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noteTitleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noteTitleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteTitleKeyTyped(evt);
            }
        });
        menubar.add(noteTitle);

        edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/pencil.png"))); // NOI18N
        edit.setToolTipText("Edit");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        menubar.add(edit);

        favoriteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favoriteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/heart-outline.png"))); // NOI18N
        favoriteBtn.setToolTipText("Add to favorite");
        favoriteBtn.setPreferredSize(new java.awt.Dimension(30, 24));
        favoriteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favoriteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                favoriteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                favoriteBtnMouseExited(evt);
            }
        });
        menubar.add(favoriteBtn);

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/pencil-plus.png"))); // NOI18N
        save.setToolTipText("Create");
        save.setBorder(null);
        save.setContentAreaFilled(false);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        menubar.add(save);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/delete.png"))); // NOI18N
        delete.setToolTipText("Delete this note");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        menubar.add(delete);

        share.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/share-variant.png"))); // NOI18N
        share.setToolTipText("Share this Note");
        share.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shareMouseClicked(evt);
            }
        });
        menubar.add(share);

        jPanel2.add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 50));

        noteContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        noteContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        noteContent.setColumns(20);
        noteContent.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        noteContent.setForeground(new java.awt.Color(153, 153, 153));
        noteContent.setLineWrap(true);
        noteContent.setRows(5);
        noteContent.setText("Type your note here");
        noteContent.setBorder(null);
        noteContent.setCaretColor(new java.awt.Color(51, 0, 204));
        noteContent.setCaretPosition(0);
        noteContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noteContentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noteContentFocusLost(evt);
            }
        });
        noteContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteContentMouseClicked(evt);
            }
        });
        noteContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noteContentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteContentKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(noteContent);

        javax.swing.GroupLayout noteContentPanelLayout = new javax.swing.GroupLayout(noteContentPanel);
        noteContentPanel.setLayout(noteContentPanelLayout);
        noteContentPanelLayout.setHorizontalGroup(
            noteContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noteContentPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        noteContentPanelLayout.setVerticalGroup(
            noteContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noteContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(noteContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 310, 420));

        timeToday.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        timeToday.setForeground(new java.awt.Color(255, 255, 255));
        timeToday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeToday.setText("Time");
        jPanel2.add(timeToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 70, -1));

        owners.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        owners.setForeground(new java.awt.Color(255, 255, 255));
        owners.setText("Personal Note");
        jPanel2.add(owners, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void noteContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteContentMouseClicked
        // TODO add your handling code here:
        if (noteContent.getText().equals("Type your note here")) {
            noteContent.setForeground(new Color(153, 153, 153));
            noteContent.setCaretPosition(0);
        } else {
            noteContent.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_noteContentMouseClicked

    private void noteContentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteContentKeyTyped
        if (noteContent.getText().equals("Type your note here")) {
            noteContent.setForeground(Color.black);
            noteContent.setText("");
        }

        timeToday.setText(new Date().getTime());
    }//GEN-LAST:event_noteContentKeyTyped

    private void noteContentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteContentKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_noteContentKeyReleased

    public void hoverEffect(JLabel hover, Color rand) {
        hover.setBackground(rand);
    }

    private void noteTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteTitleActionPerformed

    private void noteTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteTitleMouseExited
        // TODO add your handling code here:
//        if (this.noteTitle.getText().isEmpty()) {
//            noteTitle.setText("New Note");
//        }
    }//GEN-LAST:event_noteTitleMouseExited

    private void noteTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteTitleKeyReleased
        // TODO add your handling code here:

//        if(focusOwner instanceof this.noteTitle && this.noteTitle.getText().isEmpty()){
//            noteTitle.setText("New Note");
//        };
    }//GEN-LAST:event_noteTitleKeyReleased
//public static boolean 
    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked

        if (new Notes().view.equals("userNote") || new Notes().view.equals("sharedNote")) {
            updateNote();
        } else {
            saveNote();
        }
    }//GEN-LAST:event_saveMouseClicked

    private void updateNote() {
        int fav = isFavorite ? 1 : 0;
        try {
            controller.updateNote(noteTitle, noteContent, fav, noteID);
            status = "update";
            new ToastMessage(noteContentPanel, "Changes are made", "success");
            new Notes().view = "";
            new Notes().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(CreateNote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveNote() {
        int fav = isFavorite ? 1 : 0;
        if (noteTitle.getText().equals("Title") || noteContent.getText().equals("Type your note here")) {
            new ToastMessage(noteContentPanel, "All Fields are required", "error");
        } else {
            try {
                controller.createNote(noteTitle, noteContent, fav, userID);
                status = "save";
                new ToastMessage(noteContentPanel, "Added to notes", "success");
                new Notes().setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(CreateNote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void favoriteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteBtnMouseEntered
        // TODO add your handling code here:
//        favoriteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/heart.png")) );
    }//GEN-LAST:event_favoriteBtnMouseEntered

    private void favoriteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteBtnMouseExited
        // TODO add your handling code here:
//         favoriteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/heart-outline.png")) );
    }//GEN-LAST:event_favoriteBtnMouseExited

    private void favoriteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteBtnMouseClicked
        // TODO add your handling code here:
//        JFontChooser chooser=new JFontChooser();
//        noteContent.setFont(chooser.getSelectedFont());
        if (isFavorite) {
            this.favoriteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/heart-outline.png")));
            isFavorite = false;
        } else {
            this.favoriteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/heart.png")));
            isFavorite = true;
        }
        timeToday.setText(new Date().getTime());
    }//GEN-LAST:event_favoriteBtnMouseClicked

    private void noteTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteTitleKeyTyped
        // TODO add your handling code here:
        if (noteTitle.getText().equals("Title")) {
            noteTitle.setForeground(Color.white);
            noteTitle.setText("");
        }

        timeToday.setText(new Date().getTime());


    }//GEN-LAST:event_noteTitleKeyTyped

    private void noteTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteTitleKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_noteTitleKeyPressed

    private void noteTitleAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_noteTitleAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_noteTitleAncestorAdded

    private void noteTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noteTitleFocusLost
        if (noteTitle.getText().equals("")) {
            noteTitle.setForeground(new Color(204, 204, 204));
            noteTitle.setText("Title");
        }
        noteTitle.setForeground(Color.white);
    }//GEN-LAST:event_noteTitleFocusLost

    private void noteTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteTitleMouseClicked
        // TODO add your handling code here:
        if (noteTitle.getText().equals("Title")) {
            noteTitle.setForeground(new Color(204, 204, 204));
            noteTitle.setCaretPosition(0);
        }
        timeToday.setText(new Date().getTime());
    }//GEN-LAST:event_noteTitleMouseClicked

    private void noteTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noteTitleFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_noteTitleFocusGained

    private void noteContentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noteContentFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_noteContentFocusGained

    private void noteContentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noteContentFocusLost
        // TODO add your handling code here:
        if (noteContent.getText().equals("")) {
            noteContent.setText("Type your note here");
            noteContent.setForeground(new Color(153, 153, 153));
        }
//          noteContent.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_noteContentFocusLost

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to go back?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            new Notes().view = "";
            new Notes().sharedType = false;
            dispose();
            new Notes().setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes

        } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
        } else {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//no
        }

    }//GEN-LAST:event_backMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        // TODO add your handling code here:
//        noteContent.requestFocus();
        if (sharedType && new Notes().view.equals("sharedNote")) {
            save.setVisible(true);
            noteContent.setFocusable(true);
            noteTitle.setEditable(true);
            noteContent.setEditable(true);
            noteContent.setForeground(Color.BLACK);
            noteContent.requestFocus();
        } else if (new Notes().view.equals("userNote")) {
            save.setVisible(true);
            noteContent.setFocusable(true);
            noteTitle.setEditable(true);
            noteContent.setEditable(true);
            favoriteBtn.setVisible(true);
            noteContent.setForeground(Color.BLACK);
            noteContent.requestFocus();
        } else {
           RequestAccess req=new RequestAccess();
           
//            JOptionPane.showMessageDialog(null, "You dont have a privilege to edit this note", "Cant Edit", 1);
        }
//        save.setVisible(true);
//        noteContent.setFocusable(true);
//        noteTitle.setEditable(true);
//        noteContent.setEditable(true);
//        favoriteBtn.setVisible(true);
//        noteContent.setForeground(Color.BLACK);
//        noteContent.requestFocus();
    }//GEN-LAST:event_editMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to permanent delete this note?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            deleteNote();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes

        } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
        } else {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//no
        }


    }//GEN-LAST:event_deleteMouseClicked
    private void deleteNote() {
        try {
            controller.deleteNote(noteID);
            new ToastMessage(noteContentPanel, "Delete SuccessFully", "success");
            new Notes().view = "";
            new Notes().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(CreateNote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void shareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shareMouseClicked
        new Share().setVisible(true);
    }//GEN-LAST:event_shareMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel favoriteBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menubar;
    private javax.swing.JTextArea noteContent;
    private javax.swing.JPanel noteContentPanel;
    private javax.swing.JTextField noteTitle;
    private javax.swing.JLabel owners;
    private javax.swing.JButton save;
    private javax.swing.JLabel share;
    private javax.swing.JLabel timeToday;
    // End of variables declaration//GEN-END:variables

}
