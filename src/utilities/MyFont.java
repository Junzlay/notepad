/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import views.auth.Login;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 2ndyrGroupB
 */
public class MyFont {

    public MyFont() {
    }

    
      public MyFont(JLabel label, int size) {
        Font poppins = null;
        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Regular.otf"));
           
            poppins = poppins.deriveFont(Font.PLAIN, size);
            label.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public MyFont(JButton label, int size) {
        Font poppins = null;
        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Regular.otf"));
           
            poppins = poppins.deriveFont(Font.PLAIN, size);
            label.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public MyFont(JTextArea label, int size) {
        Font poppins = null;
        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Regular.otf"));
           
            poppins = poppins.deriveFont(Font.PLAIN, size);
            label.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public MyFont(JTextField label, int size) {
        Font poppins = null;
        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Regular.otf"));
           
            poppins = poppins.deriveFont(Font.PLAIN, size);
            label.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public MyFont(JLabel label, int size, String weight) {
        Font poppins = null;
        try {
            if (weight.equals("medium")){
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Medium.otf"));
            }else if(weight.equals("light")){
                poppins=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/dist/fonts/Poppins-Light.otf"));
                }

            poppins = poppins.deriveFont(Font.PLAIN, size);
            label.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MyFont(JButton button, int size,String weight) {
        Font poppins = null;
        try {
             if (weight.equals("medium")){
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Medium.otf"));
            }else if(weight.equals("light")){
                poppins=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/dist/fonts/Poppins-Light.otf"));
                }
            
            poppins = poppins.deriveFont(Font.PLAIN, size);
            button.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public MyFont(JTextField field, int size,String weight) {
        Font poppins = null;
        try {
             if (weight.equals("medium")){
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/dist/fonts/Poppins-Medium.otf"));
            }else if(weight.equals("light")){
                poppins=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/dist/fonts/Poppins-Light.otf"));
                }
            
            poppins = poppins.deriveFont(Font.PLAIN, size);
            field.setFont(poppins);
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
