import UI.DoctorFunctions.DoctorFunctions;
import UI.Homepage.Homepage;
import UI.SearchDoctor.SearchDoctor;

public class SHS {
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }
}
