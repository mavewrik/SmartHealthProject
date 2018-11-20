/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorHome;

import DTO.Patient;
import Exceptions.PatientListNotFoundException;
import Service.AdminService;
import Service.DoctorService;
import UI.DoctorFunctions.DoctorFunctions;
import UI.DoctorProfile.DoctorProfile;
import UI.Homepage.Homepage;
import UI.PatientDetails.PatientDetails;
import UI.PatientHome.PatientHome;
import UI.ViewPatient.ViewPatient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DoctorHome extends javax.swing.JFrame implements ActionListener {
    String Did;
    public DoctorHome(String Did) {
        this.Did = Did;
        initComponents();
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOCTOR HOMEPAGE");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOCTOR HOMEPAGE");

        jButton1.setText("VIEW ASSIGNED LIST");

        jButton2.setText("EDIT PROFILE");

        jButton3.setText("LOGOUT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void actionPerformed(ActionEvent ae)
    { 	String s=ae.getActionCommand();
        if(s.equals("VIEW ASSIGNED LIST"))
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
                    try {
                        ArrayList<Patient> result = DoctorService.getPatients(Did);
                        for (Patient p : result) {
                            String d1, d2, d3, d4, d5, d6, d7, d8;
                            d1 = p.getName();
                            d2 = p.getId();
                            d3 = p.getGender();
                            d4 = p.getPhoneNumber();
                            d5 = p.getAddress();
                            d6 = String.valueOf(p.getAge());
                            d7 = p.getAilment();
                            d8 = p.getHealthStatus();
                            model.addRow(new Object[]{d1, d2, d3, d4, d5, d6, d7, d8});
                        }
                        new DoctorFunctions(Did).setVisible(true);
                    }
                    catch(PatientListNotFoundException e)
                    {
                        JOptionPane.showMessageDialog(null, e.toString(), "InfoBox: " + "Patient List Not Found", JOptionPane.INFORMATION_MESSAGE);
                        new DoctorHome(Did).setVisible(true);
                    }
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("EDIT PROFILE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorProfile(Did).setVisible(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
