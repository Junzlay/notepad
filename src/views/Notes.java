/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.NoteController;
import dialogs.Access;
import views.card.Notecard;
import views.card.SearchUserCard;
import models.Date;
import views.card.NotificationMessageCard;
import views.CreateNote;
import models.SearchUserObject;
import models.NoteObject;
import services.DatabaseConnection;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import views.auth.Login;
import utilities.MyFont;
import utilities.ToastMessage;
import models.NotificationMessage;
import models.User;

/**
 *
 * @author 2ndyrGroupB
 */
public class Notes extends javax.swing.JFrame {

    DefaultListModel<NotificationMessage> message = new DefaultListModel<>();
    private int notificationCount = 0;
    public static String view = "";
    public static int viewID;
    public static int sharedID;
    public static boolean sharedType = false;
    public static int userSearchID;
    DefaultListModel<SearchUserObject> searchModel = new DefaultListModel<>();
    String sharesTo;
    DatabaseConnection db = new DatabaseConnection();
    private User user;
    public static String userName;
    public static int userID;
    public static String email;
    public static boolean loggedIN;
    NoteController controller = new NoteController();
    public static String sharedUser = "";
public static String requestBy="";
public static String requestMessage="";
    private int noteCount;

    /**
     * Creates new form MyNotes
     */
    public Notes() {

        initComponents();
        setTitle("MiNote");
        search.setBackground(null);
        listHandler();
        configureFont();
//        notifications();
        notifyShared();
        brand.setText("MiNote -" + userName);
        searchingLabel.setVisible(true);
        this.noteCount = controller.getAllNote(userID, noteList, "note");
        checkNote();
    }

    private void listHandler() {
        searchInputContainer.setVisible(false);

        noteScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        noteScroll.getViewport().setBorder(null);
        noteScroll.setViewportBorder(null);
        noteScroll.setBorder(null);
        noteList.setFixedCellHeight(80);
        noteList.setFixedCellWidth(120);
        noteList.setBorder(new EmptyBorder(10, 10, 10, 10));

        searchUserList.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        searchUserList.getViewport().setBorder(null);
        searchUserList.setViewportBorder(null);
        searchUserList.setBorder(null);
        searchList.setFixedCellHeight(42);
        searchList.setFixedCellWidth(271);

        messagePane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        messagePane.getViewport().setBorder(null);
        messagePane.setViewportBorder(null);
        messagePane.setBorder(null);

        favoritePane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        favoritePane.getViewport().setBorder(null);
        favoritePane.setViewportBorder(null);
        favoritePane.setBorder(null);
        favList.setFixedCellHeight(80);
        favList.setFixedCellWidth(120);
        favList.setBorder(new EmptyBorder(10, 10, 10, 10));

        notificationList.setFixedCellHeight(70);
        notificationList.setFixedCellWidth(290);

        today.setText(new Date().getTime());

    }

    private void checkFav() {
        boolean have = false;
        if (new NoteController().getAllNote(userID, favList, "favorite") > 0) {
            have = true;
        }
        cardContainer.removeAll();
        cardContainer.add(have ? favoriteCard : emptyFavorite);
        cardContainer.repaint();
        cardContainer.revalidate();
    }

    private void configureFont() {
        new MyFont(brand, 18, "medium");
        new MyFont(noteBtn, 11);
        new MyFont(favBtn, 11);
        new MyFont(emptyLabel, 18);
        new MyFont(emptyFavLabel, 18);
    }

    private void checkStatus() {
        String status = new CreateNote().status;
        if (!status.isEmpty()) {
            if (status.equals("save")) {
                new ToastMessage(noteCard, "Added to notes", "success");
                new CreateNote().status = "";
            } else {
                new ToastMessage(noteCard, "Changes are made", "success");
                new CreateNote().status = "";
            }
        }
    }

    private void toggleBtn(String note) {
        if (note.equals("note")) {
            noteBtn.setOpaque(true);
            noteBtn.setForeground(new java.awt.Color(0, 0, 0));

            favBtn.setForeground(new java.awt.Color(255, 255, 255));
            favBtn.setOpaque(false);
        } else {

            noteBtn.setOpaque(false);
            noteBtn.setForeground(new java.awt.Color(255, 255, 255));

            favBtn.setForeground(new java.awt.Color(0, 0, 0));
            favBtn.setOpaque(true);
        }
    }

    private String greetUser() {
        Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);
        String greeting = null;
        if (hours >= 1 && hours <= 12) {
            greeting = "Good Morning";
        } else if (hours >= 12 && hours <= 16) {
            greeting = "Good Afternoon";
        } else if (hours >= 16 && hours <= 21) {
            greeting = "Good Evening";
        } else if (hours >= 21 && hours <= 24) {
            greeting = "Good Night";
        }
        return greeting;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        menubar = new javax.swing.JPanel();
        today = new javax.swing.JLabel();
        countNote = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        noteBtn = new javax.swing.JButton();
        favBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JLabel();
        searchInputContainer = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        line = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        notificationsCount = new javax.swing.JLabel();
        notifications = new javax.swing.JLabel();
        cardContainer = new javax.swing.JPanel();
        notificationsEmpty = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        notificationsCard = new javax.swing.JPanel();
        messagePane = new javax.swing.JScrollPane();
        notificationList = new javax.swing.JList<>();
        emptyFavorite = new javax.swing.JPanel();
        emptyFavLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        favoriteCard = new javax.swing.JPanel();
        favoritePane = new javax.swing.JScrollPane();
        favList = new javax.swing.JList<>();
        emptyNote = new javax.swing.JPanel();
        emptyLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addBtn = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        searchingLabel = new javax.swing.JLabel();
        searchUserList = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        noteCard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addNote = new javax.swing.JLabel();
        noteScroll = new javax.swing.JScrollPane();
        noteList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        mainContainer.setMinimumSize(new java.awt.Dimension(600, 400));
        mainContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menubar.setBackground(new java.awt.Color(51, 51, 255));
        menubar.setLayout(null);

        today.setFont(new java.awt.Font("Yu Gothic Medium", 0, 11)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        today.setText("Date");
        menubar.add(today);
        today.setBounds(230, 59, 90, 30);

        countNote.setFont(new java.awt.Font("Yu Gothic Medium", 0, 11)); // NOI18N
        countNote.setForeground(new java.awt.Color(255, 255, 255));
        countNote.setText("jLabel4");
        menubar.add(countNote);
        countNote.setBounds(20, 30, 90, 20);

        brand.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        brand.setForeground(new java.awt.Color(255, 255, 255));
        brand.setText("MiNote");
        menubar.add(brand);
        brand.setBounds(20, 10, 200, 20);

        noteBtn.setBackground(new java.awt.Color(255, 255, 255));
        noteBtn.setText("Notes");
        noteBtn.setBorder(null);
        noteBtn.setBorderPainted(false);
        noteBtn.setContentAreaFilled(false);
        noteBtn.setFocusPainted(false);
        noteBtn.setOpaque(true);
        noteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteBtnMouseClicked(evt);
            }
        });
        noteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteBtnActionPerformed(evt);
            }
        });
        menubar.add(noteBtn);
        noteBtn.setBounds(20, 70, 60, 30);

        favBtn.setBackground(new java.awt.Color(255, 255, 255));
        favBtn.setForeground(new java.awt.Color(255, 255, 255));
        favBtn.setText("Favorite");
        favBtn.setBorderPainted(false);
        favBtn.setContentAreaFilled(false);
        favBtn.setFocusPainted(false);
        favBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favBtnMouseClicked(evt);
            }
        });
        favBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favBtnActionPerformed(evt);
            }
        });
        menubar.add(favBtn);
        favBtn.setBounds(80, 70, 90, 30);

        searchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/magnify.png"))); // NOI18N
        searchBtn.setToolTipText("Search Note");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        menubar.add(searchBtn);
        searchBtn.setBounds(240, 10, 30, 30);

        searchInputContainer.setBackground(new java.awt.Color(255, 255, 255));
        searchInputContainer.setFocusable(false);
        searchInputContainer.setOpaque(false);
        searchInputContainer.setLayout(null);

        search.setBackground(new java.awt.Color(51, 51, 255));
        search.setForeground(new java.awt.Color(204, 204, 204));
        search.setText("Search by name or id");
        search.setBorder(null);
        search.setCaretColor(new java.awt.Color(255, 255, 255));
        search.setCaretPosition(0);
        search.setName(""); // NOI18N
        search.setOpaque(false);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        searchInputContainer.add(search);
        search.setBounds(0, -6, 150, 30);

        line.setLayout(null);
        searchInputContainer.add(line);
        line.setBounds(0, 25, 150, 1);

        menubar.add(searchInputContainer);
        searchInputContainer.setBounds(60, 10, 180, 30);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/account-circle.png"))); // NOI18N
        profile.setToolTipText("My Profile");
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        menubar.add(profile);
        profile.setBounds(300, 10, 30, 30);

        notificationsCount.setBackground(new java.awt.Color(255, 255, 255));
        notificationsCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        notificationsCount.setForeground(new java.awt.Color(255, 255, 255));
        notificationsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notificationsCount.setText("0");
        menubar.add(notificationsCount);
        notificationsCount.setBounds(290, 10, 10, 20);

        notifications.setForeground(new java.awt.Color(255, 255, 255));
        notifications.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dist/images/outline_notifications_white_24dp.png"))); // NOI18N
        notifications.setToolTipText("Notifications");
        notifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsMouseClicked(evt);
            }
        });
        menubar.add(notifications);
        notifications.setBounds(270, 10, 30, 30);

        mainContainer.add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 100));

        cardContainer.setLayout(new java.awt.CardLayout());

        notificationsEmpty.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("You dont have notifications");

        javax.swing.GroupLayout notificationsEmptyLayout = new javax.swing.GroupLayout(notificationsEmpty);
        notificationsEmpty.setLayout(notificationsEmptyLayout);
        notificationsEmptyLayout.setHorizontalGroup(
            notificationsEmptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationsEmptyLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        notificationsEmptyLayout.setVerticalGroup(
            notificationsEmptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationsEmptyLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel4)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        cardContainer.add(notificationsEmpty, "card8");

        notificationsCard.setBackground(new java.awt.Color(255, 255, 255));

        notificationList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationListMouseClicked(evt);
            }
        });
        messagePane.setViewportView(notificationList);

        javax.swing.GroupLayout notificationsCardLayout = new javax.swing.GroupLayout(notificationsCard);
        notificationsCard.setLayout(notificationsCardLayout);
        notificationsCardLayout.setHorizontalGroup(
            notificationsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationsCardLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(messagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        notificationsCardLayout.setVerticalGroup(
            notificationsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messagePane, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardContainer.add(notificationsCard, "card7");

        emptyFavorite.setBackground(new java.awt.Color(255, 255, 255));

        emptyFavLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        emptyFavLabel.setForeground(new java.awt.Color(102, 102, 102));
        emptyFavLabel.setText("Favorite is empty");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/note-empty.png"))); // NOI18N

        javax.swing.GroupLayout emptyFavoriteLayout = new javax.swing.GroupLayout(emptyFavorite);
        emptyFavorite.setLayout(emptyFavoriteLayout);
        emptyFavoriteLayout.setHorizontalGroup(
            emptyFavoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyFavoriteLayout.createSequentialGroup()
                .addGroup(emptyFavoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emptyFavoriteLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(emptyFavLabel))
                    .addGroup(emptyFavoriteLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        emptyFavoriteLayout.setVerticalGroup(
            emptyFavoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyFavoriteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(emptyFavLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        cardContainer.add(emptyFavorite, "card5");

        favoriteCard.setBackground(new java.awt.Color(255, 255, 255));
        favoriteCard.setLayout(null);

        favList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favListMouseClicked(evt);
            }
        });
        favoritePane.setViewportView(favList);

        favoriteCard.add(favoritePane);
        favoritePane.setBounds(19, 9, 302, 430);

        cardContainer.add(favoriteCard, "card2");

        emptyNote.setBackground(new java.awt.Color(255, 255, 255));
        emptyNote.setMinimumSize(new java.awt.Dimension(340, 540));
        emptyNote.setPreferredSize(new java.awt.Dimension(340, 540));
        emptyNote.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emptyLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        emptyLabel.setForeground(new java.awt.Color(102, 102, 102));
        emptyLabel.setText("Opps! Your note is empty");
        emptyNote.add(emptyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/note-empty.png"))); // NOI18N
        emptyNote.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 288));

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/adds.png"))); // NOI18N
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        emptyNote.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));

        cardContainer.add(emptyNote, "card4");

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setLayout(null);

        searchingLabel.setText("Searching user...");
        searchPanel.add(searchingLabel);
        searchingLabel.setBounds(50, 0, 120, 14);

        searchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchListMouseClicked(evt);
            }
        });
        searchUserList.setViewportView(searchList);

        searchPanel.add(searchUserList);
        searchUserList.setBounds(27, 15, 289, 400);

        cardContainer.add(searchPanel, "card6");

        noteCard.setBackground(new java.awt.Color(255, 255, 255));
        noteCard.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/adds.png"))); // NOI18N
        addNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNoteMouseClicked(evt);
            }
        });
        jPanel1.add(addNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 60));

        noteCard.add(jPanel1);
        jPanel1.setBounds(0, 390, 340, 60);

        noteScroll.setBackground(new java.awt.Color(255, 255, 255));
        noteScroll.setBorder(null);
        noteScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        noteScroll.setHorizontalScrollBar(null);
        noteScroll.setOpaque(false);

        noteList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteListMouseClicked(evt);
            }
        });
        noteScroll.setViewportView(noteList);

        noteCard.add(noteScroll);
        noteScroll.setBounds(20, 10, 300, 370);

        cardContainer.add(noteCard, "card3");

        mainContainer.add(cardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 340, 450));

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void noteListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteListMouseClicked
        // TODO add your handling code here:
        view = "userNote";
        viewID = noteList.getSelectedValue().getId();
        new CreateNote().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_noteListMouseClicked

    private void noteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteBtnActionPerformed
        // TODO add your handling code here:
        checkNote();

    }//GEN-LAST:event_noteBtnActionPerformed

    private void favBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favBtnActionPerformed

    }//GEN-LAST:event_favBtnActionPerformed

    private void noteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteBtnMouseClicked
        // TODO add your handling code here:
        checkNote();
        toggleBtn("note");
    }//GEN-LAST:event_noteBtnMouseClicked

    private void favBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favBtnMouseClicked
        checkFav();
        toggleBtn("favorite");
    }//GEN-LAST:event_favBtnMouseClicked


    private void addNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNoteMouseClicked
        new CreateNote().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addNoteMouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
        new CreateNote().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBtnMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
        if (search.getText().equals("Search by name or id")) {
            search.setText("");
        }
        checkSearchContent();

        search();

    }//GEN-LAST:event_searchKeyTyped
    private void checkSearchContent() {
        if (search.getText().equals("Search by name or id") || search.getText().isEmpty()) {
            searchingLabel.setVisible(false);
        } else {
            searchingLabel.setVisible(true);
        }
    }
    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        if (search.getText().isEmpty()) {
            searchModel.removeAllElements();
        }
    }//GEN-LAST:event_searchKeyReleased


    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        // TODO add your handling code here:
        noteBtn.setOpaque(false);
        noteBtn.setForeground(new java.awt.Color(255, 255, 255));
        cardContainer.removeAll();
        cardContainer.add(searchPanel);
        cardContainer.repaint();
        cardContainer.revalidate();

    }//GEN-LAST:event_searchFocusGained

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
//           search();
    }//GEN-LAST:event_searchKeyPressed

    private void searchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchListMouseClicked
        // TODO add your handling code here:
        if (!searchList.isSelectionEmpty()) {
            userSearchID = searchList.getSelectedValue().getUserSearchID();
            System.out.println(userSearchID);
        }

    }//GEN-LAST:event_searchListMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        checkSearchContent();
        searchInputContainer.setVisible(true);
        search.requestFocus();
        brand.setVisible(false);
        countNote.setVisible(false);
        search.setBackground(new Color(51, 51, 255));
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        searchInputContainer.setVisible(false);

        countNote.setVisible(true);
        brand.setVisible(true);
//        noteBtn.setOpaque(true);
//        noteBtn.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_searchFocusLost

    private void notificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsMouseClicked
        noteBtn.setOpaque(false);
        noteBtn.setForeground(new java.awt.Color(255, 255, 255));
        boolean isHave = false;

        if (notificationCount > 0) {
            isHave = true;
        }
        cardContainer.removeAll();
        cardContainer.add(isHave ? notificationsCard : notificationsEmpty);
        cardContainer.repaint();
        cardContainer.revalidate();
    }//GEN-LAST:event_notificationsMouseClicked

    private void notificationListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationListMouseClicked

        if (!notificationList.isSelectionEmpty()) {
            sharedID = notificationList.getSelectedValue().getSharedID();
            viewID = notificationList.getSelectedValue().getNoteID();
            sharedType = notificationList.getSelectedValue().isEditable();
            String user = notificationList.getSelectedValue().getName();
            requestMessage= notificationList.getSelectedValue().getMessage();
            if (notificationList.getSelectedValue().getStatus() == 3) {
                sharedUser = user.substring(0, user.indexOf("request")).trim();
                
                new Access();
            } else {
                sharedUser = user.substring(0, user.indexOf("shares")).trim();
                view = "sharedNote";
                new CreateNote().setVisible(true);
                this.dispose();
            }

        }

    }//GEN-LAST:event_notificationListMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked

        new UserProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void favListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favListMouseClicked

        view = "userNote";
        viewID = favList.getSelectedValue().getId();
        new CreateNote().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_favListMouseClicked

    private void notifyShared() {
        String sql = "Select * from shared where sharesTo='" + userName + "' order by sharedID desc";
        try {
            ResultSet rs = db.Query(sql);
            while (rs.next()) {
                int status = rs.getInt(4);
                int sharedID = rs.getInt(1);
                boolean editable = rs.getInt("status") == 1 ? true : false;
                createMessage(sharedID, db, rs, rs.getString("sharesTo"), editable, rs.getInt("noteID"), status, rs.getString("message"));
            };
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.closeConnection();
                } catch (Exception e) {
                    System.out.println("Error in closing.../n" + e);
                }
            }
        }
    }

    private void createMessage(int sharedID, DatabaseConnection db, ResultSet data, String users, boolean editable, int noteID, int status, String messages) {
        int sharedStatus = 0;
        String sql = "SELECT us.username,note.noteTitle,note.noteContent,note.status FROM notes note INNER JOIN users us ON note.userID = us.userID WHERE note.noteID='" + noteID + "'";
        try {

            ResultSet rs = db.Query(sql);
            while (rs.next()) {
                if (status == 3) {
                    notificationCount++;
                    System.out.println("sulod status");
                    message.addElement(new NotificationMessage(sharedID, data.getString("requestby") + " request to edit", "Message | " + data.getString("message"), editable, noteID, status));

                }
                if (!rs.getString("username").equals(userName)) {
                    notificationCount++;
                    message.addElement(new NotificationMessage(sharedID, rs.getString("username") + " shares a note", rs.getString("noteTitle") + " | " + rs.getString("noteContent"), editable, noteID, status));
                   
                }
            }
            notificationsCount.setText(String.valueOf(notificationCount));
            notificationList.setModel(message);
            notificationList.setCellRenderer(new NotificationMessageCard());
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    private void search() {
        searchModel.removeAllElements();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yournotepad", "root", "");
            String sql = "SELECT * FROM users WHERE userID LIke ? OR username LIKE ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, "%" + search.getText() + "%");
            stmt.setString(2, "%" + search.getText() + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("username");
                searchModel.addElement(new SearchUserObject(name, rs.getInt(1)));

            }

            searchList.setModel(searchModel);
            searchList.setCellRenderer(new SearchUserCard());
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            db.disconnect();

        }
    }

    private void checkNote() {
        boolean have = false;
        if (noteCount > 0) {
            have = true;
        }
        countNote.setText(String.valueOf(noteCount) + " Notes");
        cardContainer.removeAll();
        cardContainer.add(have ? noteCard : emptyNote);
        cardContainer.repaint();
        cardContainer.revalidate();
    }

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
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notes().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private javax.swing.JLabel addNote;
    private javax.swing.JLabel brand;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JLabel countNote;
    private javax.swing.JLabel emptyFavLabel;
    private javax.swing.JPanel emptyFavorite;
    private javax.swing.JLabel emptyLabel;
    private javax.swing.JPanel emptyNote;
    private javax.swing.JButton favBtn;
    private javax.swing.JList<NoteObject> favList;
    private javax.swing.JPanel favoriteCard;
    private javax.swing.JScrollPane favoritePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel line;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel menubar;
    private javax.swing.JScrollPane messagePane;
    private javax.swing.JButton noteBtn;
    private javax.swing.JPanel noteCard;
    private javax.swing.JList<NoteObject> noteList;
    private javax.swing.JScrollPane noteScroll;
    private javax.swing.JList<NotificationMessage> notificationList;
    private javax.swing.JLabel notifications;
    private javax.swing.JPanel notificationsCard;
    private javax.swing.JLabel notificationsCount;
    private javax.swing.JPanel notificationsEmpty;
    private javax.swing.JLabel profile;
    private javax.swing.JTextField search;
    private javax.swing.JLabel searchBtn;
    private javax.swing.JPanel searchInputContainer;
    private javax.swing.JList<SearchUserObject> searchList;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JScrollPane searchUserList;
    private javax.swing.JLabel searchingLabel;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
