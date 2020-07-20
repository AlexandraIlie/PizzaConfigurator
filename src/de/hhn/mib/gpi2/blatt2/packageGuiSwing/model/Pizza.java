package de.hhn.mib.gpi2.blatt2.packageGuiSwing.model;

import java.util.List;

/**
 * Class that creates an object of type Pizza
 *
 */
public class Pizza {

    private double price = 1;
    private PizzaSize size;
    private List<PizzaTopping> toppings;


    public Pizza(PizzaSize size, List<PizzaTopping> toppings) {
       this.size = size;
       this.toppings = toppings;
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<PizzaTopping> getToppings() {
        return toppings;
    }

    /**
     * Method that calculates the price of a Pizza
     * @return price
     */
    public double getPrice(){
        price = toppings.size()*PizzaTopping.TOMATE.getToppingValue()+size.getSizePrice();
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                ", size=" + size +
                ", toppings=" + toppings +
                '}';
    }


}
