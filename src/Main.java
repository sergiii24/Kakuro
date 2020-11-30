import domini.ControllerDomini;
import presentacio.Controller;
import presentacio.Sudoku;
import java.awt.*;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        Sudoku frame = new Sudoku();
        ControllerDomini domini = new ControllerDomini();
        Controller con = new Controller(frame, domini);
        con.initController();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
