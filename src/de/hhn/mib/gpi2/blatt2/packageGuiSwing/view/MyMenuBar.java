package de.hhn.mib.gpi2.blatt2.packageGuiSwing.view;

import de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n.I18n;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Class that initializes the components of the menu and adds action listeners
 */
public class MyMenuBar extends JMenuBar{

    private JMenu order;
    private JMenuItem saveOrderItem;
    private JMenuItem importOrderItem;
    private JMenu language;
    private JMenuItem englishItem;
    private JMenuItem germanItem;

    public MyMenuBar(){
       addComponents();
    }

    /**
     * Method that adds the JMenu's and JMenuItem's to the JMenuBar.
     * I18n.getMessage gets the key of the attributes which are used for the internationalization
     */
    private void addComponents(){
        order = new JMenu(I18n.getMessage("Bestellung"));
        saveOrderItem = new JMenuItem(I18n.getMessage("Bestellung_Speichern"));
        saveOrderItem.setMnemonic(KeyEvent.VK_S);
        importOrderItem = new JMenuItem(I18n.getMessage("Bestellung_Importieren"));
        importOrderItem.setMnemonic(KeyEvent.VK_I);
        order.add(saveOrderItem);
        order.add(importOrderItem);
        language = new JMenu(I18n.getMessage("Sprache"));
        englishItem = new JMenuItem("English");
        germanItem = new JMenuItem(I18n.getMessage("Deutsch"));
        language.add(englishItem);
        language.add(germanItem);

        this.add(order);
        this.add(language);
    }

    /**
     * Method that adds an actionListener to the saveOrderItem
     * @param actionListener
     */
    public void saveMenuAction(ActionListener actionListener){
        saveOrderItem.addActionListener(actionListener);
    }

    /**
     * Method that adds an actionListener to the importOrderItem
     * @param actionListener
     */
    public void importOrderAction(ActionListener actionListener){
        if(actionListener!=null){
            importOrderItem.addActionListener(actionListener);
        }
    }

    /**
     * Method that adds an actionListener to the englishItem
     * @param actionListener
     */
    public void englishAction(ActionListener actionListener){
        if(actionListener!=null){
            englishItem.addActionListener(actionListener);
        }
    }



}
