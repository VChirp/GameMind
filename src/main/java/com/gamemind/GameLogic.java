package com.gamemind;

import java.util.Arrays;

class GameLogic {
    private MyPoint[][] status;
    private int clickCounter = 0;

    GameLogic(ArrayGenerator arrayGenerator) {
        int[][] internalNumbers = arrayGenerator.generate();
        MyPoint[][] status = new MyPoint[internalNumbers.length][];
        for (int i = 0; i < internalNumbers.length; i++) {
            status[i] = new MyPoint[internalNumbers[i].length];
            for (int j = 0; j < internalNumbers[i].length; j++) {
                status[i][j] = new MyPoint();
                status[i][j].setValue(internalNumbers[i][j]);
            }
        }
        this.status = status;
    }

    GameLogic(MyPoint[][] status) {
        this.status = status;
    }

    MyPoint[][] getStatus() {
        MyPoint[][] statusCopy = Arrays.copyOf(status, status.length);
        for (int i = 0; i < status.length; i++) {
            statusCopy[i] = Arrays.copyOf(status[i], status[i].length);
            System.out.println("Status copy: " + Arrays.toString(statusCopy[i]));
        }
        return statusCopy;
    }
    MyPoint firstPoint;
    MyPoint[][] userClick(int x, int y) {
        System.out.printf("Received coordinates %d:%d%n", x, y);
        if (x >= 0 && y >= 0) {
            if (!status[x][y].isWasSelected()) {
                clickCounter++;
                //TODO change clickCounter to ENUM
                if (clickCounter == 1) {
                    firstPoint = status[x][y];
                    firstPoint.setWasSelected(true);
                } else if (clickCounter == 2) {
                    MyPoint secondPoint = status[x][y];
                    secondPoint.setWasSelected(true);
                    if (firstPoint.getValue() == secondPoint.getValue()) {
                        clickCounter = 0;
                        System.out.println("yey");
                    } else {
                        clickCounter = 0;
                        firstPoint.setWasSelected(false);
                        secondPoint.setWasSelected(false);
                    }
                }
            }
        } else {
            System.err.println("Received weird coordinates");
        }
        return getStatus();
    }
}
