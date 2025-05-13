package Problems.PDA;

import Automata.PDA;
import Automata.TransitionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    ArrayList<Integer> finalStates = new ArrayList<>(List.of(1));
    ArrayList<Character> inputAlphabet = new ArrayList<>(Arrays.asList('{','}'));
    ArrayList<Character> stackAlphabet = new ArrayList<>(Arrays.asList('$','{'));

    int startState = 0;
    char stackInitial = '$';

    public Problem3(BufferedReader br, BufferedWriter bw) throws IOException {
        TransitionFunction transitionFunction = new TransitionFunction();

        // Push '{' when reading '{'
        transitionFunction.addTransition(0, '{', PDA.EPSILON, 0, '{');

        // Pop '{' when reading '}'
        transitionFunction.addTransition(0, '}', '{', 0, PDA.EPSILON);
        // Skip the white space
        transitionFunction.addTransition(0, ' ', PDA.EPSILON, 0, PDA.EPSILON);
        // If stack has only '$' and no input left, move to accepting state 1
        transitionFunction.addTransition(0, PDA.EPSILON, '$', 1, PDA.EPSILON);

        PDA pda = new PDA(2, inputAlphabet, stackAlphabet, transitionFunction,
                          startState, finalStates, stackInitial);

        bw.write("3\n");
        pda.solveProblem(br, bw);
    }
}
