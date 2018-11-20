/*
 * Created by JFormDesigner on Tue Nov 20 17:28:53 IST 2018
 */

package UI.DoctorDetails;

import DTO.Doctor;
import Exceptions.DoctorNotFoundException;
import Service.DoctorService;
import UI.DoctorProfile.DoctorProfile;
import UI.HODProfile.HODProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DoctorDetails extends JFrame implements ActionListener {
    String Did;
    public DoctorDetails(String Did) {
        this.Did = Did;
        initComponents();
        fillDetails();
        button1.addActionListener(this);
        button2.addActionListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        textField1 = new JTextField();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        passwordField1 = new JPasswordField();
        label6 = new JLabel();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(170, 40, 420, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(210, 240), button1.getPreferredSize()));

        //---- label1 ----
        label1.setText("NAME");
        contentPane.add(label1);
        label1.setBounds(75, 45, 70, 25);

        //---- label2 ----
        label2.setText("DOCTOR DETAILS");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(255, 5, 165, label2.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(170, 85, 105, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("AGE");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(75, 90, 45, 25);

        //---- label4 ----
        label4.setText("PHONE");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label4);
        label4.setBounds(280, 85, 85, 30);
        contentPane.add(textField3);
        textField3.setBounds(370, 85, 225, textField3.getPreferredSize().height);

        //---- label5 ----
        label5.setText("ADDRESS");
        contentPane.add(label5);
        label5.setBounds(70, 140, 75, label5.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(170, 135, 425, textField4.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(170, 185, 425, passwordField1.getPreferredSize().height);

        //---- label6 ----
        label6.setText("PASSWORD");
        contentPane.add(label6);
        label6.setBounds(60, 190, 95, label6.getPreferredSize().height);

        //---- button2 ----
        button2.setText("UPDATE");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(415, 240), button2.getPreferredSize()));

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
    private void fillDetails()
    {   try {
        Doctor d = DoctorService.getDoctorInfo(Did);
        textField1.setText(d.getName());
        textField2.setText(String.valueOf(d.getAge()));
        textField3.setText(d.getPhoneNumber());
        textField4.setText(d.getAddress());
        passwordField1.setText(d.getPassword());
        /*textField1.setText("Hi");
        textField2.setText("85");
        textField3.setText("dgdg");
        textField4.setText("ddsg");
        passwordField1.setText("dgdgg");*/
    }
    catch(DoctorNotFoundException e){
        e.printStackTrace();
    }

    }
    public void actionPerformed(ActionEvent ae)
    { 	String s=ae.getActionCommand();
        if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    if (new DoctorService().isHod(Did) == true) {
                        new HODProfile(Did).setVisible(true);
                    } else
                        new DoctorProfile(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("UPDATE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Doctor temp = DoctorService.getDoctorInfo(Did);
                        String DoctorName = textField1.getText();
                        int DoctorAge = Integer.parseInt(textField2.getText());
                        String DoctorPhone = textField3.getText();
                        String DoctorAddress = textField4.getText();
                        String DoctorPassword = String.valueOf(passwordField1.getPassword());
                        String DoctorGender = temp.getGender();
                        String DoctorId = temp.getId();
                        String Doctordepartment = temp.getDepartment();
                        Boolean hod = temp.isHod();
                        String specialization = temp.getSpecialization();
                        String designation = temp.getDesignation();
                        String surgeon = temp.getSurgeon();
                        String rating = temp.getRating();
                        Doctor d = new Doctor(DoctorName, DoctorId, Doctordepartment, hod, specialization, DoctorAge, DoctorAddress, DoctorPhone, DoctorGender, DoctorPassword, designation, surgeon, rating);
                        new DoctorService().updateDoctorInfo(d);
                        if (new DoctorService().isHod(Did) == true) {
                            new HODProfile(Did).setVisible(true);
                        } else
                            new DoctorProfile(Did).setVisible(true);
                    }
                    catch(DoctorNotFoundException e){
                        e.printStackTrace();
                    }
                }
            });
            this.setVisible(false);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JTextField textField1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JLabel label6;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
