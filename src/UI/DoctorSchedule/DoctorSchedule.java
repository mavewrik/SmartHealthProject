
package UI.DoctorSchedule;

import Service.DoctorService;
import Service.PatientService;
import UI.DoctorHome.DoctorHome;
import UI.DoctorProfile.DoctorProfile;
import UI.HODHome.HODHome;
import UI.HODProfile.HODProfile;
import UI.PatientHome.PatientHome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DoctorSchedule extends JFrame implements ActionListener {
    String Did;
    public DoctorSchedule(String Did) {
        this.Did = Did;
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
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("DOCTOR SCHEDULE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(170, 5, 160, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(130, 220), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("SUBMIT");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(300, 220), button2.getPreferredSize()));

        //---- label2 ----
        label2.setText("DAY OF AVAILABILITY");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(85, 55, 180, 20);

        //---- label3 ----
        label3.setText("IN TIME");
        contentPane.add(label3);
        label3.setBounds(145, 90, label3.getPreferredSize().width, 20);

        //---- label4 ----
        label4.setText("OUT TIME");
        contentPane.add(label4);
        label4.setBounds(140, 130, 75, label4.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(285, 50, 140, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(285, 90, 140, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(285, 125, 140, textField3.getPreferredSize().height);

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
                    String Day = textField1.getText();
                    String intime = textField2.getText();
                    String outtime = textField3.getText();
                    new DoctorService().addSchedule(Did,Day,intime,outtime);
                    if (new DoctorService().isHod(Did) == true) {
                        new HODProfile(Did).setVisible(true);
                    } else
                        new DoctorProfile(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
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
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
