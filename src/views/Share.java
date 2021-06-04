/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import utilities.ToastMessage;
import models.SelectedUser;
import models.User;
import services.DatabaseConnection;

/**
 *
 * @author 2ndyrGroupB
 */
public class Share extends javax.swing.JDialog {

    List userList = new ArrayList<>();

    DefaultListModel usermodel = new DefaultListModel();
    DefaultListModel model = new DefaultListModel();
    User user = new User();
    private int sharePrivileges = 0;
    SelectedUser shareTo = new SelectedUser();
    private int noteID = new Notes().viewID;
    DatabaseConnection db = new DatabaseConnection();
//    SharedUser shared;

    /**
     * Creates new form Share
     */
    public Share() {

        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        getContentPane().setBackground(new Color(204, 204, 204));
        access.setVisible(false);
        peoplePane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        peoplePane.getViewport().setBorder(null);
        peoplePane.setViewportBorder(null);
        peoplePane.setBorder(null);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        getContentPane().requestFocusInWindow();
//        owner.setText(new Notes().userName + " | Owner");
//        this.model.addElement(new Notes().userName + " | Owner");
        showUser();
        displaySharedUser();
    }

    private void showUser() {
        shareContainer.removeAll();
        shareContainer.add(searchList);
        shareContainer.repaint();
        shareContainer.revalidate();
    }

    private void showSearch() {
        shareContainer.removeAll();
        shareContainer.add(searchCard);
        shareContainer.repaint();
        shareContainer.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        add = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        access = new javax.swing.JComboBox<>();
        owner = new javax.swing.JLabel();
        share = new javax.swing.JButton();
        shareContainer = new javax.swing.JPanel();
        searchPane = new javax.swing.JScrollPane();
        searchCard = new javax.swing.JList<>();
        peoplePane = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        container = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/account-circle -black.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Share with people");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("x");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 20, -1));

        add.setForeground(new java.awt.Color(51, 51, 51));
        add.setText("Add people ");
        add.setBorder(null);
        add.setCaretPosition(0);
        add.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addFocusLost(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addKeyTyped(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 170, 20));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        access.setBackground(new java.awt.Color(51, 51, 255));
        access.setForeground(new java.awt.Color(255, 255, 255));
        access.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View", "Edit" }));
        access.setBorder(null);
        access.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accessMouseClicked(evt);
            }
        });
        getContentPane().add(access, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 70, 20));

        owner.setText("Junmar Layaog | Owner");
        getContentPane().add(owner, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 240, -1));

        share.setBackground(new java.awt.Color(51, 51, 255));
        share.setForeground(new java.awt.Color(255, 255, 255));
        share.setText("Share");
        share.setContentAreaFilled(false);
        share.setOpaque(true);
        share.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shareMouseClicked(evt);
            }
        });
        share.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareActionPerformed(evt);
            }
        });
        getContentPane().add(share, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 167, 70, -1));

        shareContainer.setBackground(new java.awt.Color(255, 255, 255));
        shareContainer.setLayout(new java.awt.CardLayout());

        searchCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCardMouseClicked(evt);
            }
        });
        searchPane.setViewportView(searchCard);

        shareContainer.add(searchPane, "card3");

        peoplePane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchListMouseClicked(evt);
            }
        });
        peoplePane.setViewportView(searchList);

        shareContainer.add(peoplePane, "card2");

        getContentPane().add(shareContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 250, 80));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/alert-box.png"))); // NOI18N
        container.setOpaque(true);
        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 360, 201));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void shareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shareActionPerformed

    private void addKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyTyped
        // TODO add your handling code here:

        if (add.getText().equals("Add people ")) {
            add.setText("");
        }
        if (add.getText().equals("")) {
            model.removeAllElements();
        }
        search();
        showSearch();
    }//GEN-LAST:event_addKeyTyped

    private void searchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchListMouseClicked
        this.setTitle(" Access");
        String value=JOptionPane.showInputDialog(this,"Message? ");
      
//        if (!searchList.isSelectionEmpty()) {
//            
//            String added = searchList.getSelectedValue();
//            for (Object list : userList) {
//                if (!add.getText().toLowerCase().contains(added.toLowerCase())) {
//
//                    if (!added.equals(list.toString().trim())) {
//                        shareTo.insertUser(added);
//                        add.setText(String.valueOf(shareTo.showList()));
//
//                        add.requestFocus();
//                        model.removeAllElements();
//                        access.setVisible(true);
//                    }
//
//                } else {
//
//                    new ToastMessage(this.getRootPane(), "User already exist", "info");
//
//                }
//            }
//        }
//            if (!add.getText().toLowerCase().contains(added.toLowerCase())) {
//
//                if (!added.equals(new Notes().userName + " | Owner")) {
//                    shareTo.insertUser(added);
//                    add.setText(String.valueOf(shareTo.showList()));
//
//                    add.requestFocus();
//                    model.removeAllElements();
//                    access.setVisible(true);
//                }
//
//            } else {
//
//                new ToastMessage(this.getRootPane(), "User already exist", "info");
//
//            }

    }//GEN-LAST:event_searchListMouseClicked
//    List<String> selectedUser = new ArrayList<String>();

    private void displaySharedUser() {
        String sql = "Select * from shared where noteID='" + noteID + "' order by sharedID desc";
        try {
            ResultSet rs = db.Query(sql);
            usermodel.addElement(String.format("%-40s %15s", new Notes().userName, "Owner"));
            while (rs.next()) {
                String user = String.format("%-40s %15s", rs.getString("sharesTo"), rs.getInt("status") == 0 ? "Can view" : "Can edit");
                usermodel.addElement(user);
                userList.add(rs.getString("sharesTo"));
            };
            searchList.setModel(usermodel);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    private void sharedTo(String names) {
        model.addElement(names + " | friend");
    }

    private void insertUsers(List<String> list, int noteID, int status) throws Exception {
        final int batchSize = 1000; //Batch size is important.
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/yournotepad", "root", "");
        try {

            String sql = "INSERT INTO shared (noteID,sharesTo,status) VALUES (?,?,?)";
            ps = con.prepareStatement(sql);
//            db.setPreparedStatement(db.getConnection().prepareStatement(sql));

            int insertCount = 0;
            for (String item : list) {
                ps.setInt(1, noteID);
                ps.setString(2, item);
                ps.setInt(3, status);
                ps.addBatch();
                if (++insertCount % batchSize == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void addKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyReleased
        // TODO add your handling code here:
        if (add.getText().equals("")) {
            add.setText("Add people ");
            add.setCaretPosition(0);
            model.removeAllElements();
        }

        add.requestFocus();

    }//GEN-LAST:event_addKeyReleased

    private void shareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shareMouseClicked

        try {
            insertUsers(shareTo.getUser(), noteID, sharePrivileges);
            new ToastMessage(this.getRootPane(), "Share SuccessFully", "success");
//        NoteController controller = new NoteController();
//        int result = 0;
//        try {
//            result = controller.shareTo(shareTo.getUser().toString(), noteID, sharePrivileges);
//        } catch (Exception ex) {
//            Logger.getLogger(CreateNote.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (result == 1) {
//            new ToastMessage(this.getRootPane(), "Share SuccessFully", "success");
//            this.dispose();
//        } else {
//            new ToastMessage(this.getRootPane(), "Error", "error");
//            this.dispose();
//        }
        } catch (Exception ex) {
            Logger.getLogger(Share.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_shareMouseClicked

    private void addFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusGained

        if (add.getText().equals("Add people ")) {
            add.setText("");
        }
        if (add.getText().equals("")) {
            model.removeAllElements();
        }
    }//GEN-LAST:event_addFocusGained

    private void addFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusLost
//        showUser();
        if (add.getText().equals("")) {
            add.setText("Add people ");
            add.setCaretPosition(0);
            model.removeAllElements();
        }
    }//GEN-LAST:event_addFocusLost

    private void accessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessMouseClicked
        sharePrivileges = access.getSelectedItem().toString().equals("View") ? 0 : 1;
        System.out.println(access.getSelectedItem().toString());
    }//GEN-LAST:event_accessMouseClicked

    private void searchCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCardMouseClicked
        String added = searchCard.getSelectedValue();
        if (!add.getText().toLowerCase().contains(added.toLowerCase())) {

//            if (!added.equals(new Notes().userName + " | Owner")) {
            shareTo.insertUser(added);
            add.setText(String.valueOf(shareTo.showList()));

            add.requestFocus();
            model.removeAllElements();
            access.setVisible(true);
//            }

        } else {

            new ToastMessage(this.getRootPane(), "User already exist", "info");

        }
    }//GEN-LAST:event_searchCardMouseClicked

    private void search() {
        String user = add.getText();
        if (user.contains(",")) {
            String result[] = user.split(",");
            user = result[result.length - 1];
        }
        model.removeAllElements();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yournotepad", "root", "");
            String sql = "SELECT * FROM users WHERE userID Like ? OR username LIKE ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, "%" + user + "%");
            stmt.setString(2, "%" + user + "%");

            ResultSet rs = stmt.executeQuery();
            boolean isHave = false;
            while (rs.next()) {

                String name = rs.getString("username");

                isHave = checkUser(name);
                if (!name.equals(new Notes().userName) && !isHave) {
                    model.addElement(name);
                }

                add.requestFocus();
            }

            searchCard.setModel(model);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkUser(String name) {
        boolean has = false;
        for (Object users : userList) {
            if (users.toString().trim().equals(name)) {
                has = true;
            }
        }
        return has;
    }

private void accessDialog(){
        
    JDialog dialog = new JDialog();
dialog.setSize(300, 200);
dialog.setLayout(null);
JButton button = new JButton("Testbutton!");
button.setVisible(true);
button.setBounds(10,10,40,40);
dialog.add(button);

//Make dialog visible
dialog.setVisible(true);
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
            java.util.logging.Logger.getLogger(Share.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Share.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Share.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Share.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Share().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> access;
    private javax.swing.JTextField add;
    private javax.swing.JLabel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel owner;
    private javax.swing.JScrollPane peoplePane;
    private javax.swing.JList<String> searchCard;
    private javax.swing.JList<String> searchList;
    private javax.swing.JScrollPane searchPane;
    private javax.swing.JButton share;
    private javax.swing.JPanel shareContainer;
    // End of variables declaration//GEN-END:variables
}
