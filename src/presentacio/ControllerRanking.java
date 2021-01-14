package presentacio;

import domini.CtrlFactoryDomini;
import presentacio.views.RankingView;

import java.util.List;

public class ControllerRanking {

    RankingView rankingView;
    ControllerPresentacio controllerPresentacio;

    public ControllerRanking(RankingView rankingView) {
        this.rankingView = rankingView;
    }


    public void iniController(ControllerPresentacio controllerPresentacio) {
        carregaRanking();
        rankingView.getbBackR().addActionListener(e -> controllerPresentacio.goView("menu"));


    }

    private void carregaRanking(){
        List<String> ranking = CtrlFactoryDomini.getcDUsuariInstance().getNameUsersRanking();
        rankingView.updateRankingList(ranking);
    }

}
