package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */
public class Board extends JPanel {

    ArrayList<Row> rows = new ArrayList<>();
    final int numberOfRows = 10; //final means constant to save some RAM :)
    SecretColorList secretColorList; //declare secretColorList object

    private int activeRow;

    public Board() {
        secretColorList = new SecretColorList();

        System.out.println(Arrays.deepToString(secretColorList.secretColor));
        addRows();
        addLockGuess();
        activateNextRow();
        this.setLayout(new GridLayout(rows.size() + 1, 1));

    }

    private void addRows() {
        // Adding to arrayList
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(new Row());
        }

        // Adding to this (JPanel)
        for (Row r : rows) {
            this.add(r);
        }

        activeRow = rows.size() - 1;
    }

    private void activateNextRow() {
    //this method is run when you press the Lock my Guess-button

        //decrement activeRow if all pegs in ArrayList rows at position activeRow have been clicked on
        if (rows.get(activeRow).hasBeenClicked()) {
            activeRow--;
        }

        //deactivate previous row (make non-clickable)
        if (activeRow + 1 != rows.size()) {
            rows.get(activeRow + 1).setActive(false);
        }
        rows.get(activeRow).setActive(true); //activate next row (make clickable)
    }

    private void addLockGuess() {
        //adding Lock my Guess-button Board-Panel

        LockGuess lockGuess = new LockGuess(); //instantiating LockGuess-object
        lockGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!rows.get(activeRow).hasBeenClicked()) { //prompt player to click all buttons before locking a guess
                    JOptionPane.showMessageDialog(null, "you have to change all colors before you can lock your guess");
                } else {

                    // create ArrayList of decoder colors, get them from the check-method in secretColorList
                    ArrayList<Color> decoderColors = secretColorList.checkConditionsAndGetDecoders(rows.get(activeRow));
                    rows.get(activeRow).setDecoders(decoderColors); //set those colors

                    //call gameOver() when row counter reaches 0
                    if(activeRow == 0){
                        gameOver();
                    }
                    activateNextRow();
                }
            }
        });
        this.add(lockGuess);

    }

    private void gameOver(){
        JOptionPane.showMessageDialog(null, "You didn't manage to solve the game.\n The correct solution was: " + Arrays.asList(secretColorList.secretColor));
        System.exit(0);
    }


}
