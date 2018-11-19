/*
 * Created by JFormDesigner on Thu Nov 01 20:21:34 IST 2018
 */

package UI.ViewPatient;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

import DTO.Appointment;
import DTO.Patient;
import Service.AdminService;
import Service.PatientService;
import UI.AdminHome.AdminHome;
import UI.Homepage.*;
import UI.LocalLogs.LocalLogs;
import UI.OPDLogs.OPDLogs;


public class ViewPatient extends JFrame implements ActionListener{

    public ViewPatient() {

        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        button2 = new JButton();
        label3 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("ENTER LOGS");
        contentPane.add(button1);
        button1.setBounds(185, 140, 165, button1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(315, 65, 160, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("PATIENT LIST");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(170, 5, 205, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 200), button2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Patient ID");
        label3.setAutoscrolls(true);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(95, 70, 105, label3.getPreferredSize().height);

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
        //System.out.print(s);
        if(s.equals("BACK"))
        {   //System.out.print("bfr");
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                   // System.out.print("aftr");
                    new AdminHome().setVisible(true);
                }
            });
            this.setVisible(false);

        }
        else if(s.equals("ENTER LOGS"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Patient m =new PatientService().getPatientInfo(textField1.getText());
                    System.out.println(m.getName());
                    System.out.println(m.getType());
                    if (m.getType().equals("LOCAL"))
                    {
                        new LocalLogs(textField1.getText()).setVisible(true);
                    }
                    else
                    {
                        new OPDLogs(textField1.getText()).setVisible(true);
                    }
                    ArrayList<Appointment> a= new PatientService().getAppointmentByPatientId(textField1.getText());
                    Object columnNames[] = { "Appointment ID","Patient ID","Doctor ID","Date","Status","Slot"};
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
                        String d1,d2,d3,d4,d5,d6;
                        d1 = p.getId();
                        d2 = p.getPatientId();
                        d3 = p.getDoctorId();
                        d4 = p.getDate();
                        d5 = p.getStatus();
                        d6 = p.getSlot();
                        model.addRow(new Object[]{d1,d2,d3,d4,d5,d6});
                    }

                }
            });
            this.setVisible(false);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
