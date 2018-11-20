import LoggerConfig.LoggerConfig;
import UI.DoctorFunctions.DoctorFunctions;
import UI.Homepage.Homepage;
import UI.SearchDoctor.SearchDoctor;

import javax.swing.*;
import java.io.IOException;

public class SHS {
    public static void main(String args[])
    {
        try {
            LoggerConfig lg = new LoggerConfig();
            lg.setup();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    // JOptionPane.showMessageDialog(null, "dfdhd", "InfoBox: " + "dgdgdg", JOptionPane.INFORMATION_MESSAGE);
                    new Homepage().setVisible(true);
                }
            });
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
