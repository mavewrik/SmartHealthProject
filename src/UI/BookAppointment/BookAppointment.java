/*
 * Created by JFormDesigner on Fri Nov 02 13:07:13 IST 2018
 */

package UI.BookAppointment;

import UI.AdminLogin.AdminLogin;
import UI.DoctorLogin.DoctorLogin;
import UI.PatientHome.PatientHome;
import UI.PatientLogin.PatientLogin;
import UI.PatientRegistration.PatientRegistration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class BookAppointment extends JFrame implements ActionListener {
    String Pid;
    public BookAppointment(String Pid) {
        this.Pid = Pid;
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
        button1 = new JButton();
        button2 = new JButton();
        textField1 = new JTextField();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("APPOINTMENT HOME");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(125, 5, 215, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("DOCTOR ID");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(85, 80, 135, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("APPOINTMENT SLOT");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(70, 135, 165, label3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("SUBMIT");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(280, 260), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(115, 260), button2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(260, 75, 135, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(260, 130, 135, textField2.getPreferredSize().height);

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
        if(s.equals("SUBMIT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientHome(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
