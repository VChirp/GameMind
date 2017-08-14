package com.gamemind;

import javax.swing.*;
import java.awt.*;

class InitialFormGUI {

    private int rows;
    private int columns;

    InitialFormGUI() {
        JFrame initialFrame = new JFrame("Kill all numbers");
        initialFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel labelWelcome = new JLabel("Welcome to KILL ALL NUMBERS!");
        JLabel infoLabel = new JLabel("Set rows and columns value!");
        JTextField rowEdit = new JTextField("");
        JTextField colEdit = new JTextField("");
        JButton startButton = new JButton("Start to KILL!");

        startButton.addActionListener(e -> {
            String rowsStr = rowEdit.getText();
            String columnsStr = colEdit.getText();

            if (isNumber(rowsStr) && isNumber(columnsStr)) {
                rows = Integer.parseInt(rowsStr);
                columns = Integer.parseInt(columnsStr);
                System.out.println(rows + " " + columns);
                if ((rows * columns) % 2 == 0) {
                    ArrayGenerator arrayGenerator = new ArrayGenerator(rows, columns);
                    GameLogic logic = new GameLogic(arrayGenerator);
                    new GameGui(logic, rows, columns);
                    initialFrame.setVisible(false);
                } else {
                    infoLabel.setText("Wrong rows or/and columns value");
                }
            } else {
                infoLabel.setText("Wrong type");
            }

        });

        initialFrame.add(labelWelcome);
        initialFrame.add(infoLabel);
        initialFrame.add(rowEdit);
        initialFrame.add(colEdit);
        initialFrame.add(startButton);
        initialFrame.setLayout(new GridLayout(5, 1));
        initialFrame.pack();
        initialFrame.setVisible(true);
    }

    private boolean isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
