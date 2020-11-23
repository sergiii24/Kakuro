package dades;

import domini.Tauler;

import java.io.*;

public class Writer {

    public void escriureConsola(Tauler tauler) {

        System.out.println(tauler.toString());

    }

    public void escriureSolucioConsola(Tauler tauler) {

        System.out.println(tauler.imprimirSolucio());

    }

    public void escriureFitxer(Tauler tauler, String nom) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nom))) {

            bw.write(tauler.toString());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

}
