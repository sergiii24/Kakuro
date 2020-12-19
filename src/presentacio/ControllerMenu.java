package presentacio;

import domini.CtrlFactoryDomini;
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
        menuView.getbStatistics().addActionListener(e -> controllerPresentacio.goView("Ranking"));
        menuView.getbLogOff().addActionListener(e -> logoff());

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
        menuView.getbCrearKakuro().addActionListener(e -> crear());


    }

    private void importar() {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(menuView);
        CtrlFactoryDomini.getcDTaulellInstance().importar(jf.getSelectedFile());
    }

    private void crear() {
    }

    private void generate() {

        String dif = "";
        for (JRadioButton b : menuView.getButtonsDificultatJugar()) {
            if (b.isSelected()) dif = b.getName();
        }

        String mode = "";
        for (JRadioButton b : menuView.getButtonsModerCrear()) {
            if (b.isSelected()) mode = b.getName();
        }

        if (CtrlFactoryDomini.getcDUsuariInstance().isRegistrat())
            CtrlFactoryDomini.getcDKakuroInstance().createGameKakuro(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                    Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()), dif, mode);
        else
            CtrlFactoryDomini.getcDTaulellInstance().generateKakuro(Integer.parseInt(menuView.getComboRow().getSelectedItem().toString()),
                    Integer.parseInt(menuView.getComboColumns().getSelectedItem().toString()), dif, menuView.getTxtName().getName());

    }

    private void logoff() {
        controllerPresentacio.goView("login");
    }

    private void jugar() {

        String nom = "";

        if (publicKakuro) nom = menuView.getListPublic().getSelectedValue().toString();
        else nom = menuView.getListUser().getSelectedValue().toString();

        String mode = "";

        for (JRadioButton b : menuView.getButtonsModeJugar()) {
            if (b.isSelected()) mode = b.getName();
        }

        controllerPresentacio.play(nom, mode, publicKakuro);
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

            if (!result.isEmpty()) System.out.println(result);

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



