/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorReassign;

import DTO.Department;
import DTO.Doctor;
import DTO.Patient;
import Exceptions.DepartmentListNotFoundException;
import Exceptions.DepartmentNotFoundException;
import Exceptions.DoctorListEmptyException;
import Exceptions.DoctorNotFoundException;
import Service.AdminService;
import Service.DoctorService;
import Service.PatientService;
import UI.DoctorFunctions.DoctorFunctions;
import UI.DoctorProfile.DoctorProfile;
import UI.Homepage.Homepage;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class DoctorReassign extends javax.swing.JFrame implements ActionListener {
    String Did;
    String Pid;
    public DoctorReassign(String Did,String Pid) {
        this.Did = Did;
        this.Pid = Pid;
        initComponents();
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOCTOR REASSIGN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOCTOR REASSIGN");

        jButton3.setText("BACK");

        jButton4.setText("SUBMIT");
        if(new DoctorService().isJuniorDoctor(Did)==true) {
            try {
                Doctor p = new DoctorService().getDoctorInfo(Did);
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{p.getDepartment()}));
            }
            catch(DoctorNotFoundException e){
                e.printStackTrace();
            }
        }
        else
        {
            try {
                ArrayList<Department> d = new AdminService().getAllDepartment();
                String[] id = new String[d.size()];
                int i = 0;
                for (Department dep : d) {
                    id[i++] = dep.getName();
                }
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(id));
            }
            catch (DepartmentListNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "InfoBox: " + "Department List Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        jComboBox1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    try {
                        Department d = new DoctorService().getDepartmentByName(jComboBox1.getSelectedItem().toString());
                        System.out.println("id is"+d.getId()+d.getName());
                        ArrayList<Doctor> a = new PatientService().getDoctorsByDepartment(d.getName());
                        String[] id = new String[a.size()];
                        int i = 0;
                        for (Doctor doc : a) {
                            id[i++] = doc.getId();
                        }
                        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(id));
                    }
                    catch(DepartmentNotFoundException e1){
                        e1.printStackTrace();
                    }
                    catch(DoctorListEmptyException e1){
                        JOptionPane.showMessageDialog(null, e1.toString(), "InfoBox: " + "Doctor list empty", JOptionPane.INFORMATION_MESSAGE);
                        new DoctorReassign(Did,Pid).setVisible(true);
                    }
                }
            }
        });
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("DEPARTMENT");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("DOCTOR ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 175, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(46, 46, 46))
        );

        pack();
    }
    public void actionPerformed(ActionEvent ae)
    { 	String s=ae.getActionCommand();
        if(s.equals("SUBMIT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorService().reassignment(Pid,Did,jComboBox2.getSelectedItem().toString());
                    new DoctorFunctions(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorFunctions(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
