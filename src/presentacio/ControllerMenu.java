package presentacio;

import domini.CtrlFactoryDomini;
import domini.TipusMode;
import presentacio.views.MenuView;

import javax.swing.*;
import java.util.List;

public class ControllerMenu {

    MenuView menuView;
    ControllerPresentacio controllerPresentacio;
    boolean publicKakuro;

    public ControllerMenu(MenuView menuView) {
        this.menuView = menuView;
        publicKakuro = true;
    }


    public void iniController(ControllerPresentacio controller) {
        this.controllerPresentacio = controller;


        //Principal
        menuView.getbJugar().addActionListener(e -> menuView.updateView("jugar"));
        menuView.getbKakuroManagement().addActionListener(e -> menuView.updateView("management"));
        menuView.getbPerfil().addActionListener(e -> controllerPresentacio.goToPerfil());
        menuView.getbStatistics().addActionListener(e -> controllerPresentacio.goView("ranking"));
        menuView.getbLogOff().addActionListener(e -> logoff());
        menuView.getbRules().addActionListener(e -> rules());

        //MenuJugar
        menuView.getbContinue().addActionListener(e -> continueGame());
        menuView.getB2Jugar().addActionListener(e -> {
            carregaLlistes();
            menuView.updateView("jugar2");
        });
        menuView.getbCrear().addActionListener(e -> menuView.updateView("crear"));
        menuView.getbBackJugar().addActionListener(e -> menuView.updateView("principal"));

        //MenuJugar2
        menuView.getbPlay().addActionListener(e -> jugar());
        menuView.getbBackJugar2().addActionListener(e -> menuView.updateView("jugar"));
        menuView.getListPublic().addListSelectionListener(e -> {
            menuView.getListUser().clearSelection();
            publicKakuro = true;
        });
        menuView.getListUser().addListSelectionListener(e -> {
            menuView.getListPublic().clearSelection();
            publicKakuro = false;
        });

        //MenuCrearInfiltrat

        menuView.getbBackCrear2().addActionListener(e -> {
            if (CtrlFactoryDomini.getcDUsuariInstance().isRegistrat()) menuView.updateView("management");
            else menuView.updateView("jugar");
        });
        menuView.getbGenerate().addActionListener(e -> generate());


        //MenuKakuroManagement
        menuView.getbImportar().addActionListener(e -> importar());
        menuView.getbBackManagement().addActionListener(e -> menuView.updateView("principal"));
        menuView.getbGenerarKakuro().addActionListener(e -> menuView.updateView("crear"));


    }

    private void rules() {
        JOptionPane.showMessageDialog(menuView, new Regles().getRegles(), "Rules", JOptionPane.INFORMATION_MESSAGE, null);
    }


    private void importar() {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(menuView);
        CtrlFactoryDomini.getcDTaulellInstance().importar(jf.getSelectedFile());
    }

    private void generate() {

        if (!CtrlFactoryDomini.getcDUsuariInstance().isRegistrat()) {
            CtrlFactoryDomini.getcDKakuroInstance().createGameKakuro(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                    Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()), menuView.getT(), menuView.getM());
            controllerPresentacio.playGuest(menuView.getM());
        } else {

            boolean b;
             if(menuView.getOp() == 0) b = CtrlFactoryDomini.getcDTaulellInstance().generateKakuro(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                    Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()), menuView.getT(), menuView.getTxtName().getText());
             else if(menuView.getOp() == 1) b = CtrlFactoryDomini.getcDTaulellInstance().generateKakuro(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                     Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()), Integer.parseInt(menuView.getComboBlanc().getSelectedItem().toString()), menuView.getTxtName().getText());
             else  b = CtrlFactoryDomini.getcDTaulellInstance().generateKakuroBlanc(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                         Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()),Integer.parseInt(menuView.getComboNegres().getSelectedItem().toString()), menuView.getTxtName().getText());

            if (b) {
                menuView.getTxtName().setText("");
                int input = JOptionPane.showConfirmDialog(menuView, "Do you want to play the game?");
                if (input == 0) { controllerPresentacio.playGuest(TipusMode.NORMAL);
                }
                else if (input == 1) menuView.updateView("management");
            } else
                JOptionPane.showMessageDialog(menuView, "Kakuro with this name already exists", "Kakuro existent", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void logoff() {
        CtrlFactoryDomini.getcDUsuariInstance().logoff();
        controllerPresentacio.goView("login");
    }

    private void jugar() {

        String nom = "";

        if (publicKakuro) nom = menuView.getListPublic().getSelectedValue().toString();
        else nom = menuView.getListUser().getSelectedValue().toString();

        controllerPresentacio.play(nom, menuView.getM(), publicKakuro);
    }

    public void vistaRegistrat() {

        menuView.getbContinue().setVisible(true);
        menuView.getbCrear().setVisible(false);
        menuView.getbLogOff().setText(Constants.LOGOFF);
        menuView.getPanelUserList().setVisible(true);
        menuView.getbPerfil().setVisible(true);
        menuView.getbKakuroManagement().setVisible(true);
        menuView.getLblName().setVisible(true);
        menuView.getTxtName().setVisible(true);
        menuView.getPanelModes().setVisible(false);
        menuView.getPanelGen().setVisible(true);
        menuView.getPa().setVisible(true);
    }

    public void vistaGuest() {

        menuView.getbCrear().setVisible(true);
        menuView.getbContinue().setVisible(false);
        menuView.getbLogOff().setText(Constants.LOGIN);
        menuView.getPanelUserList().setVisible(false);
        menuView.getbPerfil().setVisible(false);
        menuView.getbKakuroManagement().setVisible(false);
        menuView.getLblName().setVisible(false);
        menuView.getTxtName().setVisible(false);
        menuView.getPanelModes().setVisible(true);
        menuView.getPanelGen().setVisible(false);
        menuView.getPa().setVisible(false);
    }

    private void continueGame() {

        List<String> partides = CtrlFactoryDomini.getcDKakuroInstance().getNameStartedGames();
        if (partides.isEmpty()) JOptionPane.showMessageDialog(null, "No started Games!");
        else {
            String result = (String) JOptionPane.showInputDialog(
                    menuView,
                    "Select one of the color",
                    "Swing Tester",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    partides.toArray(),
                    0
            );

            if (!result.isEmpty()) {

                CtrlFactoryDomini.getcDKakuroInstance().carregar(result);
                controllerPresentacio.playGuest(menuView.getM());
            }

        }


    }

    private void carregaLlistes() {

        List<String> partides = CtrlFactoryDomini.getcDKakuroInstance().getNamePublicGames();
        menuView.updatePublicList(partides);

        if (CtrlFactoryDomini.getcDUsuariInstance().isRegistrat()) {
            List<String> p = CtrlFactoryDomini.getcDKakuroInstance().getNameUserGames();
            menuView.updateUserList(p);
        }

    }

}



