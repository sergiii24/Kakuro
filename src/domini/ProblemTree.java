package domini;

import domini.models.State;

import java.util.ArrayList;
import java.util.Stack;

public class ProblemTree {

        private ArrayList<State> checker = new ArrayList<>();
        private Stack<State> stack = new Stack<>();
        private State current;

        public void dfs(State r, boolean isForwardChecking){
            stack.clear();
            stack.add(r);
            State nS;
            while(!stack.isEmpty()){
                State node = stack.pop();
                current = node;
                if(node.isSatisfied()){
                    current = node;
                    break;
                }
                if(node.isPossNode(isForwardChecking)){
                    for (State st : node.nextStates(node)) {
                        if(!checker.contains(st)){
                            st.setParent(node);
                            node.addChildren(st);
                            checker.add(st);
                        }
                    }
                }

                for (State pz : node.getChildren()) {
                    stack.push(pz);
                }
            }
        }

        public State getCurrent() {
            return current;
        }
 }

