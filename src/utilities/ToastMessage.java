/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author 2ndyrGroupB
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ToastMessage extends JDialog {

    private static final long serialVersionUID = 1L;
    private static Boolean spamProtect = false;
    private final int milliseconds = 2000;

    public ToastMessage(JComponent caller, String toastString,String type) {
        if(spamProtect) {
            return;
        }
        setUndecorated(true);
        setAlwaysOnTop(true);
        setFocusableWindowState(false);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JLabel toastLabel = new JLabel(toastString);
        if(type.equals("error")){
            panel.setBackground(new Color(255,0,0));
            toastLabel.setForeground(Color.WHITE);
             toastLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/alert-circle.png")));
        }else if(type.equals("success")){
            panel.setBackground(new Color(0,153,51));
            toastLabel.setForeground(Color.WHITE);
            toastLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/check.png")));
        }else if(type.equals("info")){
            panel.setBackground(new Color(51,102,255));
            toastLabel.setForeground(Color.WHITE);
            toastLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/check.png")));
        }
        toastLabel.setBorder(new EmptyBorder(-3,10,0,0));
        panel.setPreferredSize(new Dimension(220, 40));
        
        panel.add(toastLabel);
        add(panel);
        pack();

        Window window = SwingUtilities.getWindowAncestor(caller);
        int xcoord = window.getLocationOnScreen().x + window.getWidth() / 2 - getWidth() / 2;
        int ycoord = window.getLocationOnScreen().y + (int)((double)window.getHeight() * 0.75) - getHeight() / 2;
        setLocation(xcoord, ycoord-100);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);

        new Thread(){
            public void run() {
                try {
                    spamProtect = true;
                    Thread.sleep(milliseconds);
                    dispose();
                    spamProtect = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}