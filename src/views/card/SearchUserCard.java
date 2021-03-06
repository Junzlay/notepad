/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.card;

import models.SearchUserObject;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author 2ndyrGroupB
 */
public class SearchUserCard extends javax.swing.JPanel implements ListCellRenderer<SearchUserObject> {

    /**
     * Creates new form SearchUserCard
     */
    public SearchUserCard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setText("Name");
        add(name);
        name.setBounds(50, 10, 200, 17);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(10, 40, 273, 1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/account-circle-outline.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(20, 10, 30, 20);
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends SearchUserObject> list, SearchUserObject value, int index, boolean isSelected, boolean cellHasFocus) {
       this.name.setText(value.getName());
       return this;
    }
}
