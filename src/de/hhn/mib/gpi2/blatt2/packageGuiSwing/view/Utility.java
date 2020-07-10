package de.hhn.mib.gpi2.blatt2.packageGuiSwing.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Class that sets the coordinates for the components to be placed
 */
public class Utility {
    /**
     * Method that uses a GridBagConstraints for placing the components in the panel
     * @param x the column
     * @param y the row
     * @param width
     * @param height
     * @return gbc the GridBagConstraints object with it's resulting coordinates
     */
    static public GridBagConstraints makegbc(int x, int y, int width,
                                             int height) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }
}

