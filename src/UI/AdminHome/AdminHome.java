package UI.AdminHome;

import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

import DTO.Doctor;
import DTO.Patient;
import DTO.Reassignment;
import Service.AdminService;
import UI.AdminLogin.AdminLogin;
import UI.DepartmentRegistration.DepartmentRegistration;
import UI.DoctorLogin.DoctorLogin;
import UI.Homepage.Homepage;
import UI.PatientLogin.PatientLogin;
import UI.PatientRegistration.PatientRegistration;
import UI.DoctorRegistration.*;
import UI.ReassignmentHome.ReassignmentHome;
import UI.ViewDoctor.*;
import UI.ViewPatient.ViewPatient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;


public class AdminHome extends JFrame implements ActionListener{
    public AdminHome() {
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
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
        button1 = new JButton();
        label1 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Add Doctor");
        contentPane.add(button1);
        button1.setBounds(80, 65, 155, button1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("ADMIN HOMEPAGE");
        contentPane.add(label1);
        label1.setBounds(205, 10, 150, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Reassignment Requests");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(285, 65), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("View Patients");
        contentPane.add(button3);
        button3.setBounds(80, 135, 155, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("View Doctors");
        contentPane.add(button4);
        button4.setBounds(285, 135, 195, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("LOGOUT");
        contentPane.add(button5);
        button5.setBounds(210, 265, 110, button5.getPreferredSize().height);

        //---- button6 ----
        button6.setText("Add Department");
        contentPane.add(button6);
        button6.setBounds(190, 195, 150, 35);

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
        if(s.equals("Add Doctor"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorRegistration().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("Reassignment Requests"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Object columnNames[] = { "Reassignment ID", "Patient Id", "Referring Doctor Id", "Referred Doctor Id", "Status"};
                    Object[][] data = {};
                    DefaultTableModel dm = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable(dm);
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(300, 150);
                    frame.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    ArrayList<Reassignment> result = AdminService.showAllReassignment();
                    for (Reassignment p : result) {
                        String d1, d2, d3,d4 , d5;
                        d1 = p.getId();
                        d2 = p.getPatientId();
                        d3 = p.getReferringDoctorId();
                        d4 = p.getReferredDoctorId();
                        d5 = p.getStatus();
                        model.addRow(new Object[]{d1,d2,d3,d4,d5});
                    }
                    new ReassignmentHome().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("View Patients"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Object columnNames[] = { "Patient Name", "Patient Id", "Gender", " Phone Number", "Address" };
                    Object[][] data = {};
                    DefaultTableModel dm = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable(dm);
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(300, 150);
                    frame.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    ArrayList<Patient> result = AdminService.showAllPatient();
                    for (Patient p : result) {
                        String d1, d2, d3,d4 , d5;
                        d1 = p.getName();
                        d2 = p.getId();
                        d3 = p.getGender();
                        d4 = p.getPhoneNumber();
                        d5 = p.getAddress();
                        model.addRow(new Object[]{d1,d2,d3,d4,d5});
                    }
                    new ViewPatient().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("View Doctors"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Object columnNames[] = { "Doctor Name", "Doctor Id", "Department" };
                    Object[][] data = {};
                    DefaultTableModel dm = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable(dm);
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(300, 150);
                    frame.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    ArrayList<Doctor> result = AdminService.showAllDoctor();
                    for (Doctor doc : result) {
                        String d1, d2, d3;
                        d1 = doc.getName();
                        d2 = doc.getId();
                        d3 = doc.getDepartment();
                        model.addRow(new Object[]{d1,d2,d3});
                    }
                    new ViewDoctor().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("Add Department"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DepartmentRegistration().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("LOGOUT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Homepage().setVisible(true);
                }
            });
            this.setVisible(false);
        }

    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
