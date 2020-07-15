package de.hhn.mib.gpi2.blatt2.packageGuiSwing.controller;

import de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions.InvalidDateException;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions.NoToppingSelectedException;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Order;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Pizza;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.view.PizzaConfigPanel;
import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Class that sets the properties of the PizzaConfigPanel class,the actions of its components and creates a new Order.
 */
public class PizzaConfigPanelController {
    PizzaConfigPanel pizzaConfigPanel;
    private Pizza pizza;
    private Order order;

    public PizzaConfigPanelController(PizzaConfigPanel pizzaConfigPanel) {
        this.pizzaConfigPanel = pizzaConfigPanel;
        order = new Order();
        setActions();
    }

    /**
     * Sets the actions of components of the PizzaConfigPanel Class. Creates an object of type Pizza and Order.
     */
    private void setActions() {
        pizzaConfigPanel.doneButtonAction(e -> {
            try {
                checkDateTime();
                pizza = new Pizza(pizzaConfigPanel.getSelectedSize(), pizzaConfigPanel.getSelectedToppings());
                int confirm = JOptionPane.showConfirmDialog(pizzaConfigPanel, "Preis: " + pizza.getPrice() + " Cent. Wollen Sie die Pizza bestellen?", "Bestellung bestätigen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    order.addPizza(pizza);
                }
            } catch (NoToppingSelectedException ntse) {
                JOptionPane.showMessageDialog(pizzaConfigPanel, "Sie muessen mindestens einen Belag auswählen!", "Kein Belag ausgewählt", JOptionPane.WARNING_MESSAGE);
            } catch (InvalidDateException e1) {
                e1.printStackTrace();
            }
        });
        pizzaConfigPanel.cancelButtonAction(e->{
            System.exit(1); }
        );
    }

    /**
     * Method that checks if the date and time are set not to be 4 weeks in the future.
     * @throws InvalidDateException
     */
    private void checkDateTime() throws InvalidDateException {
        Date date1 = null;
        Date date2 = null;
        Date time = null;

        DateFormat formatDate = new SimpleDateFormat("dd.MM.yy");
        DateFormat formatTime = new SimpleDateFormat("HH:mm");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        try {
            date1 = formatDate.parse(pizzaConfigPanel.dateTextFieldAction());
            date2 = formatDate.parse(currentDate);
            time = formatTime.parse(pizzaConfigPanel.timeTextFieldAction());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calCurrent = Calendar.getInstance();
        System.out.println("aktuelles Datum: " + calCurrent.getTime());
        calCurrent.add(Calendar.DATE, 28);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        if(date1.before(date2) || cal.getTime().after(calCurrent.getTime()))
        {throw new InvalidDateException(("Ungültiges Datum")); }
        else
        {
            order.setDate(date1);
            order.setTime(time);
        }
    }
}
