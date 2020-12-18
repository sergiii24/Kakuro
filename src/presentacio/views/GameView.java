package presentacio.views;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {


    JPanel gamePanel;


    public GameView() {

        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        gamePanel = new JPanel();
        add(gamePanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Temps: 00:00:00");
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblNewLabel);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);

        JLabel lblNewLabel_1 = new JLabel("Difficultat: Facil");
        lblNewLabel_1.setForeground(Color.GRAY);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblNewLabel_1);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);

        JLabel lblNewLabel_2 = new JLabel("Mode: Normal");
        lblNewLabel_2.setForeground(Color.GRAY);
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.EAST);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        Component verticalStrut = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut);

        JLabel lblNewLabel_3 = new JLabel("Restart");
        lblNewLabel_3.setForeground(Color.GRAY);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
        Image restart = new ImageIcon(this.getClass().getResource("img/restart.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_3.setIcon(new ImageIcon(restart));
        panel_1.add(lblNewLabel_3);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_1);

        JLabel lblNewLabel_4 = new JLabel("Check");
        lblNewLabel_4.setForeground(Color.GRAY);
        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
        Image check = new ImageIcon(this.getClass().getResource("img/check.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_4.setIcon(new ImageIcon(check));
        panel_1.add(lblNewLabel_4);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_2);

        JLabel lblNewLabel_5 = new JLabel("Solve");
        lblNewLabel_5.setForeground(Color.GRAY);
        lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
        Image solve = new ImageIcon(this.getClass().getResource("img/solve.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_5.setIcon(new ImageIcon(solve));
        panel_1.add(lblNewLabel_5);

        Component verticalStrut_3 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_3);

        JLabel lblNewLabel_6 = new JLabel("Clue");
        lblNewLabel_6.setForeground(Color.GRAY);
        lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
        Image clue = new ImageIcon(this.getClass().getResource("img/clue.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_6.setIcon(new ImageIcon(clue));
        panel_1.add(lblNewLabel_6);

        Component verticalStrut_4 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_4);

        JLabel lblNewLabel_7 = new JLabel("Pause");
        lblNewLabel_7.setForeground(Color.GRAY);
        lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
        Image pause = new ImageIcon(this.getClass().getResource("img/pause.png")).getImage().getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_7.setIcon(new ImageIcon(pause));
        panel_1.add(lblNewLabel_7);

        Component verticalStrut_5 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_5);

        JLabel lblNewLabel_8 = new JLabel("Save");
        lblNewLabel_8.setForeground(Color.GRAY);
        lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
        Image save = new ImageIcon(this.getClass().getResource("img/save.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_8.setIcon(new ImageIcon(save));
        panel_1.add(lblNewLabel_8);

        Component verticalStrut_6 = Box.createVerticalStrut(100);
        panel_1.add(verticalStrut_6);

        JButton btnNewButton = new JButton("Exit");
        Image exit = new ImageIcon(this.getClass().getResource("img/exit.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        btnNewButton.setIcon(new ImageIcon(exit));
        panel_1.add(btnNewButton);


    }

    public void setGamePanel(JPanel panel) {
        gamePanel.removeAll();
        gamePanel.add(panel);
    }

}

