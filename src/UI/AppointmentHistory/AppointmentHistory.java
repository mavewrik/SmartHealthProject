
package UI.AppointmentHistory;

import DTO.Appointment;
import Exceptions.AppointmentNotFoundException;
import Service.AdminService;
import Service.PatientService;
import UI.AdminHome.AdminHome;
import UI.DoctorLogin.DoctorLogin;
import UI.PatientHome.PatientHome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AppointmentHistory extends JFrame implements ActionListener {
    String Pid;
    public AppointmentHistory(String Pid) {
        this.Pid = Pid;
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("APPOINTMENT HISTORY");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 5), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Appointment ID");
        contentPane.add(label2);
        label2.setBounds(85, 80, 135, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(290, 75, 160, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("CANCEL APPOINTMENT");
        contentPane.add(button1);
        button1.setBounds(40, 175, 195, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("RATE YOUR APPOINTMENT");
        contentPane.add(button2);
        button2.setBounds(260, 175, 220, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("BACK");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(210, 245), button3.getPreferredSize()));

        //---- label3 ----
        label3.setText("Rating(1-5)");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(85, 125, 105, label3.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(290, 120, 160, textField2.getPreferredSize().height);

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
        if(s.equals("CANCEL APPOINTMENT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {

                        new PatientService().cancelAppointment(textField1.getText());
                        new PatientHome(Pid).setVisible(true);
                    }
                    catch (AppointmentNotFoundException e)
                    {
                        JOptionPane.showMessageDialog(null, e.toString(), "InfoBox: " + "Appointment Not Found", JOptionPane.INFORMATION_MESSAGE);
                        new AppointmentHistory(Pid).setVisible(true);
                    }
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("RATE YOUR APPOINTMENT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new PatientService().rateDoctor(textField1.getText(),textField2.getText());
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
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
