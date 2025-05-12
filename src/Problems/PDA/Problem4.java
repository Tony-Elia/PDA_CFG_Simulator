package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(3));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('a','b','c'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','A','B'));

    int startState = 0;
    char stackInitial = '$';

    public Problem4(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();

        // q0: push A's for each a
        transitionFunction.addTransition(0, 'a', PDA.EPSILON, 0, 'A');

        // q0: on 'b' and 'A' → pop A, move to q1
        transitionFunction.addTransition(0, 'b', 'A', 1, PDA.EPSILON);

        // q1: on 'b' and 'A' → pop A
        transitionFunction.addTransition(1, 'b', 'A', 1, PDA.EPSILON);

        // q1: when no more A, and top is $, push B
        transitionFunction.addTransition(1, 'b', '$', 1, 'B');

        // q1: on 'c' and 'B' → pop B, move to q2
        transitionFunction.addTransition(1, 'c', 'B', 2, PDA.EPSILON);

        // q2: on 'c' and 'B' → pop B
        transitionFunction.addTransition(2, 'c', 'B', 2, PDA.EPSILON);

        // q2: when stack has only $, accept
        transitionFunction.addTransition(2, PDA.EPSILON, '$', 3, PDA.EPSILON);

        PDA pda = new PDA(4, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("1\n");
        pda.solveProblem(br, bw);
    }
}
