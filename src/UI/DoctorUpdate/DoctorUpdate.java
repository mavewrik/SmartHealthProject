/*
 * Created by JFormDesigner on Fri Nov 16 16:49:48 IST 2018
 */

package UI.DoctorUpdate;

import Service.DoctorService;
import UI.DoctorHome.DoctorHome;
import UI.DoctorProfile.DoctorProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DoctorUpdate extends JFrame implements ActionListener {
    String Did;
    public DoctorUpdate(String Did) {
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
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("DOCTOR UPDATE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(180, 5, 145, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("DESIGNATION");
        contentPane.add(label2);
        label2.setBounds(125, 60, label2.getPreferredSize().width, 25);

        //---- label3 ----
        label3.setText("SPECIALIZATION");
        contentPane.add(label3);
        label3.setBounds(115, 105, label3.getPreferredSize().width, 25);

        //---- label4 ----
        label4.setText("SURGEON STATUS");
        contentPane.add(label4);
        label4.setBounds(110, 150, 130, 25);
        contentPane.add(textField1);
        textField1.setBounds(275, 55, 160, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(275, 100, 160, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(275, 145, 160, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 235), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("SUBMIT");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(300, 235), button2.getPreferredSize()));

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
                    String designation;
                    String specialization;
                    String Surgeon_Status;
                    if(textField1.getText().equals(""))
                    {
                        designation = "N.A";
                    }
                    else
                        designation = textField1.getText();
                    if(textField2.getText().equals(""))
                    {
                        specialization = "N.A";
                    }
                    else
                        specialization = textField2.getText();
                    if(textField3.getText().equals(""))
                    {
                        Surgeon_Status = "N.A";
                    }
                    else
                        Surgeon_Status = textField3.getText();
                    new DoctorService().updateRequestToHod(Did,designation,specialization,Surgeon_Status);
                    new DoctorProfile(Did).setVisible(true);
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
