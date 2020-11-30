/*
package presentacio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JComponent;*/
/**//*

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;



public class GameView
{
    private Controller controller; // GameController object reference

    //UI components
    private JTextField[][] cells; // multidimensional JTextField array object reference
    private JPanel currentBoard; // JPanel object reference

    //Main application frame and properties
    private JFrame frame; // JFrame object reference
    private int gridSizeX; // size of our grid in terms of the x coordinate
    private int gridSizeY; // size of our grid in terms of the y coordinate

    //Number formatter for displaying
    NumberFormat numberFormat = NumberFormat.getInstance(); // NumberFormat object reference
    NumberFormatter numberFormatter = new NumberFormatter(numberFormat); // NumberFormatter object reference

    */
/**
     * GameView constructor that initializes the game interface
     *
     * @param controller
     * @param X11
     * @param chronoLabel
     * @param menuBar
     *//*

    public GameView(final Controller controller, Boolean X11, JComponent chronoLabel, JComponent menuBar)
    {
        //Initialize number formatter
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(1);
        numberFormatter.setMaximum(9);

        if (controller != null)
        {
            this.controller = controller;
            gridSizeX = controller.model.getRows();
            gridSizeY = controller.model.getColumns();
        }

        if (X11) {
            frame = new JFrame("KAKURO");
            //buttonMenu = new ButtonMenuView(frame, gridSizeX, gridSizeY, controller);

            //Initialize the application frame
            int frameSize = 60;
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int x = frameSize*gridSizeX;
            int y = frameSize*gridSizeY;
            frame.setSize(x, y);
            frame.setResizable(false);

            //Create a timer at the top
            frame.getContentPane().add(chronoLabel, BorderLayout.BEFORE_FIRST_LINE);
            //Main game UI stays at the center
            currentBoard = con(controller.model.board);
            frame.getContentPane().add(currentBoard);
            //Button menu stays at the bottom
            frame.getContentPane().add(menuBar, BorderLayout.AFTER_LAST_LINE);

            frame.pack();
            frame.setSize(x,y);
            frame.setVisible(true);
        }
    }

    */
/**
     * Accesses the cells from the JTextField object
     *
     * @return A multidimensional JTextfield array object
     *//*

    public JTextField[][] getSavedInput(){
        return cells;
    }

    */
/**
     * updateView method which updates the current view interface
     *//*

    public void updateView() {
        //If a panel is already attached to the frame, remove it
        JPanel newBoardPanel = getBoardUI(controller.model.board);
        if(currentBoard != null)
            frame.getContentPane().remove(currentBoard);

        //Save a reference to the new panel
        frame.getContentPane().add(newBoardPanel);
        currentBoard = newBoardPanel;;
    }

    */
/**
     * showBoard method to show the board interface
     *//*

    public void showBoard() {
        currentBoard.setVisible(true);
    }

    */
/**
     * hideBoard method to hide the board interface
     *//*

    public void hideBoard() {
        currentBoard.setVisible(false);
    }

    */
/**
     * Number formatter
     * Accesses the minimum number that is valid in our board
     *
     * @return
     *  - an integer
     *//*

    public int getMinNumberValid() {
        return (int) numberFormatter.getMinimum();
    }

    */
/**
     * Number formatter
     * Accesses type of the number formatter
     *
     * @return
     *  - an object
     *//*

    public Object getNumberFormatterClassType() {
        return numberFormatter.getClass();
    }

    */
/**
     * Number formatter
     * Accesses the maximum number that is valid in our board
     *
     * @return
     *  - an integer
     *//*

    public int getMaxNumberValid() {
        return (int) numberFormatter.getMaximum();
    }


*/
