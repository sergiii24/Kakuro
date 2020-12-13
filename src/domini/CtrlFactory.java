package domini;

public class CtrlFactory {

    private static CtrlDominiGestioUsuari cDUsuari = null;
    private static ControllerDomini cDomini = null;


    private  static void createcDUsuari() {
        if (cDUsuari == null) {
            cDUsuari = new CtrlDominiGestioUsuari();
        }
    }

    public static CtrlDominiGestioUsuari getcDUsuariInstance() {
        if (cDUsuari == null) createcDUsuari();
        return cDUsuari;
    }

    private  static void createcDDomini() {
        if (cDomini == null) {
            cDomini = new ControllerDomini();
        }
    }

    public static ControllerDomini getcDDominiInstance() {
        if (cDomini == null) createcDDomini();
        return cDomini;
    }



}
