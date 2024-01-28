package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Get_to_file {
    public static void get_prize(List<Toy> prize_toys){
        for (Toy toy : prize_toys){
            String output = String.format("%d", toy.getId());
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))){
                writer.write(output);
                writer.newLine();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
