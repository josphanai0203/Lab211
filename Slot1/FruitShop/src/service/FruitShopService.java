package service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import model.Customer;
import model.Fruit;
import model.Order;

public class FruitShopService {

    private static Hashtable<String, Order> orderList = new Hashtable<>();
    private static ArrayList<Fruit> fruits = new ArrayList<>();
    private static Order currentCustomer;
    static {
        fruits.add(new Fruit("Coconut",2,10,"Vietnam"));
        fruits.add(new Fruit("Orange",3,10,"US"));
        fruits.add(new Fruit("Apple",4,10,"Thailand"));
        fruits.add(new Fruit("Grape",6,10,"France"));
    }

    public int getTotalFruits() {
        return fruits.size();
    }

    public void addFruit(Fruit f) {
        fruits.add(f);
    }

    public void displayAllFruits() {
        displayListFruit(fruits);
    }

    public void displayListFruit(ArrayList<Fruit> l) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Quantity","Price");
        for (Fruit fruit : l) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-20d%.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(),fruit.getQuantity(), fruit.getPrice());
            }
        }
    }

    public void viewOrder(ArrayList<Fruit> l) {
        
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : l) {
            System.out.printf("%-10s%-20d%-20.2f%.2f$\n",fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
        }
    }

    public void viewOrders() {
        for (String customerName : orderList.keySet()) {
            System.out.println("Customer: " + customerName);
            Order order = orderList.get(customerName);
            viewOrder(order.getFruits());
            System.out.println("Total: " + order.getTotal() + "$");
        }
    }

    public Fruit getFruitById(int id) {
        return fruits.get(id - 1);
    }

    public void doCreateOrUpdateOrder(int idFruit, int quantityBuyed) {
        Fruit f = getFruitById(idFruit);
        f.setQuantity(f.getQuantity() - quantityBuyed);
        double total = quantityBuyed * f.getQuantity();
        Fruit newFruit = new Fruit(f.getFruitName(),f.getPrice(),f.getQuantity(),f.getOrigin());
        currentCustomer.getFruits().add(newFruit);
        System.out.println(currentCustomer.getFruits().size());
        currentCustomer.setTotal(currentCustomer.getTotal() + total);

    }

    public void createShoppingSession() {
        currentCustomer = new Order();

    }

    public void finishShoppingSession(String customerName) {
        currentCustomer.getCustomer().setName(customerName);
        orderList.put(customerName, currentCustomer);
        currentCustomer = null;
    }
    public void viewCurrentOrder(){
        viewOrder(currentCustomer.getFruits());
         System.out.println("Total: " + currentCustomer.getTotal() + "$");
    }
}
