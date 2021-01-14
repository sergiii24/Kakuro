package domini;

import dades.CtrlFactoryDades;
import domini.models.LinePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.NumberFormat;

public class CtrlDominiGestioTaulell {

    Tauler t;
    Casella[][] casellesSwing;
    JTextField[][] cells;

    public Tauler getT() {
        return t;
    }

    public void setT(Tauler t) {
        this.t = t;
    }

    public JPanel getPublicTaulell(String nom) {
        t = CtrlFactoryDades.getcTaulell().getPublicKakuro(nom);
        casellesSwing = t.clonar();
        return getBoardUI(t);
    }

    public JPanel getUserTaulell(String nom) {
        return getBoardUI(CtrlFactoryDades.getcTaulell().getUserKakuro(CtrlFactoryDomini.getcDUsuariInstance().getId(), nom));
    }

    public JPanel getBoardUI(Tauler t) {
        //creating grid of cells
        cells = new JTextField[t.getFil()][t.getCol()];
        JPanel panel = new JPanel(new GridLayout(t.getFil(), t.getCol()));
        panel.setPreferredSize(new Dimension(400, 400));

        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(1);
        numberFormatter.setMaximum(9);
        numberFormatter.setAllowsInvalid(false);

        for (int row = 0; row < t.getFil(); row++) {
            for (int column = 0; column < t.getCol(); column++) {
                JFormattedTextField textField;

                //tracking the type of each cell
                Casella cell = t.getCasellas()[row][column];
                //adding extra panel that will overlay the cells that are non-playable with game level numbers and diagonal line
                JPanel diagonalPanel = null;

                //according to type of cell, populate
                if (cell.isBlanc()) {

                    textField = new JFormattedTextField(numberFormatter);
                    textField.setText(((Blanc) cell).getNum() + "");
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setBorder(new LineBorder(Color.GRAY, 1));
                    int finalRow = row;
                    int finalColumn = column;
                    textField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if(e.getKeyCode()==KeyEvent.VK_DELETE||e.getKeyCode()==KeyEvent.VK_BACK_SPACE) textField.setValue(null);
                        }
                    });
                    textField.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            boolean finished = true;

                            ((Blanc) casellesSwing[finalRow][finalColumn]).setNum(Integer.parseInt(textField.getText()));


                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {

                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {

                        }
                    });
                    cells[row][column] = textField;
                    panel.add(textField);

                } else if (((Negre) cell).getFila() != 0 && ((Negre) cell).getColumna() != 0) {

                    JLabel label = new JLabel(((Negre) cell).getColumna() + "");
                    JLabel labelRIGHT = new JLabel(((Negre) cell).getFila() + "");
                    //settingTextField(textField);
                    //settingTextField(textFieldRIGHT);
                    diagonalPanel = new LinePanel(new BorderLayout(), label, labelRIGHT);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY, 1));
                    panel.add(diagonalPanel);


                } else if (((Negre) cell).getFila() != 0) {

                    JLabel label = new JLabel(((Negre) cell).getFila() + "");
                    //settingTextField(textField);
                    //adding diagonal line in board cell
                    diagonalPanel = new LinePanel(new BorderLayout(), label, true);
                    diagonalPanel.setEnabled(false);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY, 1));
                    panel.add(diagonalPanel);


                } else if (((Negre) cell).getColumna() != 0) {


                    JLabel label = new JLabel(((Negre) cell).getColumna() + "");
                    //settingTextField(textField);
                    //adding diagonal line in board cell
                    diagonalPanel = new LinePanel(new BorderLayout(), label, false);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY, 1));
                    panel.add(diagonalPanel);


                } else {

                    textField = new JFormattedTextField(numberFormatter);
                    settingTextField(textField);
                    textField.setBorder(new LineBorder(Color.GRAY, 1));
                    panel.add(textField);

                }


            }
        }

        return panel;
    }




    private void settingTextField(JTextField txt) {
        txt.setBackground(Color.black);
        txt.setForeground(Color.white);
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txt.setEditable(false);
    }


    public void importar(File selectedFile) {
        CtrlFactoryDades.getcTaulell().importar(selectedFile, CtrlFactoryDomini.getcDUsuariInstance().getId());
    }


    public boolean generateKakuro(int row, int col, TipusDificultat dif, String name) {

        t = new Tauler(name, new Generador().generateKakuro(row, col, dif), row, col, dif, true, true);
        return CtrlFactoryDades.getcTaulell().saveBoard(t, CtrlFactoryDomini.getcDUsuariInstance().getId());

    }

    public boolean generateKakuro(int row, int col, int n, String name) {

        t = new Tauler(name, new Generador().generateNumNegres(row, col, n), row, col, TipusDificultat.NORMAL, true, true);
        return CtrlFactoryDades.getcTaulell().saveBoard(t, CtrlFactoryDomini.getcDUsuariInstance().getId());

    }

    public boolean generateKakuroBlanc(int row, int col, int n, String name) {

        t = new Tauler(name, new Generador().generateNumBlanques(row, col, n), row, col,  TipusDificultat.NORMAL, true, true);
        return CtrlFactoryDades.getcTaulell().saveBoard(t, CtrlFactoryDomini.getcDUsuariInstance().getId());

    }


    public JPanel getGuestGenerated() {
        return getBoardUI(this.t);
    }

    public String getDificultat() {
        if(t.getDificultat() == null) return TipusDificultat.NORMAL.toString();
        return  t.getDificultat().toString();
    }

    public JPanel getSolucioTaulell() {
        return getBoardUI(new Tauler(this.t.getSolucio()));
    }

    public JPanel restartTaulell() {
        t.llimpiar();
        casellesSwing = t.clonar();
        return getBoardUI(this.t);
    }

    public void solveInBackGround() {
        TaskSolve solve = new TaskSolve();
        solve.execute();
    }

    public boolean check() {

        boolean b = true;

        for(int i=0; i<t.getFil(); i++) {
            for (int j = 0; j < t.getCol(); j++) {
                if(casellesSwing[i][j].isBlanc() ) {
                    if(((Blanc)casellesSwing[i][j]).getNum()==0) return false;
                    else {
                        if( b && ((Blanc)casellesSwing[i][j]).getNum() != ((Blanc)t.getSolucio()[i][j]).getNum()) b = false;
                    }
                }
            }
        }

        if(b) return true;
        else {
            return new Tauler(casellesSwing).check();
        }

    }

    public void pista() {
        for(int i=0; i<t.getFil(); i++) {
            for (int j = 0; j < t.getCol(); j++) {
                if (casellesSwing[i][j].isBlanc() && ((Blanc) casellesSwing[i][j]).getNum() == 0) {
                    ((Blanc) casellesSwing[i][j]).setNum(((Blanc)t.getSolucio()[i][j]).getNum());
                    cells[i][j].setText(((Blanc)t.getSolucio()[i][j]).getNum()+"");
                    return;
                }
            }
        }

    }

    public Tauler getBoardSwing() {
        return new Tauler(casellesSwing);
    }

    class TaskSolve extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            t.getSolucio();
            return null;
        }
    }

    public void destroy() {
        t = null;
        casellesSwing = null;
    }

}
