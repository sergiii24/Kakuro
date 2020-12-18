package dades;

public class CtrlFactoryDades {

    private static CtrlPersistencia ctrlPersistencia;
    private static CtrlDadesKakuro ctrlDadesKakuro;
    private static CtrlDadesRanking ctrlDadesRanking;
    private static CtrlDadesTaulell ctrlDadesTaulell;
    private static CtrlDadesUsuari ctrlDadesUsuari;


    private static void createcPersistencia() {
        if (ctrlPersistencia == null) {
            ctrlPersistencia = new CtrlPersistencia();
        }
    }

    public static CtrlPersistencia getcPersistencia() {
        if (ctrlPersistencia == null) createcPersistencia();
        return ctrlPersistencia;
    }

    private static void createcKakuro() {
        if (ctrlDadesKakuro == null) {
            ctrlDadesKakuro = new CtrlDadesKakuro();
        }
    }

    public static CtrlDadesKakuro getcKakuro() {
        if (ctrlDadesKakuro == null) createcKakuro();
        return ctrlDadesKakuro;
    }

    private static void createcRanking() {
        if (ctrlDadesRanking == null) {
            ctrlDadesRanking = new CtrlDadesRanking();
        }
    }

    public static CtrlDadesRanking getcRanking() {
        if (ctrlDadesRanking == null) createcRanking();
        return ctrlDadesRanking;
    }

    private static void createcUsuari() {
        if (ctrlDadesUsuari == null) {
            ctrlDadesUsuari = new CtrlDadesUsuari();
        }
    }

    public static CtrlDadesUsuari getcUsuari() {
        if (ctrlDadesUsuari == null) createcUsuari();
        return ctrlDadesUsuari;
    }

    private static void createcTaulell() {
        if (ctrlDadesTaulell == null) {
            ctrlDadesTaulell = new CtrlDadesTaulell();
        }
    }

    public static CtrlDadesTaulell getcTaulell() {
        if (ctrlDadesTaulell == null) createcTaulell();
        return ctrlDadesTaulell;
    }

}
