/*
 * Created by JFormDesigner on Fri Nov 02 13:16:42 IST 2018
 */

package UI.DoctorSelection;

import java.awt.*;
import javax.swing.*;

public class DoctorSelection extends JFrame {
    String Pid ;
    public DoctorSelection(String Pid) {
        this.Pid = Pid;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("SHS DOCTOR SELECTION");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(135, 10, 195, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Department");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(70, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Date of Appointment");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(40, 105), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("Preferrable Slot");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(60, 145), label4.getPreferredSize()));

        //---- button1 ----
        button1.setText("SUBMIT");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(275, 215), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(225, 100, 200, textField1.getPreferredSize().height);
        contentPane.add(comboBox1);
        comboBox1.setBounds(225, 140, 195, comboBox1.getPreferredSize().height);
        contentPane.add(comboBox2);
        comboBox2.setBounds(225, 60, 195, comboBox2.getPreferredSize().height);

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(80, 215), button2.getPreferredSize()));

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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
