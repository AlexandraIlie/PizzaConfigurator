package de.hhn.mib.gpi2.blatt2.packageGuiSwing.view;

import de.hhn.mib.gpi2.blatt2.packageGuiSwing.I18n.I18n;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.exceptions.NoToppingSelectedException;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.PizzaSize;
import de.hhn.mib.gpi2.blatt2.packageGuiSwing.model.PizzaTopping;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Class that initializes the components and adds them to the JPanel
 */
public class PizzaConfigPanel extends JPanel implements ActionListener, ItemListener {

    private JLabel sizeLabel;
    private JLabel toppingLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JComboBox<PizzaSize> sizeComboBox;
    private JRadioButton tomatoButton;
    private JRadioButton cheeseButton;
    private JRadioButton salamiButton;
    private JRadioButton hamButton;
    private JRadioButton pineappleButton;
    private JRadioButton vegetableButton;
    private JRadioButton seafoodButton;
    private JRadioButton nutellaButton;
    private JRadioButton sourCreamButton;
    private JButton doneButton;
    private JButton cancelButton;
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private BufferedImage bufferedImage;
    private JFormattedTextField dateTextField;
    private JFormattedTextField timeTextField;
    private List<String> pizzaToppings=new ArrayList<>();

    public PizzaConfigPanel() {
        this.setLayout(new GridBagLayout());
        initComponents();
        addComponents();
        addListeners();
    }

    public void addListeners() {
        tomatoButton.addItemListener(this);
        cheeseButton.addItemListener(this);
        salamiButton.addItemListener(this);
        hamButton.addItemListener(this);
        pineappleButton.addItemListener(this);
        vegetableButton.addItemListener(this);
        seafoodButton.addItemListener(this);
        nutellaButton.addItemListener(this);
        sourCreamButton.addItemListener(this);
    }


    /**
     * Method that initializes the components
     */
    public void initComponents(){
        sizeLabel = new JLabel(I18n.getMessage("Groesse"));
        sizeComboBox = new JComboBox<>(PizzaSize.values());
        toppingLabel = new JLabel(I18n.getMessage("Belag"));
        tomatoButton = new JRadioButton(I18n.getMessage(PizzaTopping.TOMATO.toString()));
        cheeseButton = new JRadioButton(I18n.getMessage(PizzaTopping.CHEESE.toString()));
        salamiButton = new JRadioButton(PizzaTopping.SALAMI.toString());
        hamButton = new JRadioButton(I18n.getMessage(PizzaTopping.HAM.toString()));
        pineappleButton = new JRadioButton(I18n.getMessage(PizzaTopping.PINEAPPLE.toString()));
        vegetableButton = new JRadioButton(I18n.getMessage(PizzaTopping.VEGETABLES.toString()));
        seafoodButton = new JRadioButton(I18n.getMessage(PizzaTopping.SEAFOOD.toString()));
        nutellaButton = new JRadioButton(PizzaTopping.NUTELLA.toString());
        sourCreamButton = new JRadioButton(PizzaTopping.SOUR_CREAM.toString());
        doneButton = new JButton(I18n.getMessage("Fertig"));
        cancelButton = new JButton(I18n.getMessage("Abbrechen"));
        buttonPanel = new JPanel();
        buttonPanel.add(doneButton);
        buttonPanel.add(cancelButton);
        imagePanel = new JPanel();
        imagePanel.add(new JLabel(new ImageIcon(readImage())));
        dateLabel = new JLabel(I18n.getMessage("Datum"));
        timeLabel = new JLabel(I18n.getMessage("Zeit"));
        dateTextField = new JFormattedTextField();
        timeTextField = new JFormattedTextField();
    }

    /**
     * Method that adds the components to specific positions in the panel, using the Utility.makegbc class
     */
    public void addComponents(){
        int row = 0;
        this.add(dateLabel,Utility.makegbc(0, row, 1, 1));
        this.add(dateTextField, Utility.makegbc(1, row, 1, 1));
        this.add(timeLabel,Utility.makegbc(2, row, 1, 1));
        dateTextField.setPreferredSize( new Dimension( 100, 20 ) );
        timeTextField.setPreferredSize(new Dimension( 50, 20 ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 2;
        gbc.gridy = row++;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 40, 0, 0);
        this.add(timeTextField, gbc);
        this.add(sizeLabel, Utility.makegbc(0, row, 1, 1));
        this.add(sizeComboBox, Utility.makegbc(1, row++, 1, 1));
        this.add(toppingLabel, Utility.makegbc(0, row, 1, 1));
        this.add(imagePanel,Utility.makegbc(2,row,5,5));
        this.add(tomatoButton, Utility.makegbc(1, row++, 1, 1));
        this.add(cheeseButton, Utility.makegbc(1, row++, 1, 1));
        this.add(salamiButton, Utility.makegbc(1, row++, 1, 1));
        this.add(hamButton, Utility.makegbc(1, row++, 1, 1));
        this.add(pineappleButton, Utility.makegbc(1, row++, 1, 1));
        this.add(vegetableButton, Utility.makegbc(1, row++, 1, 1));
        this.add(seafoodButton, Utility.makegbc(1, row++, 1, 1));
        this.add(nutellaButton, Utility.makegbc(1, row++, 1, 1));
        this.add(sourCreamButton, Utility.makegbc(1, row++, 1, 1));
        this.add(buttonPanel,Utility.makegbc(2,row++,1,1));
    }

    /**
     * Method that reads the image from a specific file and draws it
     * @return bufferedImage the default image of the panel
     */
    public BufferedImage readImage(){
        try {
            bufferedImage = ImageIO.read(new File("src/images/pizzaboden.png"));
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(bufferedImage, 0, 0, null);
            g.dispose();

        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file ");
        }
        return bufferedImage;
    }

    /**
     * Gets the selected element from the ComboBox and returns it as a PizzaSize type
     * @return (PizzaSize) sizeComboBox.getSelectedItem()
     */
    public PizzaSize getSelectedSize(){
        return (PizzaSize) sizeComboBox.getSelectedItem();
    }


    /**
     * Checks which of the JRadioButtons is selected and add the selected ones to a list of PizzaTopping type
     * @return toppingList the list with all the desired toppings for the Pizza
     * @throws NoToppingSelectedException exception thrown when no topping is selected
     */
    public List<PizzaTopping> getSelectedToppings() throws NoToppingSelectedException {
        List<PizzaTopping> toppingList = new ArrayList<>();
        if (tomatoButton.isSelected()) {
            toppingList.add(PizzaTopping.TOMATO);
        }
        if (cheeseButton.isSelected()) {
            toppingList.add(PizzaTopping.CHEESE);
        }
        if (salamiButton.isSelected()) {
            toppingList.add(PizzaTopping.SALAMI);
        }
        if (hamButton.isSelected()) {
            toppingList.add(PizzaTopping.HAM);
        }
        if (pineappleButton.isSelected()) {
            toppingList.add(PizzaTopping.PINEAPPLE);
        }
        if (vegetableButton.isSelected()) {
            toppingList.add(PizzaTopping.VEGETABLES);
        }
        if (seafoodButton.isSelected()) {
            toppingList.add(PizzaTopping.SEAFOOD);
        }
        if (nutellaButton.isSelected()) {
            toppingList.add(PizzaTopping.NUTELLA);
        }
        if (sourCreamButton.isSelected()) {
            toppingList.add(PizzaTopping.SOUR_CREAM);
        }
        if(toppingList.isEmpty()){
            throw new NoToppingSelectedException();
        }
        return toppingList;
    }

    /**
     * Method that adds an actionListener to the doneButton
     * @param actionListener
     */
    public void doneButtonAction(ActionListener actionListener){
        if(actionListener!=null){
            doneButton.addActionListener(actionListener);
        }
    }

    /**
     * Method that adds an actionListener to the cancelButton
     * @param actionListener
     */
    public void cancelButtonAction(ActionListener actionListener){
        if(actionListener!=null){
            cancelButton.addActionListener(actionListener);
        }
    }

    /**
     * Method that takes the written date from the field and returns it as a String
     * @return dateTextField.getText()
     */
    public String dateTextFieldAction(){
        return dateTextField.getText();
    }

    /**
     * Method that takes the written time from the field and returns it as a String
     * @return timeTextField.getText()
     */
    public String timeTextFieldAction(){
        return timeTextField.getText();
    }

    /**
     *  Simple Method(Just for German Language) that repaints the default picture by adding the selected toppings on it
     * @param e represents the selected JRadioButton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Graphics2D g = bufferedImage.createGraphics();
        JRadioButton btn = (JRadioButton) e.getSource();
        String path="src/images/" + btn.getText() + ".png";
        BufferedImage fgImage = null;
        try {
            fgImage = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        g.drawImage(fgImage, 0, 0, null);
        repaint();
        g.dispose();*/
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        JRadioButton btn = (JRadioButton) itemEvent.getSource();

        //g.dispose();

        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            pizzaToppings.add(btn.getText());

            ImageIcon icon = new ImageIcon("src/images/" + btn.getText() + ".png");
            JLabel label = new JLabel( icon );


            //imagePanel.add(new JLabel(new ImageIcon(readImage())));

            /*Graphics2D g = bufferedImage.createGraphics();
            String path="src/images/" + btn.getText() + ".png";
            BufferedImage fgImage = null;
            try {
                fgImage = ImageIO.read(new File(path));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(fgImage, 0, 0, null);
            repaint();
            g.dispose();*/

        }
        else if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
            pizzaToppings.remove(btn.getText());

        }

       /* Graphics2D g = bufferedImage.createGraphics();
        String path = null;
        BufferedImage fgImage = null;
        for(int i=0; i < pizzaToppings.size() ; i++){
            path="src/images/" + pizzaToppings.get(i) + ".png";
            try {
                fgImage = ImageIO.read(new File(path));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(fgImage, 0, 0, null);

        }repaint();
        g.dispose();*/
    }

}
