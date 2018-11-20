/*
 * Created by JFormDesigner on Sat Nov 17 01:32:32 IST 2018
 */

package UI.HODRequests;

import Service.HodService;
import UI.DoctorDetails.DoctorDetails;
import UI.DoctorHome.DoctorHome;
import UI.DoctorSchedule.DoctorSchedule;
import UI.HODHome.HODHome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class HODRequests extends JFrame implements ActionListener {
    String Did;
    public HODRequests(String  Did) {
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
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("HOD REQUESTS");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(165, 10, 130, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("REASSIGNMENT ID");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(40, 65, 165, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(240, 60, 165, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("AUTHORIZE");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(80, 135), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("DENY");
        contentPane.add(button2);
        button2.setBounds(270, 135, 110, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("BACK");
        contentPane.add(button3);
        button3.setBounds(185, 190, 110, button3.getPreferredSize().height);

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
        if(s.equals("AUTHORIZE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HodService().updateDoctorRequestApproval(textField1.getText());
                    new HODHome(Did).setVisible(true);
                }
            });
            this.setVisible(false);

        }
        else if(s.equals("DENY"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HodService().updateDoctorRequestDenial(textField1.getText());
                    new HODHome(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HODHome(Did).setVisible(true);
                }
            });
            this.setVisible(false);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
