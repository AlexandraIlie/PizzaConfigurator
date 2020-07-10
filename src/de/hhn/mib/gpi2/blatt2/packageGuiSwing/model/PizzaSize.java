package de.hhn.mib.gpi2.blatt2.packageGuiSwing.model;

/**
 * Enum with the sizes and their prices that an object Pizza can have
 */
public enum PizzaSize {

    SMALL("Klein",4),
    MEDIUM("Mittel",5),
    LARGE("Gross",7),
    EXTRA_LARGE("Riessig",10);

    PizzaSize(String size, int pizzaSizePrice) {
        this.size = size;
        this.pizzaSizePrice = pizzaSizePrice;
    }

    private String size;

    private int pizzaSizePrice;

    public int getSizePrice() {
        return pizzaSizePrice;
    }


    @Override
    public String toString() {
        return size;
    }

}
