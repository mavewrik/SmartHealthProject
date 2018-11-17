/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorFunctions;

import DTO.Appointment;
import DTO.Patient;
import Service.DoctorService;
import Service.PatientService;
import UI.DoctorHome.DoctorHome;
import UI.DoctorReassign.DoctorReassign;
import UI.OPDLogs.OPDLogs;
import UI.ViewAppointment.ViewAppointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.*;

public class DoctorFunctions extends javax.swing.JFrame implements ActionListener {
    String Did;
    public DoctorFunctions(String Did) {
        this.Did = Did;
        initComponents();
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOCTOR FUNCTIONS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOCTOR FUNCTIONS");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SORT PATIENT BY CRITERIA");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "TYPE" }));

        jButton1.setText("SORT");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ENTER PATIENT ID");

        jButton2.setText("REASSIGN");

        jButton3.setText("VIEW APPOINTMENT HISTORY");

        jButton4.setText("BACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                .addComponent(jButton3)))
                                .addGap(31, 31, 31))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(186, 186, 186)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(257, 257, 257)
                                                .addComponent(jButton4)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(56, 56, 56)
                                .addComponent(jButton4)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void actionPerformed(ActionEvent ae)
    { 	String s=ae.getActionCommand();
        if(s.equals("SORT"))
        {
            if(jComboBox1.getSelectedItem().toString().compareTo("ID")==0)
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Object columnNames[] = { "Patient Name", "Patient Id", "Gender", " Phone Number", "Address", "Age" , "Ailment", "Health Status"};
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
                        ArrayList<Patient> result = DoctorService.getPatients(Did);
                        Collections.sort(result, new Comparator<Patient>() {
                            public int compare(Patient p1, Patient p2) {
                                return p1.getId().compareTo(p2.getId()); // Ascending
                            }

                        });
                        for (Patient p : result) {
                            String d1, d2, d3,d4 , d5,d6,d7,d8;
                            d1 = p.getName();
                            d2 = p.getId();
                            d3 = p.getGender();
                            d4 = p.getPhoneNumber();
                            d5 = p.getAddress();
                            d6 = String.valueOf(p.getAge());
                            d7 = p.getAilment();
                            d8 = p.getHealthStatus();
                            model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7,d8});
                        }

                    }
                });
            }
            else if(jComboBox1.getSelectedItem().toString().compareTo("NAME")==0)
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Object columnNames[] = { "Patient Name", "Patient Id", "Gender", " Phone Number", "Address", "Age" , "Ailment", "Health Status"};
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
                        ArrayList<Patient> result = DoctorService.getPatients(Did);
                        Collections.sort(result, new Comparator<Patient>() {
                            public int compare(Patient p1, Patient p2) {
                                return p1.getName().compareTo(p2.getName()); // Ascending
                            }

                        });
                        for (Patient p : result) {
                            String d1, d2, d3,d4 , d5,d6,d7,d8;
                            d1 = p.getName();
                            d2 = p.getId();
                            d3 = p.getGender();
                            d4 = p.getPhoneNumber();
                            d5 = p.getAddress();
                            d6 = String.valueOf(p.getAge());
                            d7 = p.getAilment();
                            d8 = p.getHealthStatus();
                            model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7,d8});
                        }

                    }
                });
            }
            else if(jComboBox1.getSelectedItem().toString().compareTo("TYPE")==0)
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Object columnNames[] = { "Patient Name", "Patient Id", "Gender", " Phone Number", "Address", "Age" , "Ailment", "Health Status"};
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
                        ArrayList<Patient> result = DoctorService.getPatients(Did);
                        Collections.sort(result, new Comparator<Patient>() {
                            public int compare(Patient p1, Patient p2) {
                                return p1.getType().compareTo(p2.getType()); // Ascending
                            }

                        });
                        for (Patient p : result) {
                            String d1, d2, d3,d4 , d5,d6,d7,d8;
                            d1 = p.getName();
                            d2 = p.getId();
                            d3 = p.getGender();
                            d4 = p.getPhoneNumber();
                            d5 = p.getAddress();
                            d6 = String.valueOf(p.getAge());
                            d7 = p.getAilment();
                            d8 = p.getHealthStatus();
                            model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7,d8});
                        }

                    }
                });
            }
        }
        else if(s.equals("REASSIGN"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorReassign(Did,jTextField1.getText()).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("VIEW APPOINTMENT HISTORY"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ArrayList<Appointment> a= new DoctorService().getAppointmentByCompletedPatientId(jTextField1.getText());
                    Object columnNames[] = { "Appointment ID","Doctor ID","Date","Status","Slot"};
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
                    for (Appointment p : a) {
                        String d1,d3,d4,d5,d6;
                        d1 = p.getId();
                        d3 = p.getDoctorId();
                        d4 = p.getDate();
                        d5 = p.getStatus();
                        d6 = p.getSlot();
                        model.addRow(new Object[]{d1,d3,d4,d5,d6});
                    }
                    new ViewAppointment(jTextField1.getText(),Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorHome(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}