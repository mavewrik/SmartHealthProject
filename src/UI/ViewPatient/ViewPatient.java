/*
 * Created by JFormDesigner on Thu Nov 01 20:28:55 IST 2018
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
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        label9 = new JLabel();
        comboBox1 = new JComboBox();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Name");
        contentPane.add(label1);
        label1.setBounds(50, 65, 85, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(135, 60, 325, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Age");
        contentPane.add(label2);
        label2.setBounds(55, 110, label2.getPreferredSize().width, 30);

        //---- label3 ----
        label3.setText("Type");
        contentPane.add(label3);
        label3.setBounds(290, 110, 50, 25);

        //---- label4 ----
        label4.setText("Address");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(50, 165), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("Phone");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(50, 235), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Email Id");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(50, 290), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("Ailment");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(50, 345), label7.getPreferredSize()));
        contentPane.add(label8);
        label8.setBounds(55, 400, 30, label8.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(135, 105, textField2.getPreferredSize().width, 30);
        contentPane.add(textField3);
        textField3.setBounds(135, 160, 325, 55);
        contentPane.add(textField4);
        textField4.setBounds(135, 230, 325, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(135, 280, 325, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(135, 335, 330, textField6.getPreferredSize().height);

        //---- label9 ----
        label9.setText("PATIENT DETAILS");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label9);
        label9.setBounds(145, 10, 255, label9.getPreferredSize().height);
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(360, 105), comboBox1.getPreferredSize()));

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
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label9;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
