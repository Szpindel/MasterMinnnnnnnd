package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */
public class Peg extends JButton {


    private boolean hasBeenClicked;
    private int currentColorIndex;
    private Color currentColor;
    private boolean active;

    public Peg() {

        Dimension d = new Dimension(80, 80);
        this.setPreferredSize(d);
        this.getPreferredSize(); // Not needed
        this.setOpaque(true);
        this.setText("✖✖✖");
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleColor();
            }
        });


    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private void toggleColor() {
        // This method toggles the color shown, if the peg is active
        if (active) {
            hasBeenClicked = true;
            if (currentColorIndex == SecretColorList.getColorListSize()) {
                currentColorIndex = 0; //reset counter as soon as size of array is reached
            }
            currentColor = SecretColorList.getColor(currentColorIndex);
            this.setBackground(currentColor);
            this.setForeground(currentColor);
        }
        currentColorIndex++;
    }

    public boolean hasBeenClicked() {
        return hasBeenClicked;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}
