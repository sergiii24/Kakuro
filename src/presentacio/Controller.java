package presentacio;

import dades.Reader;
import domini.*;
import domini.models.MonteState;
import domini.models.Pair;
import domini.models.Position;
import domini.models.State;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.List;

public class Controller {

    Sudoku view;
    ControllerDomini controllerDomini;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;

    public Controller(Sudoku view, ControllerDomini controllerDomini) {
        this.view = view;
        this.controllerDomini = controllerDomini;
    }

    public void initController() {

        controllerDomini.iniControlador();
        ctrlDominiGestioUsuari = CtrlFactory.getcDUsuariInstance();

        view.getEntrar().addActionListener(e -> login());
        view.getLblRegistrar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goView("reg");
            }
        });
        view.getLblGuest().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginGuest();
            }
        });
        view.getBackLogin().addActionListener(e -> goView("login"));
        view.getSignUp().addActionListener(e -> registrar());
        view.getbLogOff().addActionListener(e -> logoff());
        view.getbJugar().addActionListener(e -> goView("play"));
        view.getbBackPerfil().addActionListener(e-> goView("menu"));
        view.getbPerfil().addActionListener(e-> goToPerfil());
        view.getTPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) login();
            }
        });
        view.getTUsuari().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) login();
            }
        });
        view.getB2Jugar().addActionListener(e -> goView("play2"));
        view.getbBackJugar().addActionListener(e -> goView("play"));
        view.getbPlay().addActionListener(e -> jugar());

        //        try {
           /* Tauler b = new Reader().llegirFitxer("src/data/7x7");
            b.updatePossibilities();
            State start = new State(b.getCasellas());
            MonteState state = new MonteState(b.getCasellas());
            Forward f = new Forward();

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
            System.out.println("Forward: "+(System.currentTimeMillis()-time));

            System.out.println(result.item1);
            for ( Pair<Position, Integer> p : result.item2) {
                ((Blanc)b.getCasellas()[p.item1.i][p.item1.j]).setNum(p.item2);
            }

            //b.getSolucio();

            JPanel panel = controllerDomini.getBoardUI(b);
            view.ficavista(panel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/


    }

    private void jugar() {

        System.out.println("Play");

    }

    private void login(){

        String user = view.getTUsuari().getText();
        String password = view.getTPassword().getText();
        if(user.isEmpty() || password.isEmpty()) view.error("Falten Camps!");
        else {
            if(ctrlDominiGestioUsuari.login(user,password)) {
                view.getTUsuari().setText("");
                view.getTPassword().setText("");
                view.vistaRegistrat();
                goView("menu");
            }
            else view.error("Algo ha fallat!");
        }

    }

    private void registrar() {

        String user = view.getTxtRegUser().getText();
        String password = view.getTxtRegPassword().getText();
        String password2 = view.getTxtRegPassword2().getText();

        if(user.isEmpty() || password.isEmpty() || password2.isEmpty()) view.error("Falten Camps!");
        else if(password.compareTo(password2)!=0) view.error("Passwords no iguals");
        else {
            if(ctrlDominiGestioUsuari.register(user,password)) {
                view.getTxtRegUser().setText("");
                view.getTxtRegPassword().setText("");
                view.getTxtRegPassword2().setText("");
                goView("menu");
            }
            else view.error("Algo ha fallat!");
        }

    }


    private void logoff() {
        //TODO borrar sessio
        view.changeScreen("login");
    }

    private void goView(String vista) {
        view.changeScreen(vista);
    }

    private void goToPerfil() {

        //TODO FALTA ADAPTAR PARA GUEST SENSE USUARI REGISTRAT
        view.setDataPerfil(ctrlDominiGestioUsuari.getId(), ctrlDominiGestioUsuari.getNKResolts(), ctrlDominiGestioUsuari.getPuntuacio());
        goView("perfil");

    }

    private void loginGuest() {

        view.vistaGuest();
        goView("menu");


    }


}
