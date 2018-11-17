/*
 * Created by JFormDesigner on Sat Nov 17 03:51:02 IST 2018
 */

package UI.ViewAppointment;

import UI.DoctorFunctions.DoctorFunctions;
import UI.ViewLogs.ViewLogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class ViewAppointment extends JFrame implements ActionListener {
    String Pid;
    String Did;
    public ViewAppointment(String Pid,String Did) {
        this.Pid = Pid;
        this.Did = Did;
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
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("APPOINTMENT LOGS");
        contentPane.add(label1);
        label1.setBounds(170, 10, 165, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("APPOINTMENT ID");
        contentPane.add(label2);
        label2.setBounds(60, 80, 165, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(290, 75, 135, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        contentPane.add(button1);
        button1.setBounds(135, 155, button1.getPreferredSize().width, 30);

        //---- button2 ----
        button2.setText("VIEW LOGS");
        contentPane.add(button2);
        button2.setBounds(260, 155, button2.getPreferredSize().width, 30);

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
                    new DoctorFunctions(Did).setVisible(true);
                }
            });
            this.setVisible(false);
        }
        if(s.equals("VIEW LOGS"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewLogs(Pid,Did,textField1.getText()).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alvin Dey
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
