package main;

import java.util.Arrays;
import java.util.Random;

class GameLogic {

    private static final int PAIRS = 8;
    private MyPoint[][] status;
    private int clickCounter = 0;
    private MyPoint firstPoint;

    GameLogic() {
        status = populateInitialState();
    }

    MyPoint[][] getStatus() {
        return status;
    }

    void userClick(int x, int y) {
        if (x >= 0 && y >= 0) {
            if (!status[x][y].isWasSelected()) {
                clickCounter++;
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
        }
    }

    private static MyPoint[][] populateInitialState() {
        Integer[] num = generateNumbersForPairs();
        System.out.println(Arrays.asList(num));
        return initializeArray(num);
    }

    private static MyPoint[][] initializeArray(Integer[] num) {
        MyPoint[][] gameArr = new MyPoint[4][4];
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

    private static Integer[] generateNumbersForPairs() {
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

    private static MyPoint[][] inArr(Integer[] num, MyPoint[][] gameArr) {
        int xPosition;
        int yPosition;
        int count = 0;
        for (int i : num) {
            System.out.println("i: " + i);
            for (int repeat = 0; repeat < 2; repeat++) {
                Random rand = new Random();
                xPosition = rand.nextInt(4);
                yPosition = rand.nextInt(4);
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
}
