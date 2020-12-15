package presentacio;

import domini.CtrlFactoryDomini;
import presentacio.views.LoginView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerLogin {

    LoginView loginView;
    ControllerPresentacio controllerPresentacio;

    public ControllerLogin(LoginView view) {
        loginView = view;
    }
    public void initController(ControllerPresentacio controllerPresentacio) {

        this.controllerPresentacio = controllerPresentacio;
        loginView.getEntrar().addActionListener(e -> login());
        loginView.getLblRegistrar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerPresentacio.goView("reg");
            }
        });
        loginView.getLblGuest().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginGuest();
            }
        });
        loginView.getTxtPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) login();
            }
        });
        loginView.getTxtUser().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) login();
            }
        });


    }

    private void loginGuest() {
        controllerPresentacio.loginGuest();
    }

    private void login(){

        String user = loginView.getTxtUser().getText();
        String password = loginView.getTxtPassword().getText();
        if(user.isEmpty() || password.isEmpty()) controllerPresentacio.error("Falten Camps!");
        else {
            if(CtrlFactoryDomini.getcDUsuariInstance().login(user,password)) {
                loginView.getTxtUser().setText("");
                loginView.getTxtPassword().setText("");
                controllerPresentacio.goView("menu");
            }
            else controllerPresentacio.error("Algo ha fallat!");
        }

    }


}
