package de.hhn.mib.gpi2.blatt2.packageGuiSwing.controller;

import de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n.I18n;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions.InvalidFileExtensionException;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions.NoToppingSelectedException;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Order;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.Pizza;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.view.MainView;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.view.MyMenuBar;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.view.PizzaConfigPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Locale;


/**
 * Class that sets the properties of the MainView class and the actions of the JMenuBar components
 */
public class MainViewController {

    private MainView mainView;
    private MyMenuBar menuBar;
    private JFileChooser fileChooser;
    private File fileToSave;
    private PizzaConfigPanel pizzaConfigPanel;
    private Order order;

    public MainViewController() {
        pizzaConfigPanel = new PizzaConfigPanel();
        order = new Order();
        mainView = new MainView(pizzaConfigPanel);
        menuBar = new MyMenuBar();
        mainView.setJMenuBar(menuBar);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.setMinimumSize(new Dimension(600, 600));
        mainView.setVisible(true);
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt und .csv", "csv", "txt"));
        setActions();
    }

    /**
     * Sets the actions of components of the MyMenuBar Class
     */
    private void setActions() {
        menuBar.saveMenuAction(e -> {
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                fileToSave = fileChooser.getSelectedFile();
                try {
                    checkExtension(fileToSave);
                    Pizza pizza = new Pizza(pizzaConfigPanel.getSelectedSize(), pizzaConfigPanel.getSelectedToppings());
                    order.addPizza(pizza);
                    writeOrder(fileChooser.getSelectedFile().toString());
                    JOptionPane.showConfirmDialog(null, order.toString(), "Die Bestellung wurde gespeichert", JOptionPane.PLAIN_MESSAGE);
                }
               catch(FileNotFoundException e0)
                {
                    e0.printStackTrace();
                } catch (InvalidFileExtensionException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (NoToppingSelectedException noToppingSelectedException) {
                    noToppingSelectedException.printStackTrace();
                }
            }
        });
        menuBar.importOrderAction(e -> {
            int returnVal = fileChooser.showOpenDialog(null);
            if(returnVal == fileChooser.APPROVE_OPTION)
            {
                try{
                    String bestellung = readOrder(fileChooser.getSelectedFile().toString());
                    JOptionPane.showConfirmDialog(null, bestellung, "Ihre Bestellung", JOptionPane.PLAIN_MESSAGE);
                }
                catch(IOException e2)
                {
                    e2.printStackTrace();
                    JOptionPane.showConfirmDialog(null, e2.getMessage(), "", JOptionPane.WARNING_MESSAGE);
                }
                catch(NullPointerException e3)
                {
                    e3.printStackTrace();
                    JOptionPane.showConfirmDialog(null, e3.getMessage(), "", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        menuBar.englishAction(e->{
            I18n.setLocale(new Locale("en"));
            mainView.dispose();
            new MainViewController();
        });
    }

    /**
     * Method that checks the extension of the selected file
     * @param file
     * @throws InvalidFileExtensionException thrown if the selected file does not match the required extension
     */
    private void checkExtension(File file) throws InvalidFileExtensionException {
        String extension = "csv";
        if (!extension.equals(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1))){
            JOptionPane.showMessageDialog(null,"Bitte fügen Sie dem Dateinamen die Erweiterung .csv oder .txt hinzu");
            throw new InvalidFileExtensionException();
        }
    }

    /**
     * Method that writes the order into a file
     * @param filePath
     * @throws IOException
     */
    public void writeOrder(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filePath));) {
            writer.write(String.valueOf(order.getOrderId()));
            List<Pizza> pizzas = order.getPizzas();
            for (int i = 0; i < pizzas.size(); i++) {
                writer.append(",");
                writer.write(String.valueOf(pizzas.get(i)));
                writer.newLine();
            }
        }
    }

    /**
     * Method that reads the order from the file
     * @param filePath
     * @return bestellung
     * @throws IOException
     */
    public String readOrder(String filePath) throws IOException {
        String bestellung =" ";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));)
        {
            String l;
            while ((l = reader.readLine()) != null) {
                bestellung  =  bestellung + l;
            }
        }
        return bestellung;
    }
}
