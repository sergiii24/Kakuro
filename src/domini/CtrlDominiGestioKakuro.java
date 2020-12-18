package domini;

import dades.CtrlDadesKakuro;
import dades.CtrlFactoryDades;

import java.util.List;

public class CtrlDominiGestioKakuro {

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


}
