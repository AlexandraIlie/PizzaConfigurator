package de.hhn.mib.gpi2.blatt2.packageGuiSwing.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  Class that takes count of the orders
 */
public class Order {

    private long orderId = 1;
    private List<Pizza> pizzas;
    private Date date;
    private Date time;

    public Order(){
        pizzas = new ArrayList<>();
    }

    public long getOrderId() {
        return orderId;
    }

    public void addPizza(Pizza pizza){ pizzas.add(pizza);}

    public List<Pizza> getPizzas(){ return pizzas;}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", pizzas=" + pizzas +
                '}';
    }

}
