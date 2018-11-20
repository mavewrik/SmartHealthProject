/*
 * Created by JFormDesigner on Thu Nov 01 20:28:55 IST 2018
 */

package UI.OPDLogs;

import DTO.Appointment;
import Exceptions.AppointmentNotFoundException;
import Service.AdminService;
import Service.PatientService;
import UI.ViewPatient.ViewPatient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class OPDLogs extends JFrame implements ActionListener {
    String Pid;
    public OPDLogs(String Pid) {
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
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        textField3 = new JTextField();
        label12 = new JLabel();
        textField8 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label8);
        label8.setBounds(55, 400, 30, label8.getPreferredSize().height);

        //---- label9 ----
        label9.setText("OPD PATIENT LOGS");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label9);
        label9.setBounds(200, 10, 255, label9.getPreferredSize().height);

        //---- label10 ----
        label10.setText("Medicines");
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label10);
        label10.setBounds(45, 140, 90, label10.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(200, 135, 270, textField3.getPreferredSize().height);

        //---- label12 ----
        label12.setText("Tests Recommended");
        contentPane.add(label12);
        label12.setBounds(15, 185, 170, 25);
        contentPane.add(textField8);
        textField8.setBounds(200, 180, 270, textField8.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(165, 270, 95, 30);

        //---- button2 ----
        button2.setText("SUBMIT");
        contentPane.add(button2);
        button2.setBounds(425, 270, 105, 30);

        //---- button3 ----
        button3.setText("ADD MEDICINE");
        contentPane.add(button3);
        button3.setBounds(495, 135, 128, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("ADD TEST");
        contentPane.add(button4);
        button4.setBounds(495, 180, 130, button4.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Appointment Id");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(10, 95, 165, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(200, 90, 270, textField1.getPreferredSize().height);

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
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("ADD MEDICINE")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminService().addMedicine(Pid, textField3.getText(),textField1.getText());
                }
            });
        } else if (s.equals("ADD TEST")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminService().addTest(Pid, textField8.getText(),textField1.getText());
                }
            });
        } else if (s.equals("BACK")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewPatient().setVisible(true);
                }
            });
            this.setVisible(false);
        } else if (s.equals("SUBMIT")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Appointment a = new PatientService().getAppointmentById(textField1.getText());
                        new AdminService().addPatientLogs(Pid, a.getDate(), a.getSlot(), "N.A", "N.A", textField1.getText());
                    }
                    catch(AppointmentNotFoundException e){
                        JOptionPane.showMessageDialog(null, e.toString(), "InfoBox: " + "Appointment not found exception", JOptionPane.INFORMATION_MESSAGE);
                        new OPDLogs(Pid).setVisible(true);
                    }
                    }
            });
            this.setVisible(false);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField3;
    private JLabel label12;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
