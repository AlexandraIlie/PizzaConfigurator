package de.hhn.mib.gpi2.blatt2.packageGuiSwing.test;


import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Order;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Pizza;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.PizzaSize;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.PizzaTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

   private Order order = new Order();
   private Pizza pizza;
   private Random random;

   @BeforeEach
   public void createPizza(){
       PizzaSize size = PizzaSize.SMALL;

       List<PizzaTopping> toppings = new ArrayList<PizzaTopping>();

       toppings.add(PizzaTopping.SALAMI);
       toppings.add(PizzaTopping.HAM);

       pizza = new Pizza(size,toppings);

       assertEquals(5,pizza.getPrice());

   }

   @Test
   public void getOrderId(){
       assertEquals(1,order.getOrderId());
   }

   @Test
    public void setDate(){

   }


}
