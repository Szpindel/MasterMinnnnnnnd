package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bruno floerke and nicos vachnadze on 17/11/15.
 */
public class SecretColorList {


    private static Color[] color = new Color[]{Color.GREEN, Color.YELLOW, Color.RED, Color.BLACK, Color.BLUE, Color.GRAY}; // Static so it's accessible throughout the code
    public Color[] secretColor = new Color[4];
    private Color[] guessedColors = new Color[4];


    public SecretColorList() {
        setRandomColors();

    }

    private void setRandomColors() {
        //iterating through secretColor[] and assigning random colors out of color[]

        for (int i = 0; i < secretColor.length; i++) {
            secretColor[i] = color[(int) (Math.random() * color.length)];
        }
    }


    private void assignGuessedColors(Row r) {
        // Adding current color of a peg to guessedColors[]

        for (int i = 0; i < r.getPegArray().length; i++) {
            guessedColors[i] = r.getPegArray()[i].getCurrentColor();

        }
    }


    public ArrayList<Color> checkConditionsAndGetDecoders(Row r) {
        boolean match[] = new boolean[4];
        ArrayList<Color> decoderColors = new ArrayList<>(); // ArrayList for colors to be returned by the method
        assignGuessedColors(r);

        //check for red condition (direct match)
        for (int i = 0; i < guessedColors.length; i++) {
                if (secretColor[i] == guessedColors[i]) { //red condition
                    decoderColors.add(Color.RED);
                    match[i] = true; //set match to true at this index
                    System.out.println("FOUND RED");
            }
        }

        //check for white condition (indirect match)
        //requires nested for-loop because it doesn't have to check for direct matches
        for (int i = 0; i < guessedColors.length; i++) {
            for (int j = 0; j < guessedColors.length; j++) {
                if (!match[i]) { //check only if there hasn't been a match at these indices already
                    if (secretColor[i] == guessedColors[j]) { //white condition
                        decoderColors.add(Color.WHITE);
                        match[i] = true; //set match to true at this index
//                        match[j] = true; //set match to true at this index
                        System.out.println("FOUND WHITE");
                    }
                }
            }
        }
        return decoderColors;
    }



    public static int getColorListSize() {
        return color.length;
    }

    public static java.awt.Color getColor(int index) {
        return color[index];
    }

}
