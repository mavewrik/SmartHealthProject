/*
 * Created by JFormDesigner on Fri Nov 02 13:07:13 IST 2018
 */

package UI.BookAppointment;

import DTO.Doctor;
import DTO.Schedule;
import Service.PatientService;
import UI.AdminLogin.AdminLogin;
import UI.DoctorLogin.DoctorLogin;
import UI.PatientHome.PatientHome;
import UI.PatientLogin.PatientLogin;
import UI.PatientRegistration.PatientRegistration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alvin Dey
 */
public class BookAppointment extends JFrame implements ActionListener {
    String Pid;
    public BookAppointment(String Pid) {
        this.Pid = Pid;
        initComponents();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
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
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("APPOINTMENT HOME");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(205, 5, 215, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("DOCTOR ID");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(35, 65, 135, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("APPOINTMENT SLOT");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(30, 175, 165, label3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("SUBMIT");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(475, 170), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("BACK");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(280, 240), button2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(260, 60, 135, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(260, 115, 135, textField2.getPreferredSize().height);

        //---- label4 ----
        label4.setText("DATE");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label4);
        label4.setBounds(70, 120, 63, label4.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(260, 170, 135, textField3.getPreferredSize().height);

        //---- button3 ----
        button3.setText("SCHEDULE");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(465, 60), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("AVAILIBILITY");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(460, 120), button4.getPreferredSize()));

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
        if(s.equals("SCHEDULE"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ArrayList<Schedule> s = new PatientService().getDoctorSchedule(textField1.getText());
                    Object columnNames[] = { "Day", "In Time", "Out Time"};
                    Object[][] data = {};
                    DefaultTableModel dm = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable(dm);
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(300, 150);
                    frame.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    for (Schedule p : s) {
                        String d1, d2, d3;
                        d1 = p.getDayOfAvailability();
                        d2 = p.getInTime();
                        d3 = p.getOutTime();
                        model.addRow(new Object[]{d1, d2, d3});
                    }
                }
            });
        }
        else if(s.equals("AVAILIBILITY"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ArrayList<String> av = new PatientService().getDoctorSlotByDate(textField1.getText(),textField2.getText());
                    for(String s: av){
                        System.out.println(s);
                    }
                    ArrayList<Schedule> s = new PatientService().getDoctorSchedule(textField1.getText());
                    Date d = new Date();
                    DateFormat format = new SimpleDateFormat("dd/M/yyyy");
                    try {
                        d = format.parse(textField2.getText());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat df = new SimpleDateFormat("EEEE");
                    String day = df.format(d);
                    int j = 0;
                    for(Schedule temp : s)
                    {
                        if(temp.getDayOfAvailability().equals(day))
                            break;
                        j++;
                    }

                    int period = Integer.parseInt(s.get(j).getOutTime().substring(0,2))- Integer.parseInt(s.get(j).getInTime().substring(0,2));
                    Object columnNames[] = new Object[period];
                    int start = Integer.parseInt(s.get(j).getInTime().substring(0,2));
                    Object available[] = new Object[period];
                    for(int i=0;i<period;i++){
                        columnNames[i] = String.valueOf(start+i)+":00-"+String.valueOf(start+i)+":59";
                        if(av.contains(String.valueOf(start+i)+":00"))
                        {
                            available[i] = "Booked";
                        }
                        else
                        {
                            available[i]="Available";
                        }
                    }
                    Object[][] data = {};
                    DefaultTableModel dm = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable(dm);
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(300, 150);
                    frame.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(available);
                }
            });

        }
        if(s.equals("SUBMIT"))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    String Did = textField1.getText();
                    String slot = textField3.getText();
                    String date = textField2.getText();
                    new PatientService().saveAppointment(Pid,Did,date,slot);
                    new PatientHome(Pid).setVisible(true);
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
