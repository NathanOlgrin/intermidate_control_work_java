import model.Toys_store;

public class Main {
    public static void main(String[] args) {
        Toys_store store = new Toys_store();
        System.out.println(store.add_toy("1 Bear 3"));
        System.out.println(store.add_toy("2 Lego 5"));
        System.out.println(store.add_toy("3 Rabbit 1"));

        System.out.println(store.prize_draw());
    }
}