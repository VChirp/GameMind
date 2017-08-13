package com.gamemind;

import javax.swing.*;
import java.awt.*;

class InitialFormGUI {

    private int rows;
    private int columns;

    InitialFormGUI() {
        createInitialForm();
    }

    private void createInitialForm() {
        JFrame initialFrame = new JFrame("Kill all numbers");
        initialFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Welcome to KILL ALL NUMBERS!");
        JLabel label2 = new JLabel("Set rows and columns value!");
        JTextField rowEdit = new JTextField("");
        JTextField colEdit = new JTextField("");
        JButton startButton = new JButton("Start to KILL!");

        startButton.addActionListener(e -> {
            rows = Integer.parseInt(rowEdit.getText());
            columns = Integer.parseInt(colEdit.getText());
            System.out.println(rows + " " + columns);
            if ((rows * columns) % 2 == 0) {
                ArrayGenerator arrayGenerator = new ArrayGenerator(rows, columns);
                GameLogic logic = new GameLogic(arrayGenerator);
                new GameGui(logic, rows, columns);
                initialFrame.setVisible(false);
            } else {
                label2.setText("Wrong rows and columns value :(");
            }
        });

        initialFrame.add(label1);
        initialFrame.add(label2);
        initialFrame.add(rowEdit);
        initialFrame.add(colEdit);
        initialFrame.add(startButton);
        initialFrame.setLayout(new GridLayout(5, 1));
        initialFrame.pack();
        initialFrame.setVisible(true);
    }
}
