package domini;

import dades.CtrlDadesKakuro;
import dades.CtrlFactoryDades;

import java.util.List;

public class CtrlDominiGestioKakuro {

    Partida partida;


    public CtrlDominiGestioKakuro() {
    }

    public List<String> getNameStartedGames() {
        CtrlDadesKakuro ctrlDadesKakuro = CtrlFactoryDades.getcKakuro();
        return ctrlDadesKakuro.getNameKakurosStarted(CtrlFactoryDomini.getcDUsuariInstance().getId());
    }

    public List<String> getNamePublicGames() {
        CtrlDadesKakuro ctrlDadesKakuro = CtrlFactoryDades.getcKakuro();
        return ctrlDadesKakuro.getNamePublicKakuros();
    }

    public List<String> getNameUserGames() {
        CtrlDadesKakuro ctrlDadesKakuro = CtrlFactoryDades.getcKakuro();
        return ctrlDadesKakuro.getNameKakurosUser(CtrlFactoryDomini.getcDUsuariInstance().getId());
    }


    public void createGameKakuro(int rows, int col, String dif, String mode) {


    }

    public void createNewGame(Tauler tauler, Mode mode) {

        Usuari usuari = CtrlFactoryDomini.getcDUsuariInstance().getUsuari();
        partida = new Partida(usuari, mode, tauler);

    }


    public void generateKakuro(int parseInt, int parseInt1, String dif) {

    }

}
