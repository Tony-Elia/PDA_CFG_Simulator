package Problems.CFG;

import Automata.CFG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5{
    ArrayList<Character> terminals = new ArrayList<>(Arrays.asList('a','b'));
    ArrayList<Character> nonTerminals = new ArrayList<>(Arrays.asList('S', 'T' ));
    Character startSymbol = 'S';
    Map<Character,ArrayList<String>> productionRules = new HashMap<>();

    public Problem5(BufferedReader br, BufferedWriter bw) throws IOException {
        ArrayList<String> production_S = new ArrayList<>(Arrays.asList("aS", "aT"));
        ArrayList<String> production_T = new ArrayList<>(Arrays.asList("aTb", CFG.EPSILON));
        productionRules.put('S', production_S);
        productionRules.put('T', production_T);

        CFG cfg = new CFG(terminals,nonTerminals,startSymbol,productionRules);

        bw.write("5\n");
        cfg.solveProblem(br, bw);
    }
}