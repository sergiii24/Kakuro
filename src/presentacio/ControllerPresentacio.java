package presentacio;

import domini.ControllerDomini;
import domini.CtrlDominiGestioUsuari;
import domini.CtrlFactoryDomini;

public class ControllerPresentacio {

    KakuroView view;
    ControllerDomini controllerDomini;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;
    ControllerLogin controllerLogin;
    ControllerSignUp controllerSignUp;
    ControllerProfile controllerProfile;
    ControllerRanking controllerRanking;
    ControllerMenu controllerMenu;
    ControllerGame controllerGame;

    public ControllerPresentacio(KakuroView view,
                                 ControllerDomini controllerDomini,
                                 ControllerLogin controllerLogin,
                                 ControllerSignUp controllerSignUp,
                                 ControllerProfile controllerProfile,
                                 ControllerRanking controllerRanking,
                                 ControllerMenu controllerMenu,
                                 ControllerGame controllerGame) {
        this.view = view;
        this.controllerDomini = controllerDomini;
        this.controllerLogin = controllerLogin;
        this.controllerSignUp = controllerSignUp;
        this.controllerProfile = controllerProfile;
        this.controllerRanking = controllerRanking;
        this.controllerMenu = controllerMenu;
        this.controllerGame = controllerGame;
    }

    public void initController() {

        controllerDomini.iniControlador();
        controllerLogin.initController(this);
        controllerSignUp.initController(this);
        controllerProfile.initController(this);
        controllerRanking.iniController();
        controllerMenu.iniController(this);
        controllerGame.iniController();
        ctrlDominiGestioUsuari = CtrlFactoryDomini.getcDUsuariInstance();

    }

    private void jugar() {

        System.out.println("Play");

    }



    private void logoff() {
        //TODO borrar sessio
        view.changeScreen("login");
    }

    public void goView(String vista) {
        view.changeScreen(vista);
    }

    public void goToPerfil() {

        controllerProfile.updateDataPerfil();
        goView("perfil");

    }

    public void login() {
        controllerMenu.vistaRegistrat();
        goView("menu");
    }


    public void loginGuest() {
        controllerMenu.vistaGuest();
        goView("menu");
    }

    public void error(String error) {
        view.error(error);
    }


    public void play(String nom, String mode, boolean publicKakuro) {

        controllerGame.setUpGame(nom, mode, publicKakuro);
        view.changeScreen("game");

    }


}
