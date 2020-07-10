package de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class that creates a ResourceBundle for internationalization
 */
public class I18n {
    private static ResourceBundle bundle = ResourceBundle.getBundle("de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n.MessagesBundle.ProjectBundle", new Locale("de"));
    public I18n() {

    }

    /**
     * Class that sets the locale of the bundle attribute
     * @param locale
     */
    public static void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle("de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n.MessagesBundle.ProjectBundle", locale);
    }

    /**
     * Method that gets the key of the bundle and casts it as a String
     * @param key
     * @return bundle.getString(key)
     */
    public static String getMessage(String key) {
        return bundle.getString(key);
    }


}
