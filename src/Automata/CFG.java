package Automata;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class CFG {
    public static final String EPSILON = "";
    public static final int MAX_DEPTH = 15; // Max Depth of recursion to prevent stackoverflow of left recursion
    String str;
    ArrayList<Character> terminals;
    ArrayList<Character> nonTerminals;
    char startSymbol;
    Map<Character, ArrayList<String>> productions;
    Set<String> visitedDerivations;

    public CFG(ArrayList<Character> terminals, ArrayList<Character> nonTerminals, Character startSymbol,
               Map<Character, ArrayList<String>> productions){
        this.terminals = terminals;
        this.nonTerminals = new ArrayList<>(nonTerminals);
        this.startSymbol = startSymbol;
        this.productions = new HashMap<>(productions);
        this.visitedDerivations = new HashSet<>();
    }

    public boolean derive (String currentDerivation, int depth) {
        if(currentDerivation.equals(str)) return true;

        Character nonTerminal = nonTerminalIndex(currentDerivation);
        if(nonTerminal == null || terminalsSize(currentDerivation) > str.length() || depth++ >= MAX_DEPTH
                || !visitedDerivations.add(currentDerivation))
            return currentDerivation.equals(str);

        for(String d : productions.get(nonTerminal)) {
            if(derive(currentDerivation.replaceFirst("" + nonTerminal, d), depth)) return true;
        }
        return false;
    }

    public boolean isAccepted(String s) {
        visitedDerivations.clear();
        str = s;
        return derive("" + startSymbol, 0);
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

    public Character nonTerminalIndex(String derivative) {
        for(int i = 0; i < derivative.length(); i++) {
            if(nonTerminals.contains(derivative.charAt(i))) return derivative.charAt(i);
        }
        return null;
    }

    public int terminalsSize(String derivative) {
        int cnt = 0;
        for (int i = 0; i < derivative.length(); i++) {
            if(terminals.contains(derivative.charAt(i))) cnt++;
        }
        return cnt;
    }
}
