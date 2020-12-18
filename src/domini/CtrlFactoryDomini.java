package domini;

public class CtrlFactoryDomini {

    private static ControllerDomini cDomini = null;
    private static CtrlDominiGestioUsuari cDUsuari = null;
    private static CtrlDominiGestioKakuro cDKakuro = null;
    private static CtrlDominiGestioRanking cDRanking = null;
    private static CtrlDominiGestioTaulell cDTaulell = null;

    private static void createcDDomini() {
        if (cDomini == null) {
            cDomini = new ControllerDomini();
        }
    }

    public static ControllerDomini getcDDominiInstance() {
        if (cDomini == null) createcDDomini();
        return cDomini;
    }

    private static void createcDUsuari() {
        if (cDUsuari == null) {
            cDUsuari = new CtrlDominiGestioUsuari();
        }
    }

    public static CtrlDominiGestioUsuari getcDUsuariInstance() {
        if (cDUsuari == null) createcDUsuari();
        return cDUsuari;
    }

    private static void createcDTaulell() {
        if (cDTaulell == null) {
            cDTaulell = new CtrlDominiGestioTaulell();
        }
    }

    public static CtrlDominiGestioTaulell getcDTaulellInstance() {
        if (cDTaulell == null) createcDTaulell();
        return cDTaulell;
    }

    private static void createcDKakuro() {
        if (cDKakuro == null) {
            cDKakuro = new CtrlDominiGestioKakuro();
        }
    }

    public static CtrlDominiGestioKakuro getcDKakuroInstance() {
        if (cDKakuro == null) createcDKakuro();
        return cDKakuro;
    }

    private static void createcDRanking() {
        if (cDRanking == null) {
            cDRanking = new CtrlDominiGestioRanking();
        }
    }

    public static CtrlDominiGestioRanking getcDRankingInstance() {
        if (cDRanking == null) createcDRanking();
        return cDRanking;
    }

}
