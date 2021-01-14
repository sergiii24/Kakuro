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

    public void createNewGame(TipusMode mode) {

        Usuari usuari = CtrlFactoryDomini.getcDUsuariInstance().getUsuari();
        Tauler tauler = CtrlFactoryDomini.getcDTaulellInstance().getT();
        partida = new Partida(usuari, mode, tauler);

    }

    public void setTime(int time) {
        partida.setTemps(time);
    }

    public void acabarPartida(int minutes, int seconds, int millic) {
        partida.setTemps(minutes*60*100 + seconds*100 + millic);
        partida = new PartidaAcabada(partida, Math.max(1000 - 5 * minutes, 0));
    }

    public void createGameKakuro(int parseInt, int parseInt1, TipusDificultat t, TipusMode m) {
        CtrlFactoryDomini.getcDTaulellInstance().generateKakuro(parseInt,parseInt1,t,"random");
    }

    public void cancelarPartida() {
        CtrlFactoryDomini.getcDTaulellInstance().destroy();
        partida = null;
    }

    public void guardar(int minutes, int seconds, int millic) {
        partida.setTemps(minutes*60*100 + seconds*100 + millic);
        partida.setTauler(CtrlFactoryDomini.getcDTaulellInstance().getBoardSwing());
        CtrlFactoryDades.getcKakuro().guardar(partida);
    }

    public void carregar(String result) {

        partida = CtrlFactoryDades.getcKakuro().llegirPartidaComençada(CtrlFactoryDomini.getcDUsuariInstance().getId(), result);
        CtrlFactoryDomini.getcDTaulellInstance().setT(partida.tauler);
    }
}
