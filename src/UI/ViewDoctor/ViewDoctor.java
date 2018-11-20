/*
 * Created by JFormDesigner on Fri Nov 02 13:30:18 IST 2018
 */

package UI.ViewDoctor;

import UI.AdminHome.AdminHome;
import UI.AdminViewDoc.AdminViewDoc;
import UI.DoctorFunctions.DoctorFunctions;
import UI.ViewLogs.ViewLogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class ViewDoctor extends JFrame implements ActionListener {
    public ViewDoctor() {
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        label1 = new JLabel();
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
        contentPane.add(textField1);
        textField1.setBounds(245, 90, 160, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("DOCTOR ID");
        contentPane.add(label2);
        label2.setBounds(80, 95, 115, label2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("VIEW PROFILE");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(250, 170), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(70, 170, 125, button2.getPreferredSize().height);

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
        if(s.equals("VIEW PROFILE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new AdminViewDoc(textField1.getText()).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
