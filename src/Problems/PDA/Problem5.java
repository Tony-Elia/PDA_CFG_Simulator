package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5{
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(2));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('a','b','c'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','b'));

    int startState = 0;
    char stackInitial = '$';

    public Problem5(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();

        // In state 0:
        // Read 'a' → ignore (don't touch stack)
        transitionFunction.addTransition(0, 'a', PDA.EPSILON, 0, PDA.EPSILON);

        // Read 'b' → push 'B' onto stack
        transitionFunction.addTransition(0, 'b', PDA.EPSILON, 0, 'B');

        // Transition to state 1 on first 'c'
        transitionFunction.addTransition(0, 'c', PDA.EPSILON, 1, PDA.EPSILON);

        // In state 1:
        // Read 'c' and pop 'B'
        transitionFunction.addTransition(1, 'c', 'B', 1, PDA.EPSILON);

        // If stack has only initial symbol '$' and no input left, move to final state
        transitionFunction.addTransition(1, PDA.EPSILON, '$', 2, PDA.EPSILON);

        PDA pda = new PDA(3, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("1\n");
        pda.solveProblem(br, bw);
    }
}
