/*
 * Created by JFormDesigner on Thu Nov 15 05:52:46 IST 2018
 */

package UI.HODHome;

import DTO.Patient;
import DTO.UpdateDoctorRequest;
import Service.DoctorService;
import Service.HodService;
import UI.DoctorFunctions.DoctorFunctions;
import UI.DoctorProfile.DoctorProfile;
import UI.HODProfile.HODProfile;
import UI.HODRequests.HODRequests;
import UI.Homepage.Homepage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HODHome extends JFrame implements ActionListener {
    String Did;
    public HODHome(String Did) {
        this.Did = Did;
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
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
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("HOD HOMEPAGE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(160, 5, 135, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("VIEW ASSIGNED LIST");
        contentPane.add(button1);
        button1.setBounds(30, 80, 170, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("EDIT PROFILE");
        contentPane.add(button2);
        button2.setBounds(260, 80, 160, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("ADMINISTRATIVE REQUESTS");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(120, 145), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("LOGOUT");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(180, 205), button4.getPreferredSize()));

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
                    ArrayList<Patient> result = DoctorService.getPatients(Did);
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
                    new DoctorFunctions(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("EDIT PROFILE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HODProfile(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("ADMINISTRATIVE REQUESTS"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Object columnNames[] = { "Reassignment Id","Department ID","Doctor ID","Designation","Specialization","Surgeon","Status"};
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
                    ArrayList<UpdateDoctorRequest> result = new HodService().getAllRequest(Did);
                    for (UpdateDoctorRequest p : result) {
                        String d1, d2, d3,d4 , d5,d6,d7;
                        d1 = p.getId();
                        d2 = p.getDepartmentId();
                        d3 = p.getDoctorId();
                        d4 = p.getDesignation();
                        d5 = p.getSpecialization();
                        d6 = p.getSurgeon();
                        d7 = p.getStatus();
                        model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7});
                    }
                    new HODRequests(Did).setVisible(true);
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
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
