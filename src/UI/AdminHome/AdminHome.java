/*
 * Created by JFormDesigner on Thu Nov 01 20:03:34 IST 2018
 */

package UI.AdminHome;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class AdminHome extends JFrame {
    public AdminHome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        button1 = new JButton();
        label1 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Add Doctor");
        contentPane.add(button1);
        button1.setBounds(80, 65, 155, button1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("ADMIN HOMEPAGE");
        contentPane.add(label1);
        label1.setBounds(205, 10, 150, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Reassignment Requests");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(285, 65), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("View Patients");
        contentPane.add(button3);
        button3.setBounds(80, 135, 155, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("View Doctors");
        contentPane.add(button4);
        button4.setBounds(285, 135, 195, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("LOGOUT");
        contentPane.add(button5);
        button5.setBounds(210, 265, 110, button5.getPreferredSize().height);

        //---- button6 ----
        button6.setText("Add Department");
        contentPane.add(button6);
        button6.setBounds(190, 195, 150, 35);

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
