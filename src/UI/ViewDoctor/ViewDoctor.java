/*
 * Created by JFormDesigner on Fri Nov 02 13:30:18 IST 2018
 */

package UI.ViewDoctor;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alvin Dey
 */
public class ViewDoctor extends JFrame {
    public ViewDoctor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("DOCTOR LIST");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(160, 10, 152, label1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 35, scrollPane1.getPreferredSize().width, 165);
        contentPane.add(textField1);
        textField1.setBounds(250, 215, 160, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("DOCTOR ID");
        contentPane.add(label2);
        label2.setBounds(90, 220, 115, label2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("VIEW PROFILE");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(260, 265), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(75, 265, 125, button2.getPreferredSize().height);

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
    private JTextField textField1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
