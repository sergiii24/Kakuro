package main;

import domini.ControllerDomini;
import domini.CtrlFactoryDomini;
import presentacio.*;
import presentacio.views.*;

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
                    ProfileView profileView = new ProfileView();
                    MenuView menuView = new MenuView();
                    GameView gameView = new GameView();
                    RankingView rankingView = new RankingView();
                    KakuroView frame = new KakuroView(loginView, signUpView, profileView, menuView, gameView, rankingView);

                    //Controllers
                    ControllerDomini domini = CtrlFactoryDomini.getcDDominiInstance();
                    ControllerLogin controllerLogin = new ControllerLogin(loginView);
                    ControllerSignUp controllerSignUp = new ControllerSignUp(signUpView);
                    ControllerProfile controllerProfile = new ControllerProfile(profileView);
                    ControllerRanking controllerRanking = new ControllerRanking(rankingView);
                    ControllerMenu controllerMenu = new ControllerMenu(menuView);
                    ControllerGame controllerGame = new ControllerGame(gameView);

                    ControllerPresentacio con = new ControllerPresentacio(frame, domini, controllerLogin, controllerSignUp, controllerProfile, controllerRanking, controllerMenu, controllerGame);
                    con.initController();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
