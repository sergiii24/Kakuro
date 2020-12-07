package presentacio;

import dades.Reader;
import domini.ControllerDomini;
import domini.Tauler;

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

        controllerDomini.iniControlador();

        view.getEntrar().addActionListener(e -> login());
        view.getLblRegistrar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goToRegistrar();
            }
        });
        view.getBackLogin().addActionListener(e -> atrasLogin());
        view.getSignUp().addActionListener(e -> registrar());


    }


       /* try {
            Tauler b = new Reader().llegirFitxer("src/data/exemple1");
            JPanel panel = controllerDomini.getBoardUI(b);
            view.ficavista(panel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


    private void login(){

        String user = view.getTUsuari().getText();
        String password = view.getTPassword().getText();
        if(user.isEmpty() || password.isEmpty()) view.error("Falten Camps!");
        else {
            //boolean b = controllerDomini.getUsuari(view.getTUsuari().getText(), view.getTPassword().getText());
            // if(b) view.vistaMenu();
            //else view.loginFail();
        }

    }

    private void goToRegistrar() {
        view.changeScreen("reg");
    }

    private void atrasLogin() {
        view.changeScreen("login");
    }

    private void registrar() {}



}
