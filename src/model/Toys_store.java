package model;

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


    public int get_toys_Id(Toy toy){
        int current_id = 0;
        for(int i = 0; i<toys_store.size();i++){
            if(toy == toys_store.get(i)){
                current_id = i;
                break;
            }
        }
        return current_id-1;
    }

    public boolean prize_draw(){
        sorted_toy();
        for(int i=0; i<10;i++){
            int random_number = 1 + (int)(Math.random()*100);
            for (Toy toy : toys_store){
                if(toy!=toys_store.get(0) && toy!=toys_store.get(toys_store.size()-1)){
                    if(toy.getWeight()!=toys_store.get(get_toys_Id(toy)).getWeight()){
                        if(random_number<toy.getWeight()*10) {
                            prize_toys.add(toy);
                            break;
                        }
                    } else {
                        if(random_number<(toy.getWeight()+toys_store.get(get_toys_Id(toy)).getWeight())*10){
                            prize_toys.add(toy);
                            break;
                        }
                    }
                } else {
                    if(random_number<toy.getWeight()*10){
                        prize_toys.add(toy);
                        break;
                    } else if (toy == toys_store.get(toys_store.size() - 1)){
                        prize_toys.add(toys_store.get(toys_store.size() - 1));
                        break;
                    }
                }
            }
        }
        Get_to_file.get_prize(prize_toys);
        return true;
    }
}