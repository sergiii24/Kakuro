package presentacio;

import dades.Reader;
import domini.ControllerDomini;
import domini.Tauler;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Controller {

    Sudoku view;
    ControllerDomini controllerDomini;

    public Controller(Sudoku view, ControllerDomini controllerDomini) {
        this.view = view;
        this.controllerDomini = controllerDomini;
    }

    public void initController() {

        try {
            Tauler b = new Reader().llegirFitxer("src/data/exemple1");
            JPanel panel = controllerDomini.getBoardUI(b);
            view.ficavista(panel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
