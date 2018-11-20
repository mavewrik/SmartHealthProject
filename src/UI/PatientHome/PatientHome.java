

package UI.PatientHome;

import DTO.Appointment;
import DTO.Doctor;
import Exceptions.AppointmentNotFoundException;
import Service.PatientService;
import UI.AdminLogin.AdminLogin;
import UI.AppointmentHistory.AppointmentHistory;
import UI.DoctorLogin.DoctorLogin;
import UI.DoctorSelection.DoctorSelection;
import UI.Homepage.Homepage;
import UI.PatientDetails.PatientDetails;
import UI.PatientLogin.PatientLogin;
import UI.PatientRegistration.PatientRegistration;
import UI.SearchDoctor.SearchDoctor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alvin Dey
 */
public class PatientHome extends JFrame implements ActionListener {
    String Pid;
    public PatientHome(String Pid) {
        this.Pid = Pid;
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("PATIENT HOMEPAGE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(160, 10, 155, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("EDIT PROFILE");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 55), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("SEARCH DOCTOR");
        contentPane.add(button2);
        button2.setBounds(285, 55, 135, 30);

        //---- button3 ----
        button3.setText("SHS DOCTOR SELECTION");
        contentPane.add(button3);
        button3.setBounds(25, 110, 195, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("LOGOUT");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(195, 175), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("APPOINTMENT DETAILS");
        contentPane.add(button5);
        button5.setBounds(270, 110, 180, button5.getPreferredSize().height);

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
        if(s.equals("EDIT PROFILE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientDetails(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("SEARCH DOCTOR"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SearchDoctor(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("SHS DOCTOR SELECTION"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorSelection(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("APPOINTMENT DETAILS"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {

                        ArrayList<Appointment> a = new PatientService().getAppointmentByPatientId(Pid);
                        Object columnNames[] = {"Appointment ID", "Patient ID", "Doctor ID", "Date", "Status", "Slot"};
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
                            String d1, d2, d3, d4, d5, d6;
                            d1 = p.getId();
                            d2 = p.getPatientId();
                            d3 = p.getDoctorId();
                            d4 = p.getDate();
                            d5 = p.getStatus();
                            d6 = p.getSlot();
                            model.addRow(new Object[]{d1, d2, d3, d4, d5, d6});
                        }
                        new AppointmentHistory(Pid).setVisible(true);
                    }
                    catch (AppointmentNotFoundException e)
                    {
                            JOptionPane.showMessageDialog(null, e.toString(), "InfoBox: " + "Appointment Not Found", JOptionPane.INFORMATION_MESSAGE);
                            new PatientHome(Pid).setVisible(true);
                    }
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
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
