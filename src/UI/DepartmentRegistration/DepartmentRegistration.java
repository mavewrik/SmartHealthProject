/*
 * Created by JFormDesigner on Fri Nov 02 13:44:26 IST 2018
 */

package UI.DepartmentRegistration;

import Service.AdminService;
import UI.AdminHome.AdminHome;
import UI.DoctorDetails.DoctorDetails;
import UI.DoctorHome.DoctorHome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DepartmentRegistration extends JFrame implements ActionListener {
    public DepartmentRegistration() {
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("DEPARTMENT REGISTRATION");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(135, 10, 215, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Department Name");
        contentPane.add(label2);
        label2.setBounds(75, 65, 140, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Designated HOD");
        contentPane.add(label3);
        label3.setBounds(75, 115, 130, label3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(250, 65, 170, 25);
        contentPane.add(textField2);
        textField2.setBounds(250, 110, 170, 25);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 200), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("SUBMIT");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(270, 200), button2.getPreferredSize()));

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
                    new AdminService().addDepartment("sdd",textField1.getText(),textField2.getText());
                }
            });
            this.setVisible(false);
            new AdminHome().setVisible(true);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminHome().setVisible(true);
                }
            });
            this.setVisible(false);
            new AdminHome().setVisible(true);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
