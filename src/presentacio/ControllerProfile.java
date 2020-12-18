package presentacio;

import domini.CtrlDominiGestioUsuari;
import domini.CtrlFactoryDomini;
import presentacio.views.ProfileView;


public class ControllerProfile {

    ProfileView profileView;
    ControllerPresentacio controllerPresentacio;
    CtrlDominiGestioUsuari ctrlDominiGestioUsuari;

    public ControllerProfile(ProfileView view) {
        profileView = view;
        ctrlDominiGestioUsuari = CtrlFactoryDomini.getcDUsuariInstance();
    }

    public void initController(ControllerPresentacio controllerPresentacio ) {
        this.controllerPresentacio = controllerPresentacio;
        profileView.getbBackPerfil().addActionListener(e-> controllerPresentacio.goView("menu"));
    }

    public void updateDataPerfil() {

        profileView.getLblUsernameinfo().setText(ctrlDominiGestioUsuari.getId());
        profileView.getLblNameinfo().setText("" + ctrlDominiGestioUsuari.getNKResolts());
        profileView.getLblPasswordinfo().setText("" + ctrlDominiGestioUsuari.getPuntuacio());

    }


}
