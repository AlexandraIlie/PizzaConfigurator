package de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions;

/**
 *  Class that creates an exception for not selecting a topping
 */
public class NoToppingSelectedException extends Exception{
    public NoToppingSelectedException(){
        super("Fehler: Kein Belag ausgewählt");
    }
}
