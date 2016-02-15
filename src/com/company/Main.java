package com.company;

import javax.swing.*;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */

public class Main {


    public static void main(String[] args) {

        JFrame frame = new JFrame();

        Board board = new Board();
        frame.add(board);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
