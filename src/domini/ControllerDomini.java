package domini;

import dades.CtrlFactoryDades;

public class ControllerDomini {

    private Usuari user;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;

    public void iniControlador() {
        user = new Usuari();
        ctrlDominiGestioUsuari = CtrlFactoryDomini.getcDUsuariInstance();
        CtrlFactoryDades.getcPersistencia().iniData();
    }











}
