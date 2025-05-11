package Automata;

import java.util.HashMap;
import java.util.Map;

record TransitionKey (int currentState, char input, char stackTop) {}

public class TransitionFunction {
    Map<TransitionKey, TransitionValue> transitions = new HashMap<>();

    public void addTransition(int currentState, char input, char stackTop, int nextState, char stackPush) {
        transitions.put(new TransitionKey(currentState, input, stackTop), new TransitionValue(nextState, stackPush));
    }

    public TransitionValue getTransition(int currentState, char input, char stackTop){
        return transitions.get(new TransitionKey(currentState, input, stackTop));
    }
}
