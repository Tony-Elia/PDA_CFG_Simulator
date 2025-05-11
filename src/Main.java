import java.io.*;
import Problems.PDA.Problem1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input_pda.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output_pda.txt"));

        String str = br.readLine();
        while (str != null) {
            switch (str) {
                case "1" -> new Problem1(br, bw);
            }
            str = br.readLine();
        }

        br.close(); bw.close();
    }
}