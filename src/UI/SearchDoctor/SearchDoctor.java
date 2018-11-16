/*
 * Created by JFormDesigner on Fri Nov 02 13:01:22 IST 2018
 */

package UI.SearchDoctor;

import UI.BookAppointment.BookAppointment;
import UI.DoctorSelection.DoctorSelection;
import UI.Homepage.Homepage;
import UI.PatientDetails.PatientDetails;
import UI.PatientHome.PatientHome;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.*;


public class SearchDoctor extends JFrame implements ActionListener {
    String Pid;
    public SearchDoctor(String Pid) {
        this.Pid = Pid;
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alvin Dey
        comboBox1 = new JComboBox();
        label1 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(comboBox1);
        comboBox1.setBounds(235, 85, 195, comboBox1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Search Criteria");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(50, 90, 160, label1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("DOCTOR SEARCH");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(170, 5, 150, label3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("SEARCH");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(280, 195), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(105, 195, 83, button2.getPreferredSize().height);

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
        if(s.equals("SEARCH"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    String criteria = comboBox1.getSelectedItem().toString();
                    new BookAppointment(Pid).setVisible(true);

                }
            });
            this.setVisible(false);
        }
        else if(s.equals("BACK"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PatientHome(Pid).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JComboBox comboBox1;
    private JLabel label1;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
