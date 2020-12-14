package presentacio;

import domini.CtrlFactory;
import presentacio.views.SignUpView;

public class ControllerSignUp {

    SignUpView signupview;
    ControllerPresentacio controllerPresentacio;

    public ControllerSignUp(SignUpView view, ControllerPresentacio controllerPresentacio) {
        signupview = view;
        this.controllerPresentacio = controllerPresentacio;
    }

    public void initController() {
        signupview.getBackLogin().addActionListener(e -> controllerPresentacio.goView("login"));
        signupview.getSignUp().addActionListener(e -> registrar());
    }

    private void registrar() {

        String user = signupview.getTxtRegUser().getText();
        String password = signupview.getTxtRegPassword().getText();
        String password2 = signupview.getTxtRegPassword2().getText();

        if(user.isEmpty() || password.isEmpty() || password2.isEmpty()) controllerPresentacio.error("Falten Camps!");
        else if(password.compareTo(password2)!=0) controllerPresentacio.error("Passwords no iguals");
        else {
            if(CtrlFactory.getcDUsuariInstance().register(user,password)) {
                signupview.getTxtRegUser().setText("");
                signupview.getTxtRegPassword().setText("");
                signupview.getTxtRegPassword2().setText("");
                controllerPresentacio.goView("menu");
            }
            else controllerPresentacio.error("Algo ha fallat!");
        }

    }


}
