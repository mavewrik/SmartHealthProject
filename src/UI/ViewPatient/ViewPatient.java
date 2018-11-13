/*
 * Created by JFormDesigner on Thu Nov 01 20:21:34 IST 2018
 */

package UI.ViewPatient;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class ViewPatient extends JFrame {
    public ViewPatient() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Enter/Modify Logs");
        contentPane.add(button1);
        button1.setBounds(190, 175, 165, button1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(315, 65, 160, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("PATIENT LIST");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(170, 5, 205, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 250), button2.getPreferredSize()));

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2);
        label2.setBounds(120, 70, 0, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Patient ID");
        label3.setAutoscrolls(true);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(95, 70, 105, label3.getPreferredSize().height);

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
    private JTextField textField1;
    private JLabel label1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
