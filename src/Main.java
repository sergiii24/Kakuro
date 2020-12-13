import domini.ControllerDomini;
import domini.CtrlFactory;
import presentacio.Controller;
import presentacio.Sudoku;
import java.awt.*;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sudoku frame = new Sudoku();
                    ControllerDomini domini = CtrlFactory.getcDDominiInstance();
                    Controller con = new Controller(frame, domini);
                    con.initController();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
