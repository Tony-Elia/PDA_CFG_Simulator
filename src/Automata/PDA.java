package Automata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;


public class PDA {
    int noOfStates;
    ArrayList<Character> inputAlphabet;
    ArrayList<Character> stackAlphabet;
    TransitionFunction transitionFunction;
    int startState;
    ArrayList<Integer> finalStates;
    char stackInitial;
    String str;

    public PDA(int noOfStates, List<Character> inputAlphabet, List<Character> stackAlphabet,
               TransitionFunction transitionFunction, int startState, List<Integer> finalStates, char stackInitial){
        this.noOfStates = noOfStates;
        this.inputAlphabet = (ArrayList<Character>) inputAlphabet;
        this.stackAlphabet = (ArrayList<Character>) stackAlphabet;
        this.transitionFunction = transitionFunction;
        this.startState = startState;
        this.finalStates = (ArrayList<Integer>) finalStates;
        this.stackInitial = stackInitial;
    }

    public boolean transition(int currState, int cursor, Stack<Character> stack) {
        if(cursor == str.length() && finalStates.contains(currState) && stack.isEmpty())
            return true; // Base Case

        char stackTop = TransitionValue.EPSILON;
        if(!stack.isEmpty()) stackTop = stack.peek();
        TransitionValue[] transitions = getAllTransitions(currState, cursor, stackTop);

        boolean res = false;
        for(int i = 0; i < transitions.length; i++) {
            if(transitions[i] != null) {
                Stack<Character> newStack = (Stack<Character>) stack.clone();
                char stackPush = transitions[i].stackPush();
                if(stackPush != TransitionValue.EPSILON)
                    newStack.push(stackPush); // do not push epsilons
                if (i < 2) // pop the stack top
                    newStack.pop();
                if ((i % 2) == 0)
                    res |= transition(transitions[i].nextState(), cursor + 1, newStack); // consume the current char
                else res |= transition(transitions[i].nextState(), cursor, newStack); // consume ε
            }
        }

        return res;
    }

    public boolean isAccepted(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(stackInitial);
        str = s;

        return transition(startState, 0, stack);
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) throws IOException {
        String input;
        while(true) {
            input = br.readLine();
            if(input.equals("end")) break;
            bw.write((isAccepted(input) ? "accepted" : "not accepted") + "\n");
        }
        bw.write("x\n");
    }

    public TransitionValue[] getAllTransitions(int state, int cursor, Character stackTop) {
        TransitionValue[] allTransitions = new TransitionValue[4];
        char consume = (cursor >= str.length()) ? TransitionValue.EPSILON : str.charAt(cursor);
        allTransitions[0] = transitionFunction.getTransition(state, consume, stackTop); // consume the current char and pop stack
        allTransitions[1] = transitionFunction.getTransition(state, TransitionValue.EPSILON, stackTop); // consume nothing and pop stack
        allTransitions[2] = transitionFunction.getTransition(state, consume, TransitionValue.EPSILON); // consume current char and pop nothing
        allTransitions[3] = transitionFunction.getTransition(state, TransitionValue.EPSILON, TransitionValue.EPSILON); // consume nothing and pop nothing
        return allTransitions;
    }

}
