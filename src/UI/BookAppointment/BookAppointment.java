/*
 * Created by JFormDesigner on Fri Nov 02 13:07:13 IST 2018
 */

package UI.BookAppointment;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class BookAppointment extends JFrame {
    public BookAppointment() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        label3 = new JLabel();
        comboBox2 = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("APPOINTMENT HOME");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(125, 5, 215, label1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 30, 450, 115);
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(280, 170), comboBox1.getPreferredSize()));

        //---- label2 ----
        label2.setText("DOCTOR NAME");
        contentPane.add(label2);
        label2.setBounds(105, 175, 135, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("APPOINTMENT SLOT");
        contentPane.add(label3);
        label3.setBounds(95, 210, 165, label3.getPreferredSize().height);
        contentPane.add(comboBox2);
        comboBox2.setBounds(new Rectangle(new Point(280, 205), comboBox2.getPreferredSize()));

        //---- button1 ----
        button1.setText("SUBMIT");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(280, 260), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(115, 260), button2.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JLabel label3;
    private JComboBox comboBox2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
