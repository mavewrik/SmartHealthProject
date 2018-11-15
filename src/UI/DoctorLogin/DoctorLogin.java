/*
 * Created by JFormDesigner on Thu Nov 01 22:40:59 IST 2018
 */

package UI.DoctorLogin;

import UI.DoctorHome.DoctorHome;
import UI.Homepage.Homepage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class DoctorLogin extends JFrame implements ActionListener {
    public DoctorLogin() {

        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
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
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("DOCTOR LOGIN");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(110, 10, 180, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("USERNAME");
        contentPane.add(label2);
        label2.setBounds(50, 60, 100, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("PASSWORD");
        contentPane.add(label3);
        label3.setBounds(50, 110, 90, label3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(170, 55, 170, textField1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(170, 105, 170, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(80, 185, button1.getPreferredSize().width, 25);

        //---- button2 ----
        button2.setText("LOGIN");
        contentPane.add(button2);
        button2.setBounds(245, 185, button2.getPreferredSize().width, 25);

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
        if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Homepage().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("LOGIN"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorHome(textField1.getText()).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
