
package model;

import java.util.ArrayList;

public class Order {
    private Customer customer;
    private ArrayList<Fruit> fruits;
    private double total;

    public Order() {
       customer = new Customer();
       fruits = new ArrayList<>();
       total = 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
