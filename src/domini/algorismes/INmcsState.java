package domini.algorismes;

import java.util.List;

public interface INmcsState<TState, TAction> {

    double getScore();

    boolean isTerminalPosition();

    List<TAction> findAllLegalActions();

    INmcsState<TState,TAction> takeAction(TAction action);

    Pair<Double, List<TAction>> simulation();



}
