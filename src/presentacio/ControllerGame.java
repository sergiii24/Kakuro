package presentacio;

import domini.CtrlFactoryDomini;
import presentacio.views.GameView;

public class ControllerGame {

    GameView gameView;
    ControllerPresentacio controllerPresentacio;

    public ControllerGame(GameView gameView) {
        this.gameView = gameView;
    }

    public void iniController() {
    }

    public void setUpGame(String nom, String mode, boolean publicKakuro) {

        if (publicKakuro) gameView.setGamePanel(CtrlFactoryDomini.getcDTaulellInstance().getPublicTaulell(nom));
        else gameView.setGamePanel(CtrlFactoryDomini.getcDTaulellInstance().getUserTaulell(nom));

       /* switch (mode) {
            case "Training":

                break;
            case "Normal":

                break;
            case "SpeedRun":

                break;
        }*/


    }

}
