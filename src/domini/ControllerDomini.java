package domini;

import domini.models.LinePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ControllerDomini {

    private Usuari user;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;

    public void iniControlador() {
        user = new Usuari();
        ctrlDominiGestioUsuari = CtrlFactory.getcDUsuariInstance();
    }



    public JPanel getBoardUI(Tauler t) {
        //creating grid of cells
        JTextField[][] cells = new JTextField[t.getFil()][t.getCol()];
        JPanel panel = new JPanel(new GridLayout(t.getFil(),t.getCol()));

        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(1);
        numberFormatter.setMaximum(9);
        numberFormatter.setAllowsInvalid(false);

        for(int row = 0; row < t.getFil(); row++)
        {
            for(int column = 0; column < t.getCol(); column++)
            {
                JFormattedTextField textField;

                //tracking the type of each cell
                Casella cell = t.getCasellas()[row][column];
                //adding extra panel that will overlay the cells that are non-playable with game level numbers and diagonal line
                JPanel diagonalPanel = null;

                //according to type of cell, populate
                if(cell.isBlanc()) {

                    textField = new JFormattedTextField(numberFormatter);
                    textField.setText(((Blanc)cell).getNum()+"");
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setBorder(new LineBorder(Color.GRAY,1));

                    panel.add(textField);

                } else if(((Negre)cell).getFila()!=0 && ((Negre)cell).getColumna()!=0) {

                    textField = new JFormattedTextField(((Negre) cell).getColumna());
                    JFormattedTextField textFieldRIGHT = new JFormattedTextField(((Negre) cell).getFila());
                    settingTextField(textField);
                    settingTextField(textFieldRIGHT);
                    //using constructor that expects two text values to place in board cell
                    diagonalPanel = new LinePanel(new BorderLayout(), textField, textFieldRIGHT);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                    panel.add(diagonalPanel);


                } else if(((Negre)cell).getFila()!=0) {

                    textField = new JFormattedTextField(((Negre) cell).getFila());
                    settingTextField(textField);
                    //adding diagonal line in board cell
                    diagonalPanel = new LinePanel(new BorderLayout(), textField, true);
                    diagonalPanel.setEnabled(false);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                    panel.add(diagonalPanel);



                } else if(((Negre)cell).getColumna()!=0) {


                    textField = new JFormattedTextField(((Negre) cell).getColumna());
                    settingTextField(textField);
                    //adding diagonal line in board cell
                    diagonalPanel = new LinePanel(new BorderLayout(), textField, false);
                    diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                    panel.add(diagonalPanel);



                } else {

                    textField = new JFormattedTextField(numberFormatter);
                    settingTextField(textField);
                    textField.setBorder(new LineBorder(Color.GRAY, 1));
                    panel.add(textField);

                }


                //placing textfield value in input array to track user input
                cells[row][column] = textField;
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







}
