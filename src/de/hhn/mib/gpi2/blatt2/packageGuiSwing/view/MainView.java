package de.hhn.mib.gpi2.blatt2.packageGuiSwing.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class that adds the PizzaConfigPanel to the frame
 */
public class MainView extends JFrame {

    private PizzaConfigPanel pizzaConfigPanel;

    public MainView(PizzaConfigPanel pizzaConfigPanel){
        super("Pizza Konfigurator");
        this.setLayout(new BorderLayout());
        this.pizzaConfigPanel=pizzaConfigPanel;
        addComponents();
    }

    /**
     * Method that adds the components to the frame
     */
    private void addComponents() {
        this.add(pizzaConfigPanel, BorderLayout.CENTER);
    }

    public PizzaConfigPanel getPizzaConfigPanel() {
        return pizzaConfigPanel;
    }


}
