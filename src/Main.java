
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashifur
 */
public class Main {

    public static void main(String[] args) {

        String[] paths = new String[4];
        File[] files = new File[4];
        boolean[] flags = new boolean[4];
        BufferedReader[] reader = new BufferedReader[4];
        Random random = new Random();
        int index;
        String line;

        String writePath = "C:\\Users\\Ashifur\\Desktop\\thesis\\op_spam_v1.4\\spamdata.txt";

        paths[0] = "C:\\Users\\Ashifur\\Desktop\\thesis\\op_spam_v1.4\\negative_polarity\\deceptive_from_MTurk\\data.txt";
        paths[1] = "C:\\Users\\Ashifur\\Desktop\\thesis\\op_spam_v1.4\\negative_polarity\\truthful_from_Web\\data.txt";
        paths[2] = "C:\\Users\\Ashifur\\Desktop\\thesis\\op_spam_v1.4\\positive_polarity\\deceptive_from_MTurk\\data.txt";
        paths[3] = "C:\\Users\\Ashifur\\Desktop\\thesis\\op_spam_v1.4\\positive_polarity\\truthful_from_TripAdvisor\\data.txt";

        files[0] = new File(paths[0]);
        files[1] = new File(paths[1]);
        files[2] = new File(paths[2]);
        files[3] = new File(paths[3]);

        flags[0] = true;
        flags[1] = true;
        flags[2] = true;
        flags[3] = true;

        FileWriter fileWriter;
        BufferedWriter writer;

        try {

            fileWriter = new FileWriter(writePath);
            writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < 4; i++) {

                reader[i] = new BufferedReader(new FileReader(files[i]));
            }

            try {

                while (flags[0] || flags[1] || flags[2] || flags[3]) {

                    index = random.nextInt(4);

                    if (flags[index]) {

                        if ((line = reader[index].readLine()) != null) {

                            writer.write(line + "\t" + (index % 2));
                            writer.newLine();
                            System.out.println(line + "\t" + (index % 2));
                        } else {

                            flags[index] = false;
                        }
                    }
                }
            } catch (IOException ex) {

                System.err.println("Problem In writting File");
            } finally {

                writer.close();
                fileWriter.close();

                for (int i = 0; i < 4; i++) {

                    reader[i].close();
                }
            }
        } catch (IOException ex) {

            System.err.println("Problem in opening writer");
        }
    }
}
