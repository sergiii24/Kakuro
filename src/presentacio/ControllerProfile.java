package presentacio;

import presentacio.views.ProfileView;


public class ControllerProfile {

    ProfileView profileView;
    ControllerPresentacio controllerPresentacio;

    public ControllerProfile(ProfileView view) {
        profileView = view;
    }

    public void initController(ControllerPresentacio controllerPresentacio ) {
        this.controllerPresentacio = controllerPresentacio;
        profileView.getbBackPerfil().addActionListener(e-> controllerPresentacio.goView("menu"));
    }

    public void setDataPerfil(String id, int nKakurosResolts, int puntuacio) {

        profileView.getLblUsernameinfo().setText(id);
        profileView.getLblNameinfo().setText(""+nKakurosResolts);
        profileView.getLblPasswordinfo().setText(""+puntuacio);

    }


}
