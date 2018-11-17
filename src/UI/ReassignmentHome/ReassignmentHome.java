/*
 * Created by JFormDesigner on Fri Nov 02 13:36:55 IST 2018
 */

package UI.ReassignmentHome;

import DTO.Doctor;
import Service.AdminService;
import UI.AdminHome.AdminHome;
import UI.Homepage.Homepage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReassignmentHome extends JFrame implements ActionListener {

    public ReassignmentHome() {

        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("REASSIGNMENT HOME");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(130, 10, 215, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("REASSIGNMENT ID");
        contentPane.add(label2);
        label2.setBounds(65, 115, 135, 25);
        contentPane.add(textField1);
        textField1.setBounds(250, 115, 150, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(85, 245), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("AUTHORIZE");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(270, 245), button2.getPreferredSize()));

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
        if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminHome().setVisible(true);
                }
            });
            this.setVisible(false);
        }
        else if(s.equals("AUTHORIZE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminService().updateReassignmentStatus(textField1.getText());
                }
            });
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
