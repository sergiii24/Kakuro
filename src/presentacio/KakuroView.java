package presentacio;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class KakuroView {

    private JFrame frame;
    private JButton myButton1;
    private JLabel myButton1_Label_E;
    private JLabel myButton1_Label_S;

    public KakuroView() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() { new KakuroView(); }
        });
    }
}
