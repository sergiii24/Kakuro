import domini.ControllerDomini;
import domini.CtrlFactory;
import presentacio.ControllerLogin;
import presentacio.ControllerPresentacio;
import presentacio.ControllerSignUp;
import presentacio.views.LoginView;
import presentacio.Sudoku;
import presentacio.views.SignUpView;

import java.awt.*;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    //Views
                    LoginView loginView = new LoginView();
                    SignUpView signUpView = new SignUpView();

                    Sudoku frame = new Sudoku(loginView, signUpView);

                    //Controllers

                    ControllerDomini domini = CtrlFactory.getcDDominiInstance();
                    ControllerPresentacio con = new ControllerPresentacio(frame, domini);
                    ControllerLogin controllerLogin = new ControllerLogin(loginView, con);
                    ControllerSignUp controllerSignUp = new ControllerSignUp(signUpView, con);
                    con.initController();
                    controllerLogin.initController();
                    controllerSignUp.initController();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
