package com.gamemind;

import java.util.Arrays;
import java.util.Random;

class GameLogic {
    //TODO Refactor out generator class
    private static final int ROWS = 4;
    private static final int PAIRS = ROWS * ROWS / 2;
    //    TODO Make array changeable size
    private MyPoint[][] status;
    private int clickCounter = 0;

    GameLogic() {
        Integer[] num = generateNumbersForPairs();
        System.out.println(Arrays.asList(num));
        status = initializeArray(num);
    }

    GameLogic(MyPoint[][] status) {
        this.status = status;
    }

    MyPoint[][] getStatus() {
        MyPoint[][] statusCopy = Arrays.copyOf(status, status.length);
        for (int i = 0; i < ROWS; i++) {
            statusCopy[i] = Arrays.copyOf(status[i], status[i].length);
            System.out.println("Status copy: " + Arrays.toString(statusCopy[i]));
        }
        return statusCopy;
    }

    MyPoint[][] userClick(int x, int y) {
        System.out.printf("Received coordinates %d:%d%n", x, y);
        if (x >= 0 && y >= 0) {
            if (!status[x][y].isWasSelected()) {
                clickCounter++;
                MyPoint firstPoint = status[x][y];
                if (clickCounter == 1) {
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

    private MyPoint[][] initializeArray(Integer[] num) {
        MyPoint[][] gameArr = new MyPoint[ROWS][ROWS];
        for (int i = 0; i <= gameArr.length - 1; i++) {
            for (int j = 0; j <= gameArr[i].length - 1; j++) {
                gameArr[i][j] = new MyPoint();
                System.out.print(gameArr[i][j].getValue());
            }
            System.out.println();
        }
        gameArr = inArr(num, gameArr);
        return gameArr;
    }

    private Integer[] generateNumbersForPairs() {
        Integer[] numOf = new Integer[PAIRS];
        Random rand = new Random();
        outer:
        for (int i = 0; i < numOf.length; i++) {
            int rd = rand.nextInt(PAIRS) + 1;
            for (int k = 0; k < i; k++) {
                int current = numOf[k];
                if (rd == current) {
                    i--;
                    continue outer;
                }
            }
            numOf[i] = rd;
        }
        return numOf;
    }

    private MyPoint[][] inArr(Integer[] num, MyPoint[][] gameArr) {
        int xPosition;
        int yPosition;
        int count = 0;
        for (int i : num) {
            System.out.println("i: " + i);
            //TODO Change for to while or doWhile
            for (int repeat = 0; repeat < 2; repeat++) {
                Random rand = new Random();
                xPosition = rand.nextInt(ROWS);
                yPosition = rand.nextInt(ROWS);
                if (gameArr[xPosition][yPosition].getValue() == 0) {
                    gameArr[xPosition][yPosition].setValue(i);
                    count++;
                    System.out.println(xPosition + " " + yPosition);
                } else if (gameArr[xPosition][yPosition].getValue() != 0) {
                    count++;
                    repeat--;
                }
            }
        }
        for (int i = 0; i <= gameArr.length - 1; i++) {
            for (int j = 0; j <= gameArr[i].length - 1; j++) {
                System.out.print(gameArr[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("count: " + count);
        return gameArr;
    }

    static class ArrayGenerator {

        private int rows;

        ArrayGenerator(int rows) {
            this.rows = rows;
        }
    }
}
