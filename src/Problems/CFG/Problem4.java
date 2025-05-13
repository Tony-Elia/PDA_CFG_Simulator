package Problems.CFG;

import Automata.CFG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    ArrayList<Character> terminals = new ArrayList<>(Arrays.asList('a','b'));
    ArrayList<Character> nonTerminals = new ArrayList<>(Arrays.asList('S'));
    Character startSymbol = 'S';
    Map<Character,ArrayList<String>> productionRules = new HashMap<>();

    public Problem4(BufferedReader br, BufferedWriter bw) throws IOException {
        ArrayList<String> production_S = new ArrayList<>(Arrays.asList("aaa", "aaSb"));

        productionRules.put('S', production_S);


        CFG cfg = new CFG(terminals,nonTerminals,startSymbol,productionRules);

        bw.write("4\n");
        cfg.solveProblem(br, bw);
    }
}