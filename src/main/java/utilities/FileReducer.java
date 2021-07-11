package utilities;

import java.io.*;

public class FileReducer {

    public static void main(String[] args) {

        String filename = "D:\\DiceMonastery\\DM_EI_15s_A002_Q.txt";
        String output = "D:\\DiceMonastery\\DM_EI_15s_A002_Q_V100.txt";
        int visitThreshold = 100;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));

            writer.write(reader.readLine() +"\n"); // header

            while (reader.ready()) {
                String line = reader.readLine();
                String[] details = line.split("\\t");
                // action visits is 5th, N is 6th
                int N = Integer.parseInt(details[5]);
                if (N >= visitThreshold)
                    writer.write(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
