package de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions;

import javax.swing.*;

/**
 *  Class that creates an exception for an invalid date
 */
public class InvalidDateException extends Exception{
    public InvalidDateException(String message){
        super(message);
        JOptionPane.showConfirmDialog(null,  "Ungültiges Datum", "ERROR", JOptionPane.PLAIN_MESSAGE);
    }
}
