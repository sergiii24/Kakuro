package presentacio;

import presentacio.views.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KakuroView extends JFrame {

    //Kakuro

    private final JPanel panelInici;
    private final JPanel panelRegistrar;
    private final JPanel panelMenu;
    private final JPanel panelJugar;
    private final JPanel panelPerfil;
    private final JPanel panelRanking;


    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private final int size = 1;
    private JFormattedTextField[][] nums;
    private JLabel[][] numsImg;
    private final CardLayout cardLayout;
    private final JPanel cardPanel;


    /**
     * Create the frame.
     */
    public KakuroView(LoginView loginView, SignUpView signUpView, ProfileView profileView, MenuView menuView, GameView gameView, RankingView rankingView) {
        setPreferredSize(new Dimension(800, 600));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        setIconImage(new ImageIcon(KakuroView.class.getResource("../assets/img/Logo_Kajugo.png")).getImage());

        //setJMenuBar(menuBar);

        contentPane = new JPanel();
        //contentPane.setPreferredSize(new Dimension(600, 490));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


        //INICI
        cardPanel = new JPanel();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        cardLayout = new CardLayout(0, 0);
        cardPanel.setLayout(cardLayout);

        panelInici = loginView;
        cardPanel.add(panelInici, "login");

        panelRegistrar = signUpView;
        cardPanel.add(panelRegistrar, "reg");

        panelMenu = menuView;
        cardPanel.add(panelMenu, "menu");

        panelPerfil = profileView;
        cardPanel.add(panelPerfil, "perfil");

        panelJugar = gameView;
        cardPanel.add(panelJugar, "game");

        panelRanking = rankingView;
        cardPanel.add(panelRanking, "ranking");

        cardLayout.show(cardPanel, "login");

        pack();

    }


    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
        Image image = imageIcon.getImage();                                             // transform it
        Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
        return new ImageIcon(newimg);
    }


    public void ficavista(JPanel panel) {
        cardPanel.add(panel, "Kakuro");
        cardLayout.show(cardPanel, "Kakuro");
        pack();
    }


    //Actualitzar Vistes

    public void error(String missatge) {

        JOptionPane.showOptionDialog(new JFrame(), missatge,
                "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,
                null, new Object[]{"Exit"}, JOptionPane.CANCEL_OPTION);

    }


    public void changeScreen(String screen) {
        cardLayout.show(cardPanel, screen);
    }


}