package Automata;

public record TransitionValue (int nextState, char stackPush) {
    public static final char EPSILON = 'ε';
}
