package presenter;

import model.Toys_store;
import view.ConsoleUI;

public class Presenter {
    private ConsoleUI consoleUI;
    private Toys_store toys_store;

    public Presenter(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        toys_store = new Toys_store();
    }

    public boolean add(String s) {
        return toys_store.add_toy(s);
    }

    public boolean prize_draw() {
        return toys_store.prize_draw();
    }
}
