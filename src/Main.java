import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        PDAExec();
        CFGExec();
    }

    private static void PDAExec() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input_pda.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output_pda.txt"));

        String str = br.readLine();
        while (str != null) {
            switch (str) {
                case "1" -> new Problems.PDA.Problem1(br, bw);
                case "2" -> new Problems.PDA.Problem2(br, bw);
                case "3" -> new Problems.PDA.Problem3(br, bw);
                case "4" -> new Problems.PDA.Problem4(br, bw);
                case "5" -> new Problems.PDA.Problem5(br, bw);
            }
            str = br.readLine();
        }

        br.close();
        bw.close();
    }

    private static void CFGExec() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input_cfg.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output_cfg.txt"));

        String str = br.readLine();
        while (str != null) {
            switch (str) {
                case "1" -> new Problems.CFG.Problem1(br, bw);
                case "2" -> new Problems.CFG.Problem2(br, bw);
                case "3" -> new Problems.CFG.Problem3(br, bw);
                case "4" -> new Problems.CFG.Problem4(br, bw);
                case "5" -> new Problems.CFG.Problem5(br, bw);
                
            }
            str = br.readLine();
        }

        br.close();
        bw.close();
    }
}
