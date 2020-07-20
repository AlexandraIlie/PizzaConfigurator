package de.hhn.mib.gpi2.blatt2.packageGuiSwing.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum with the toppings and their prices that an object Pizza can have
 */
public enum PizzaTopping {

    TOMATE("Tomate",0.5),
    CHEESE("Kaese",0.5),
    SALAMI("Salami",0.5),
    HAM("Schinken",0.5),
    PINEAPPLE("Ananas",0.5),
    VEGETABLES("Gemuese",0.5),
    SEAFOOD("Meeresfruechte",0.5),
    NUTELLA("Nutella",0.5),
    SOUR_CREAM("SourCream",0.5);

    private String topping;
    private double toppingValue;

    PizzaTopping(String topping, double toppingValue) {
        this.topping = topping;
        this.toppingValue = toppingValue;
    }

    public double getToppingValue() {
        return toppingValue;
    }

    public String getTopping() {
        return topping;
    }

    @Override
    public String toString() {
        return topping;
    }

    public  String getToppingName(String name) {
        for (PizzaTopping t : PizzaTopping.values()) {
            if (t.topping.equalsIgnoreCase(name)) {
                return t.name();
            }
        }
        return null;
    }

    
}
