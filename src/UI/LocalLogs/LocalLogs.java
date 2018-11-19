/*
 * Created by JFormDesigner on Sat Nov 17 02:44:05 IST 2018
 */

package UI.LocalLogs;

import DTO.Appointment;
import DTO.Patient;
import Service.AdminService;
import Service.PatientService;
import UI.AdminLogin.AdminLogin;
import UI.DoctorLogin.DoctorLogin;
import UI.PatientLogin.PatientLogin;
import UI.PatientRegistration.PatientRegistration;
import UI.ViewPatient.ViewPatient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class LocalLogs extends JFrame implements ActionListener {
    String Pid;
    public LocalLogs(String Pid) {
        this.Pid = Pid;
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
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("LOCAL PATIENT LOGS");
        contentPane.add(label1);
        label1.setBounds(230, 5, 170, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("APPOINTMENT ID");
        contentPane.add(label2);
        label2.setBounds(25, 75, 180, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("DATE OF DISCHARGE");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(10, 120, 170, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("TIME OF DISCHARGE");
        contentPane.add(label4);
        label4.setBounds(300, 120, 165, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("MEDICINES");
        contentPane.add(label5);
        label5.setBounds(25, 165, 150, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("TESTS RECOMMENDED");
        contentPane.add(label6);
        label6.setBounds(20, 210, 170, label6.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(190, 70, 350, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(190, 115, 85, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(470, 115, 70, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(190, 160, 205, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(190, 205, 205, textField5.getPreferredSize().height);

        //---- button1 ----
        button1.setText("ADD MEDICINE");
        contentPane.add(button1);
        button1.setBounds(410, 160, 130, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("ADD TEST");
        contentPane.add(button2);
        button2.setBounds(410, 205, 130, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("BACK");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(170, 270), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("SUBMIT");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(360, 270), button4.getPreferredSize()));

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
        if(s.equals("ADD MEDICINE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminService().addMedicine(Pid,textField4.getText(),textField1.getText());
                }
            });
        }
        else if(s.equals("ADD TEST"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminService().addTest(Pid,textField5.getText(),textField1.getText());
                }
            });
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewPatient().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("SUBMIT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    Appointment a = new PatientService().getAppointmentById(textField1.getText());
                    new AdminService().addPatientLogs(Pid,a.getDate(),a.getSlot(),textField2.getText(),textField3.getText(),textField1.getText());
                    new ViewPatient().setVisible(true);
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
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
