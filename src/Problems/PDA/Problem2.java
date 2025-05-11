package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    int noOfStates = 8;
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(7));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('a','b'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','a', 'x'));

    int startState = 0;
    char stackInitial = '$';


    public Problem2(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.addTransition(0, 'a', PDA.EPSILON, 1, 'a');
        transitionFunction.addTransition(1, 'a', PDA.EPSILON, 2, 'x');
        transitionFunction.addTransition(2, 'a', PDA.EPSILON, 3, 'a');
        transitionFunction.addTransition(3, 'a', PDA.EPSILON, 1, 'a');
        transitionFunction.addTransition(3, 'b', 'a', 4, PDA.EPSILON);
        transitionFunction.addTransition(4, PDA.EPSILON, 'x', 5, PDA.EPSILON);
        transitionFunction.addTransition(5, 'b', 'a', 6, PDA.EPSILON);
        transitionFunction.addTransition(6, 'b', 'a', 4, PDA.EPSILON);
        transitionFunction.addTransition(6, PDA.EPSILON, '$', 7, PDA.EPSILON);

        PDA pda = new PDA(noOfStates, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("2\n");
        pda.solveProblem(br, bw);
    }
}
