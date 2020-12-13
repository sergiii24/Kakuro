package dades;

import domini.ControllerDomini;
import domini.CtrlDominiGestioUsuari;

public class CtrlFactoryDades {

    private static CtrlPersistencia ctrlPersistencia = null;

    private  static void createcPersistencia() {
        if (ctrlPersistencia == null) {
            ctrlPersistencia = new CtrlPersistencia();
        }
    }

    public static CtrlPersistencia getcPersistencia() {
        if (ctrlPersistencia == null) createcPersistencia();
        return ctrlPersistencia;
    }

}
