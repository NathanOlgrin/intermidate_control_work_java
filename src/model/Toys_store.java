package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Toys_store {

    private List<Toy> toys_store;
    private List<Toy> prize_toys;


    PriorityQueue queue = new PriorityQueue(Comparator.comparingInt(Toy::getWeight));

    public Toys_store() {
        toys_store = new ArrayList<>();
        prize_toys = new ArrayList<>();
    }


    public boolean add_toy(String text){
        String text_pars[] = text.split(" ");
        toys_store.add(new Toy(Integer.parseInt(text_pars[0]), text_pars[1], Integer.parseInt(text_pars[2])));
        return true;
    }

    private void sorted_toy(){
        for(Toy toy : toys_store){
            queue.add(toy);
        }
        toys_store.clear();
        while (!queue.isEmpty()){
            Toy toy = (Toy) queue.poll();
            toys_store.add(toy);
        }
    }


    private void get_prize(){
        for (Toy toy : prize_toys){
            String output = String.format("%d, %s, %d", toy.getId(), toy.getName(), toy.getWeight());
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))){
                writer.write(output);
                writer.newLine();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public boolean prize_draw(){
        sorted_toy();
        for(int i=0; i<10;i++){
            System.out.println("Flag-1 " + i);
            int random_number = 1 + (int)(Math.random()*100);
            System.out.println("rand = " + random_number);
            for (Toy toy : toys_store){
            if(random_number<toy.getWeight()*10){
                prize_toys.add(toy);
                System.out.println("Flag-2 " + i);
                System.out.println(toy.getName());
                break;
                } else if (toy == toys_store.get(toys_store.size() - 1)){
                prize_toys.add(toys_store.get(toys_store.size() - 1));
                System.out.println("Flag-3 " + i);
                System.out.println(toy.getName());
                break;
            }
            }
        }
        get_prize();
        return true;
    }
}
