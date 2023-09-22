package controller;

import java.util.ArrayList;
import model.Fruit;
import service.FruitShopService;
import util.Library;
import view.Menu;

public class FruitShopManager extends Menu<String> {

    static String[] menuChoice = {"Create Fruit", "View orders", "Shopping (for buyer)", "Exit"};

    protected Library library;
    protected FruitShopService service;

    public FruitShopManager() {
        super("Student Manager", menuChoice);
        library = new Library();
        service = new FruitShopService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                createNewFruit();
                break;
            case 2:
                viewOrderList();
                break;
            case 3:
                doShopping();
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    public void createNewFruit() {

        String fruitName = library.getString("Enter Fruit Name");
        double price = library.getDouble("Enter price");
        int quantity = library.getInt("Enter quantity");
        String origin = library.getString("Enter fruit origin");
        Fruit f = new Fruit(fruitName, price, quantity, origin);
        service.addFruit(f);
        boolean check = library.checkInputYN();
        if (check) {
            createNewFruit();
        } else {
            service.displayAllFruits();
        }

    }

    public void viewOrderList() {
        service.viewOrders();
    }

    public void doShopping() {
        boolean check = true;
        service.createShoppingSession();
        do {
            service.displayAllFruits();
            int select = library.getInt("Enter Item Number", 0, service.getTotalFruits());
            System.out.println("You selected:" + service.getFruitById(select).getFruitName());
            int quantity = library.getInt("Please input quantity:", 1, service.getFruitById(select).getQuantity());
            service.doCreateOrUpdateOrder(select, quantity);
            check = library.checkInputYN();
            if (!check) {
                service.viewCurrentOrder();
                String name = library.getString("Input your name");
                service.finishShoppingSession(name);
            }
        } while (check);

    }

}
