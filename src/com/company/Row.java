package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */
public class Row extends JPanel {


    private Peg[] pegArray = new Peg[4];
    private Decoder[] decoderArray = new Decoder[4];

    public Row() {

        // add pegs to pegsArray, row to panel
        for (int i = 0; i < pegArray.length; i++) {
            pegArray[i] = new Peg();
            this.add(pegArray[i]);
        }


        //adding decoders to decoderArray, row to panel
        for (int i = 0; i < decoderArray.length; i++) {
            decoderArray[i] = new Decoder();
            this.add(decoderArray[i]);
        }
    }


    public void setActive(boolean b) {
        //This method sets the active state b for each peg in the pegArray
        for (int i = 0; i < pegArray.length; i++) {
            pegArray[i].setActive(b);
        }
    }

    public boolean hasBeenClicked() {
        //this method checks whether all pegs in a row have been clicked, returning true only if all pegs have been clicked
        //gets toggled in toggleColor(), is used in activateRow()

        for (Peg aPegArray : pegArray) {
            if (!aPegArray.hasBeenClicked()) {
                return false;
            }
        }
        return true;
    }

    public void setDecoders(ArrayList<Color> decoderColors) {
        //change the background on decoders and check whether player has won

        int redCounter = 0;
        int i = 0;

        for (Color c : decoderColors) {
            if (c == Color.RED) {
                redCounter++;
            }
            decoderArray[i].setColor(c);
            i++;
        }

        if (redCounter == 4) {
            JOptionPane.showMessageDialog(null, "Congrats, you won :)");
            System.exit(0);
        }
    }

    public Peg[] getPegArray() {
        return pegArray;
    }
}