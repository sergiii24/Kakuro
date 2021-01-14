package presentacio.views;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private JLabel lblRestart, lblCheck, lblSolve, lblClue, lblPause, lblSave;
    private JButton bExit, bRules;
    private JPanel gamePanel, gPanel;
    private JLabel lbltimer, lblDif, lblMode;

    public GameView() {

        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        gamePanel = new JPanel();
        add(gamePanel, BorderLayout.CENTER);

        lbltimer = new JLabel("00:00:00");
        lbltimer.setForeground(Color.GRAY);
        lbltimer.setFont(new Font("Consolas", Font.PLAIN, 13));
        lbltimer.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lbltimer);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);

        lblDif = new JLabel("Difficultat: Facil");
        lblDif.setForeground(Color.GRAY);
        lblDif.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblDif);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);

        lblMode = new JLabel("Mode: Normal");
        lblMode.setForeground(Color.GRAY);
        lblMode.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblMode);

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.EAST);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        Component verticalStrut = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut);

        lblRestart = new JLabel("Restart");
        lblRestart.setForeground(Color.GRAY);
        lblRestart.setFont(new Font("Arial", Font.BOLD, 12));
        Image restart = new ImageIcon(this.getClass().getResource("img/restart.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        lblRestart.setIcon(new ImageIcon(restart));
        panel_1.add(lblRestart);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_1);

        lblCheck = new JLabel("Check");
        lblCheck.setForeground(Color.GRAY);
        lblCheck.setFont(new Font("Arial", Font.BOLD, 12));
        Image check = new ImageIcon(this.getClass().getResource("img/check.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        lblCheck.setIcon(new ImageIcon(check));
        panel_1.add(lblCheck);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_2);

        lblSolve = new JLabel("Solve");
        lblSolve.setForeground(Color.GRAY);
        lblSolve.setFont(new Font("Arial", Font.BOLD, 12));
        Image solve = new ImageIcon(this.getClass().getResource("img/solve.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        lblSolve.setIcon(new ImageIcon(solve));
        panel_1.add(lblSolve);

        Component verticalStrut_3 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_3);

        lblClue = new JLabel("Clue");
        lblClue.setForeground(Color.GRAY);
        lblClue.setFont(new Font("Arial", Font.BOLD, 12));
        Image clue = new ImageIcon(this.getClass().getResource("img/clue.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        lblClue.setIcon(new ImageIcon(clue));
        panel_1.add(lblClue);

        Component verticalStrut_4 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_4);

        lblPause = new JLabel("Pause");
        lblPause.setForeground(Color.GRAY);
        lblPause.setFont(new Font("Arial", Font.BOLD, 12));
        Image pause = new ImageIcon(this.getClass().getResource("img/pause.png")).getImage().getScaledInstance(14, 14, Image.SCALE_SMOOTH);
        lblPause.setIcon(new ImageIcon(pause));
        panel_1.add(lblPause);

        Component verticalStrut_5 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_5);

        lblSave = new JLabel("Save");
        lblSave.setForeground(Color.GRAY);
        lblSave.setFont(new Font("Arial", Font.BOLD, 12));
        Image save = new ImageIcon(this.getClass().getResource("img/save.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        lblSave.setIcon(new ImageIcon(save));
        panel_1.add(lblSave);

        Component verticalStrut_6 = Box.createVerticalStrut(100);
        panel_1.add(verticalStrut_6);

        bRules = new JButton("Rules");
        Image exi = new ImageIcon(this.getClass().getResource("img/help.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        bRules.setIcon(new ImageIcon(exi));
        panel_1.add(bRules);

        Component verticalStrut_ = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_);

        bExit = new JButton("Exit");
        Image exit = new ImageIcon(this.getClass().getResource("img/exit.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        bExit.setIcon(new ImageIcon(exit));
        panel_1.add(bExit);


    }

    public void setGamePanel(JPanel panel) {
        gPanel = panel;
        gamePanel.removeAll();
        gamePanel.add(panel);
    }

    public JLabel getLbltimer() {
        return lbltimer;
    }

    public void updateLables(String mode, String dif) {
        lblDif.setText("Dificultat: "+dif);
        lblMode.setText("Mode: "+dif);
    }


    public JLabel getLblRestart() {
        return lblRestart;
    }

    public JLabel getLblCheck() {
        return lblCheck;
    }

    public JLabel getLblSolve() {
        return lblSolve;
    }

    public JLabel getLblClue() {
        return lblClue;
    }

    public JLabel getLblPause() {
        return lblPause;
    }

    public JLabel getLblSave() {
        return lblSave;
    }

    public JButton getbExit() {
        return bExit;
    }

    public JButton getbRules() {
        return bRules;
    }

    public void pause(){
        for (Component c : gPanel.getComponents()) {
            c.setEnabled(false);
        }
    }

    public void unpause() {
        for (Component c : gPanel.getComponents()) {
            c.setEnabled(true);
        }
    }
}

