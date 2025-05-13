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

        transitionFunction.addTransition(0, 'a', PDA.EPSILON, 0, PDA.EPSILON);
        transitionFunction.addTransition(0, 'b', PDA.EPSILON, 0, 'b');
        transitionFunction.addTransition(0, PDA.EPSILON, PDA.EPSILON, 1, PDA.EPSILON);
        transitionFunction.addTransition(1, 'c', 'b', 1, PDA.EPSILON);
        transitionFunction.addTransition(1, PDA.EPSILON, '$', 2, PDA.EPSILON);

        PDA pda = new PDA(3, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("5\n");
        pda.solveProblem(br, bw);
    }
}
