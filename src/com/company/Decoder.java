package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */
public class Decoder extends JButton {

    public Decoder() {
        Dimension d = new Dimension(16, 80);
        this.setPreferredSize(d);
        this.getPreferredSize();
        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setBorderPainted(false);
    }


    public void setColor(Color c) {
        this.setBackground(c);
    }

}

