/*
 * Created by JFormDesigner on Thu Nov 01 22:19:31 IST 2018
 */

package UI.Homepage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import UI.AdminLogin.*;
import UI.DoctorLogin.DoctorLogin;
import UI.PatientRegistration.*;
import UI.PatientLogin.*;

/**
 * @author Alvin Dey
 */
public class Homepage extends JFrame implements ActionListener{
    public Homepage() {
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("SMART HEALTHCARE SYSTEM HOMEPAGE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(60, 10, 340, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Patient Registration");
        contentPane.add(button1);
        button1.setBounds(30, 120, 180, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Patient Login");
        contentPane.add(button2);
        button2.setBounds(30, 210, 180, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("Admin Login");
        contentPane.add(button3);
        button3.setBounds(255, 120, 190, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("Doctor Login");
        contentPane.add(button4);
        button4.setBounds(255, 210, 190, button4.getPreferredSize().height);

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
        else if(s.equals("Doctor Login"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorLogin().setVisible(true);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
