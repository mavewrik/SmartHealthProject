/*
 * Created by JFormDesigner on Fri Nov 02 13:16:42 IST 2018
 */

package UI.DoctorSelection;

import Service.AdminService;
import UI.DoctorHome.DoctorHome;
import UI.PatientHome.PatientHome;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DoctorSelection extends JFrame implements ActionListener {
    String Pid ;
    public DoctorSelection(String Pid) {
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
        label4 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        comboBox2 = new JComboBox();
        button2 = new JButton();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("SHS DOCTOR SELECTION");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(135, 10, 195, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Department");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(70, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Date of Appointment");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(40, 105), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("Preferrable Slot");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(60, 145), label4.getPreferredSize()));

        //---- button1 ----
        button1.setText("SUBMIT");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(275, 215), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(225, 100, 200, textField1.getPreferredSize().height);
        contentPane.add(comboBox2);
        comboBox2.setBounds(225, 60, 195, comboBox2.getPreferredSize().height);
        comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "OPHTHALMOLOGY", "NEUROLOGY", "ONCOLOGY", "PEDIATRICS", "CARDIOLOGY", "ENT", "GASTROENTEROLOGY", "GYNAECOLOGY", "ORTHOPAEDICS", "UROLOGY", "ANAESTHETICS", "IMMUNOLOGY", "DERMATOLOGY", "NEPHROLOGY", "PATHOLOGY", "PSYCHIATRY", "RADIOLOGY", "RHEUMATOLOGY" }));
        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(80, 215), button2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(225, 140, 200, textField2.getPreferredSize().height);

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
                    String department = comboBox2.getSelectedItem().toString();
                    String date = textField1.getText();
                    String slot = textField2.getText();
                    Date d = new Date();
                    DateFormat format = new SimpleDateFormat("dd/M/yyyy");
                    try {
                        d = format.parse(textField1.getText());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat df = new SimpleDateFormat("EEEE");
                    String day = df.format(d);
                    new AdminService().allocateDoctor(Pid,department,date,day,slot);
                }
            });
            this.setVisible(false);
            new PatientHome(Pid).setVisible(true);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientHome(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
            new PatientHome(Pid).setVisible(true);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JButton button2;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
