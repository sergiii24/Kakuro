package presentacio;

import domini.ControllerDomini;
import domini.CtrlDominiGestioUsuari;
import domini.CtrlFactoryDomini;

public class ControllerPresentacio {

    KakuroView view;
    ControllerDomini controllerDomini;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;
    ControllerLogin controllerLogin;
    ControllerSignUp controllerSignUp;
    ControllerProfile controllerProfile;
    ControllerRanking controllerRanking;
    ControllerMenu controllerMenu;
    ControllerGame controllerGame;

    public ControllerPresentacio(KakuroView view,
                                 ControllerDomini controllerDomini,
                                 ControllerLogin controllerLogin,
                                 ControllerSignUp controllerSignUp,
                                 ControllerProfile controllerProfile,
                                 ControllerRanking controllerRanking,
                                 ControllerMenu controllerMenu,
                                 ControllerGame controllerGame) {
        this.view = view;
        this.controllerDomini = controllerDomini;
        this.controllerLogin = controllerLogin;
        this.controllerSignUp = controllerSignUp;
        this.controllerProfile = controllerProfile;
        this.controllerRanking = controllerRanking;
        this.controllerMenu = controllerMenu;
        this.controllerGame = controllerGame;
    }

    public void initController() {

        controllerDomini.iniControlador();
        controllerLogin.initController(this);
        controllerSignUp.initController(this);
        controllerProfile.initController(this);
        controllerRanking.iniController();
        controllerMenu.iniController(this);
        controllerGame.iniController();
        ctrlDominiGestioUsuari = CtrlFactoryDomini.getcDUsuariInstance();




       /* try {

            Tauler b = new Reader().llegirFitxer("src/data/7x7");
            b.updatePossibilities();
            //State start = new State(b.getCasellas());
            MonteState state = new MonteState(b.getCasellas());

           // Forward f = new Forward();

            //TODO INICIALITZAR LES POSSIBLITATS!!"!!

            //long time = System.currentTimeMillis();
            //f.ForwardChecking(start);
            //System.out.println("Forward: "+(System.currentTimeMillis()-time));

            //b.getSolucio();

            //ProblemTree pt = new ProblemTree();
            //pt.dfs(start, true);


            final int level = 2;
            final long maxRunningTimeMs = 2 * 60 * 1000;
            final long endTimeMs = System.currentTimeMillis() + maxRunningTimeMs;
            long time = System.currentTimeMillis();
            final Pair<Double, List<Pair<Position, Integer>>> result = new NestedMonteCarloSearch().executeSearch(state, level, () -> {
                return System.currentTimeMillis() > endTimeMs;
            });
            //System.out.println("Forward: "+(System.currentTimeMillis()-time));

            System.out.println(result.item1);
            for ( Pair<Position, Integer> p : result.item2) {
                ((Blanc)b.getCasellas()[p.item1.i][p.item1.j]).setNum(p.item2);
            }

            //b.getSolucio();

            JPanel panel = controllerDomini.getBoardUI(b);
            view.ficavista(panel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


    }

    private void jugar() {

        System.out.println("Play");

    }



    private void logoff() {
        //TODO borrar sessio
        view.changeScreen("login");
    }

    public void goView(String vista) {
        view.changeScreen(vista);
    }

    public void goToPerfil() {

        controllerProfile.updateDataPerfil();
        goView("perfil");

    }

    public void login() {
        controllerMenu.vistaRegistrat();
        goView("menu");
    }


    public void loginGuest() {
        controllerMenu.vistaGuest();
        goView("menu");
    }

    public void error(String error) {
        view.error(error);
    }


    public void play(String nom, String mode, boolean publicKakuro) {

        controllerGame.setUpGame(nom, mode, publicKakuro);
        view.changeScreen("game");

    }


}
