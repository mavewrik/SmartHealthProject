/*
 * Created by JFormDesigner on Thu Nov 01 20:21:34 IST 2018
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
        button1 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Enter/Modify Logs");
        contentPane.add(button1);
        button1.setBounds(310, 210, 165, button1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(70, 210, 160, textField1.getPreferredSize().height);

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
    private JButton button1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
