/*
 * Created by JFormDesigner on Wed Oct 31 22:01:55 IST 2018
 */

package Homepage;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import AdminLogin.*;
import PatientRegistration.*;
import PatientLogin.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class Homepage extends JFrame implements ActionListener{
    public Homepage() {
        initComponents();
    }

    private void initComponents() {
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        label1.setText("                                            Smart Health System");
        contentPane.add(label1);
        label1.setBounds(30, 10, 375, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Patient Registration");
        contentPane.add(button1);
        button1.setBounds(50, 115, 195, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Patient Login");
        contentPane.add(button2);
        button2.setBounds(320, 115, 185, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("Doctor Registration");
        contentPane.add(button3);
        button3.setBounds(55, 200, 185, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("Doctor Login");
        contentPane.add(button4);
        button4.setBounds(325, 200, 185, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("Admin Login");
        contentPane.add(button5);
        button5.setBounds(205, 280, 175, 30);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void actionPerformed(ActionEvent ae)
    { 	String s=ae.getActionCommand();
        if(s.equals("Admin Login"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
            this.setVisible(false);
        }
        else if(s.equals("Patient Registration"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientRegistration().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("Patient Login"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientLogin().setVisible(true);
                }
            });
            this.setVisible(false);
        }

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
