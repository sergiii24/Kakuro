package presentacio;

import domini.CtrlFactoryDomini;
import domini.TipusMode;
import presentacio.views.GameView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class ControllerGame {

    GameView gameView;
    ControllerPresentacio controllerPresentacio;
    private DecimalFormat timeFormatter;
    private Timer timer;
    private byte centiseconds = 0;
    private byte seconds = 0;
    private short minutes = 0;
    private boolean pause;

    public ControllerGame(GameView gameView) {
        this.gameView = gameView;
    }

    public void iniController(ControllerPresentacio controllerPresentacio) {

        this.controllerPresentacio = controllerPresentacio;
        timeFormatter = new DecimalFormat("00");

        timer = new Timer(10, e -> {
            if (centiseconds < 100) {
                centiseconds++;
            } else {
                if (seconds == 59 && minutes == 59) {
                    timer.stop();
                } else if (seconds < 60) {
                    seconds++;
                    centiseconds = 00;
                } else {
                    minutes++;
                    seconds = 00;
                    centiseconds = 00;
                }
            }
            gameView.getLbltimer().setText(timeFormatter.format(minutes) + ":"
                    + timeFormatter.format(seconds) + "."
                    + timeFormatter.format(centiseconds));
        });

        gameView.getLblRestart().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restartKakuro();
            }
        });
        gameView.getLblCheck().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                check();
            }
        });
        gameView.getLblClue().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clue();
            }
        });
        gameView.getLblPause().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pause();
            }
        });
        gameView.getLblSave().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                save();
            }
        });
        gameView.getLblSolve().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                solve();
            }
        });
        gameView.getbExit().addActionListener(e -> exit());
        gameView.getbRules().addActionListener(e -> rules());
        pause = false;

    }

    public void setUpGame(String nom, TipusMode mode, boolean publicKakuro) {

        if (publicKakuro) gameView.setGamePanel(CtrlFactoryDomini.getcDTaulellInstance().getPublicTaulell(nom));
        else gameView.setGamePanel(CtrlFactoryDomini.getcDTaulellInstance().getUserTaulell(nom));

        gameView.updateLables(CtrlFactoryDomini.getcDTaulellInstance().getDificultat(), mode.toString());

        CtrlFactoryDomini.getcDKakuroInstance().createNewGame(mode);

        CtrlFactoryDomini.getcDTaulellInstance().solveInBackGround();


    }

    public void setUpGameGuest(TipusMode mode) {

        gameView.setGamePanel(CtrlFactoryDomini.getcDTaulellInstance().getGuestGenerated());
        gameView.updateLables(CtrlFactoryDomini.getcDTaulellInstance().getDificultat(), mode.toString());
        CtrlFactoryDomini.getcDTaulellInstance().solveInBackGround();

    }


    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }


    private void save() {
        CtrlFactoryDomini.getcDKakuroInstance().guardar(minutes, seconds, centiseconds);
        controllerPresentacio.goView("menu");
    }

    private void pause() {
        pause = !pause;
        if (pause) {
            stopTimer();
            gameView.pause();
        } else {
            startTimer();
            gameView.unpause();
        }
    }

    private void clue() {
        CtrlFactoryDomini.getcDTaulellInstance().pista();
        gameView.validate();
    }

    private void check() {
        if (!pause) pause();
        boolean b = CtrlFactoryDomini.getcDTaulellInstance().check();
        if (b) {
            CtrlFactoryDomini.getcDKakuroInstance().acabarPartida(minutes, seconds, centiseconds);
            JOptionPane.showMessageDialog(gameView, "GoodJob! You've resolve the kakuro correctly!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE, null);
            controllerPresentacio.goView("menu");
        } else {
            JOptionPane.showMessageDialog(gameView, "The Kakuro is not correct :(", "Sorry!", JOptionPane.INFORMATION_MESSAGE, null);
            pause();
        }

    }

    private void restartKakuro() {
        JPanel panel = CtrlFactoryDomini.getcDTaulellInstance().restartTaulell();
        gameView.setGamePanel(panel);
        seconds = 00;
        centiseconds = 00;
        minutes = 00;
        timer.restart();
    }

    private void solve() {
        pause();
        JPanel panel = CtrlFactoryDomini.getcDTaulellInstance().getSolucioTaulell();
        gameView.setGamePanel(panel);
        gameView.pause();
    }

    private void exit() {
        pause();
        int op = JOptionPane.showConfirmDialog(gameView, "Are you sure?", "Exit the game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == 0) {
            CtrlFactoryDomini.getcDKakuroInstance().cancelarPartida();
            controllerPresentacio.goView("menu");
        } else {
            pause();
        }
    }

    private void rules() {
        JOptionPane.showMessageDialog(gameView, new Regles().getRegles(), "Rules", JOptionPane.INFORMATION_MESSAGE, null);
    }


}
