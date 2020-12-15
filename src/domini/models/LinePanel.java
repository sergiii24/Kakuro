package domini.models;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class LinePanel extends JPanel {

    public LinePanel(LayoutManager layout, JTextField textField, Boolean align) {
        super(layout);
        this.setBackground(Color.black);
        settingTxt(textField);

        if(align) {
            textField.setHorizontalAlignment(JTextField.RIGHT);
            this.add(textField,BorderLayout.NORTH);
        }else {
            textField.setHorizontalAlignment(JTextField.LEFT);
            this.add(textField,BorderLayout.SOUTH);
        }
    }

    public LinePanel(LayoutManager layout, JTextField textFieldLEFT, JTextField textFieldRIGHT) {
        super(layout);
        this.setBackground(Color.black);

        settingTxt(textFieldLEFT);
        settingTxt(textFieldRIGHT);

        textFieldLEFT.setHorizontalAlignment(JTextField.LEFT);
        textFieldRIGHT.setHorizontalAlignment(JTextField.RIGHT);

        this.add(textFieldLEFT, BorderLayout.SOUTH);
        this.add(textFieldRIGHT, BorderLayout.NORTH);

    }

    public void settingTxt(JTextField txt) {
        txt.setBackground(new Color(0,0,0,0));
        txt.setForeground(Color.white);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //object 2 added to the panel of the cell on the board
        Graphics2D g2D = (Graphics2D) g; //casting to 2D graphics object to use stroke method
        g2D.setColor(Color.GRAY);
        int offset = 1;
        Line2D diagonal = new Line2D.Float(offset, offset, this.getWidth()-offset, this.getHeight()-offset);
        g2D.setStroke(new BasicStroke(2));
        g2D.draw(diagonal);
    }
}