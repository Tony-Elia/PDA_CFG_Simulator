package Automata;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;

public class CFG {
    CFG(ArrayList<Character> terminals, ArrayList<Character> nonTermianls, Character startSymbol,
        Map<Character, ArrayList<String>> productions){
    }

    public boolean derive (String currentDerivation ,String text) {
        // return true if text can be generated using grammer rule
        // return false otherwise
        return false;
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) {
        // read input from input file then call derive method
    }
}
