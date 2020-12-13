package domini;

import domini.models.INmcsState;
import domini.models.MonteState;
import domini.models.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class NestedMonteCarloSearch {

    boolean trobat;
    MonteState solucio;

    public NestedMonteCarloSearch() {
        this.trobat = false;
    }

    public <TState, TAction> Pair<Double, List<TAction>> executeSearch(INmcsState<TState, TAction> state, final int level, final Supplier<Boolean> isCanceled) {

        if(level <= 0) {

            return state.simulation();

        }

        Pair<Double, List<TAction>> globalBestResult = Pair.of(state.getScore(), new LinkedList<TAction>());
        final List<TAction> visitedNodes = new LinkedList<TAction>();

        while (!state.isTerminalPosition() && !isCanceled.get() && !trobat) {

            Pair<Double, List<TAction>> currentBestResult = Pair.of(Double.MAX_VALUE, new LinkedList<TAction>());
            TAction currentBestAction = null;

            for(TAction action : state.findAllLegalActions()) {

                final INmcsState<TState, TAction> currentState = state.takeAction(action);

                final Pair<Double, List<TAction>> simulationResult = executeSearch(currentState, level - 1, isCanceled);

                if (simulationResult.item1 <= currentBestResult.item1) {
                    currentBestAction = action;
                    currentBestResult = simulationResult;
                }
            }

            if (currentBestResult.item1 <= globalBestResult.item1) {
                visitedNodes.add(currentBestAction);
                globalBestResult = currentBestResult;
                globalBestResult.item2.addAll(0, visitedNodes);
            } else {
                currentBestAction = globalBestResult.item2.get(visitedNodes.size());
                visitedNodes.add(currentBestAction);
            }

            state = state.takeAction(currentBestAction);

        }

        if(state.getScore()==0 && state.isTerminalPosition()) {
            solucio = (MonteState) state;
            trobat = true;
        }

        return globalBestResult;

    }


}


