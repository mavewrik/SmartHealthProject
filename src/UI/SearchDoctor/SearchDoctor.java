/*
 * Created by JFormDesigner on Fri Nov 02 13:01:22 IST 2018
 */

package UI.SearchDoctor;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class SearchDoctor extends JFrame {
    public SearchDoctor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        comboBox1 = new JComboBox();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(comboBox1);
        comboBox1.setBounds(250, 60, 195, comboBox1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Department");
        contentPane.add(label1);
        label1.setBounds(55, 65, 160, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Date of Appointment");
        contentPane.add(label2);
        label2.setBounds(40, 110, 170, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("DOCTOR SEARCH");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(170, 5, 150, label3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(250, 105, 195, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("SEARCH");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(300, 200), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(115, 200, 83, button2.getPreferredSize().height);

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
    private JComboBox comboBox1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}