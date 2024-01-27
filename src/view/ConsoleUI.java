package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;

    private boolean check;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        check = true;

    }

    public void start(){
        System.out.println("Приветствие");
        while (check){
            printMenu();
            check = choice();
        }
    }

    private void printMenu(){
        System.out.println("1. Положить игрушку в магазин для розыгрыша\n" +
                "2. Произвести розыгрыш игрушек (для розыгрыша необходимо не менее 3-х игрушек\n" +
                "3. Выйти из приложения");
    }

    private boolean choice(){
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);

        switch (choice) {
            case 1:
                System.out.println("Введите через пробел данные игрушки: порядковый номер, имя, вес");
                if(presenter.add(scanner.nextLine())){
                    System.out.println("Успешно!");
                }
                return true;
            case 2:
                if(presenter.prize_draw()){
                    System.out.println("Успешно! Данные выведены в файл.");
                }
                return true;
            case 3:
                System.out.println("До свидания!");
                return false;
        }
        return false;
    }
}
