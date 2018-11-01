/*
 * Created by JFormDesigner on Thu Nov 01 20:28:55 IST 2018
 */

package UI.PatientLogs;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class PatientLogs extends JFrame {
    public PatientLogs() {
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
        label8 = new JLabel();
        textField2 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        label9 = new JLabel();
        comboBox1 = new JComboBox();
        label10 = new JLabel();
        textField3 = new JTextField();
        label11 = new JLabel();
        textField7 = new JTextField();
        label12 = new JLabel();
        textField8 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Date of Visit");
        contentPane.add(label1);
        label1.setBounds(15, 65, 85, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(115, 60, 115, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Date of Discharge");
        contentPane.add(label2);
        label2.setBounds(250, 60, 130, 30);

        //---- label3 ----
        label3.setText("Time of Visit");
        contentPane.add(label3);
        label3.setBounds(15, 100, 85, 25);

        //---- label4 ----
        label4.setText("Time of Discharge");
        contentPane.add(label4);
        label4.setBounds(250, 105, 125, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Department");
        contentPane.add(label5);
        label5.setBounds(15, 145, 95, 20);

        //---- label6 ----
        label6.setText("Ailment");
        contentPane.add(label6);
        label6.setBounds(270, 145, 80, label6.getPreferredSize().height);
        contentPane.add(label8);
        label8.setBounds(55, 400, 30, label8.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(395, 60, 120, 30);
        contentPane.add(textField4);
        textField4.setBounds(115, 95, 115, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(395, 100, 120, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(395, 135, 120, textField6.getPreferredSize().height);

        //---- label9 ----
        label9.setText("PATIENT LOGS");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label9);
        label9.setBounds(145, 10, 255, label9.getPreferredSize().height);
        contentPane.add(comboBox1);
        comboBox1.setBounds(115, 140, 115, comboBox1.getPreferredSize().height);

        //---- label10 ----
        label10.setText("Medicines");
        contentPane.add(label10);
        label10.setBounds(20, 185, 90, label10.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(115, 180, 115, textField3.getPreferredSize().height);

        //---- label11 ----
        label11.setText("Doctors Assigned");
        contentPane.add(label11);
        label11.setBounds(250, 185, 125, label11.getPreferredSize().height);
        contentPane.add(textField7);
        textField7.setBounds(395, 180, 120, textField7.getPreferredSize().height);

        //---- label12 ----
        label12.setText("Tests Recommended");
        contentPane.add(label12);
        label12.setBounds(15, 220, 170, label12.getPreferredSize().height);
        contentPane.add(textField8);
        textField8.setBounds(190, 220, 320, textField8.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(125, 270, 95, 30);

        //---- button2 ----
        button2.setText("SUBMIT");
        contentPane.add(button2);
        button2.setBounds(325, 270, 105, 30);

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
    private JLabel label8;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label9;
    private JComboBox comboBox1;
    private JLabel label10;
    private JTextField textField3;
    private JLabel label11;
    private JTextField textField7;
    private JLabel label12;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
