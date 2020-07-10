package de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions;

/**
 *  Class that creates an exception for a file with an invalid extension
 */
public class InvalidFileExtensionException extends Exception{

    public InvalidFileExtensionException(){
        super("Falsche Art der Datei");
    }
}
