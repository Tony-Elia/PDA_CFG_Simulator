package Problems.CFG;

import Automata.CFG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    ArrayList<Character> terminals = new ArrayList<>(Arrays.asList('a','b'));
    ArrayList<Character> nonTerminals = new ArrayList<>(Arrays.asList('S', 'A' , 'B'));
    Character startSymbol = 'S';
    Map<Character,ArrayList<String>> productionRules = new HashMap<>();

    public Problem3(BufferedReader br, BufferedWriter bw) throws IOException {
        ArrayList<String> production_S = new ArrayList<>(Arrays.asList("aA", "bB"));
        ArrayList<String> production_A = new ArrayList<>(Arrays.asList("aA", "bB" , "a", "b"));
        ArrayList<String> production_B = new ArrayList<>(Arrays.asList("bB", "aA" , "a", "b"));
        productionRules.put('S', production_S);
        productionRules.put('A', production_A);
        productionRules.put('B', production_B);

        CFG cfg = new CFG(terminals,nonTerminals,startSymbol,productionRules);

        bw.write("3\n");
        cfg.solveProblem(br, bw);
    }
}
