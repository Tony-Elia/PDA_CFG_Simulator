package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;
import Automata.TransitionValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(2));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('a','b', 'c'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','a'));

    int startState = 0;
    char stackInitial = '$';


    public Problem1(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.addTransition(0, 'a', TransitionValue.EPSILON, 0, 'a');
        transitionFunction.addTransition(0, TransitionValue.EPSILON, TransitionValue.EPSILON, 1, TransitionValue.EPSILON);
        transitionFunction.addTransition(1, 'b', TransitionValue.EPSILON, 1, TransitionValue.EPSILON);
        transitionFunction.addTransition(1, TransitionValue.EPSILON, TransitionValue.EPSILON, 2, TransitionValue.EPSILON);
        transitionFunction.addTransition(2, 'c', 'a', 2, TransitionValue.EPSILON);
        transitionFunction.addTransition(2, TransitionValue.EPSILON, '$', 2, TransitionValue.EPSILON);

        PDA pda = new PDA(3, inputAlphabet, stackAlphabet, transitionFunction,
                startState, finalStates, stackInitial);

        bw.write("1\n");
        pda.solveProblem(br, bw);
    }
}
