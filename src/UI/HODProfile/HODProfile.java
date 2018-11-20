/*
 * Created by JFormDesigner on Sat Nov 17 01:13:51 IST 2018
 */

package UI.HODProfile;

import UI.DoctorDetails.DoctorDetails;
import UI.DoctorHome.DoctorHome;
import UI.DoctorSchedule.DoctorSchedule;
import UI.DoctorUpdate.DoctorUpdate;
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
public class HODProfile extends JFrame implements ActionListener {
    String Did;
    public HODProfile(String Did) {
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

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("HOD PROFILE");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(190, 5, 160, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("ADD SCHEDULE");
        contentPane.add(button1);
        button1.setBounds(75, 80, 160, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("MODIFY BASIC INFO");
        contentPane.add(button2);
        button2.setBounds(310, 80, 190, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("BACK");
        contentPane.add(button3);
        button3.setBounds(215, 165, 108, button3.getPreferredSize().height);

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
        if(s.equals("ADD SCHEDULE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorSchedule(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("MODIFY BASIC INFO"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DoctorDetails(Did).setVisible(true);
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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
