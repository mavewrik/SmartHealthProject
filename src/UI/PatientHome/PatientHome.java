/*
 * Created by JFormDesigner on Fri Nov 02 00:07:09 IST 2018
 */

package UI.PatientHome;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class PatientHome extends JFrame {
    public PatientHome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

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
        button3.setBounds(new Rectangle(new Point(135, 105), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("LOGOUT");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(190, 155), button4.getPreferredSize()));

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
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
