package presentacio;

import dades.Reader;
import domini.ControllerDomini;
import domini.ProblemTree;
import domini.Tauler;
import domini.models.State;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class Controller {

    Sudoku view;
    ControllerDomini controllerDomini;

    public Controller(Sudoku view, ControllerDomini controllerDomini) {
        this.view = view;
        this.controllerDomini = controllerDomini;
    }

    public void initController() {

        /*controllerDomini.iniControlador();

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
                goView("menu");
            }
        });
        view.getBackLogin().addActionListener(e -> goView("login"));
        view.getSignUp().addActionListener(e -> registrar());
        view.getbLogOff().addActionListener(e -> logoff());
        view.getbJugar().addActionListener(e -> goView("Play"));*/

        try {
            Tauler b = new Reader().llegirFitxer("src/data/exemple1");
            State start = new State(b.getCasellas());
            ProblemTree pt = new ProblemTree();
            pt.dfs(start, true);
            JPanel panel = controllerDomini.getBoardUI(new Tauler(pt.getCurrent().getBoard()));
            view.ficavista(panel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }




    private void login(){

        String user = view.getTUsuari().getText();
        String password = view.getTPassword().getText();
        if(user.isEmpty() || password.isEmpty()) view.error("Falten Camps!");
        else {
            goView("menu");
            //boolean b = controllerDomini.getUsuari(view.getTUsuari().getText(), view.getTPassword().getText());
            // if(b) view.vistaMenu();
            //else view.loginFail();
        }

    }

    private void registrar() {}


    private void logoff() {
        //TODO borrar sessio
        view.changeScreen("login");
    }

    private void goView(String vista) {
        view.changeScreen(vista);
    }


}
