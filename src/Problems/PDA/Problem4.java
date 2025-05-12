package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4{
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(1));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('a','b','c'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','a','b'));

    int startState = 0;
    char stackInitial = '$';

    public Problem4(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();

        // In state 0:
        // Read 'a' → ignore (don't touch stack)
        transitionFunction.addTransition(0, 'a', PDA.EPSILON, 0, 'a');

        // Read 'b' → push 'B' onto stack
        transitionFunction.addTransition(0, 'b','a', 1, 'b');

        // Transition to state 1 on first 'c'
        transitionFunction.addTransition(1, 'b', 'a', 1, PDA.EPSILON);

        // In state 1:
        // Read 'c' and pop 'B'
        transitionFunction.addTransition(1, PDA.EPSILON, '$', 2, '$');
        transitionFunction.addTransition(2, 'b', PDA.EPSILON, 2, 'b');
        transitionFunction.addTransition(2, 'c', 'b', 3, PDA.EPSILON);
        transitionFunction.addTransition(3, 'c', 'b', 3, PDA.EPSILON);
        transitionFunction.addTransition(3, PDA.EPSILON, '$', 4, PDA.EPSILON);
        // If stack has only initial symbol '$' and no input left, move to final state

        PDA pda = new PDA(5, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("1\n");
        pda.solveProblem(br, bw);
    }
}
