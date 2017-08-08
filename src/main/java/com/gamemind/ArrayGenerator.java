package com.gamemind;

import java.util.Arrays;
import java.util.Random;

class ArrayGenerator {

    private final int rows;
    private final int pairs;

    ArrayGenerator(int rows) {
        this.rows = rows;
        this.pairs = rows * rows / 2;
    }

    int[][] generate() {
        Integer[] num = generateNumbersForPairs();
        System.out.println(Arrays.asList(num));
        return initializeArray(num);
    }

    private int[][] initializeArray(Integer[] num) {
        int[][] gameArr = new int[rows][rows];
        gameArr = inArr(num, gameArr);
        return gameArr;
    }

    private Integer[] generateNumbersForPairs() {
        Integer[] numOf = new Integer[pairs];
        Random rand = new Random();
        outer:
        for (int i = 0; i < numOf.length; i++) {
            int rd = rand.nextInt(pairs) + 1;
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

    private int[][] inArr(Integer[] num, int[][] gameArr) {
        int xPosition;
        int yPosition;
        int count = 0;
        for (int i : num) {
            System.out.println("i: " + i);
            //TODO Change for to while or doWhile
            for (int repeat = 0; repeat < 2; repeat++) {
                Random rand = new Random();
                xPosition = rand.nextInt(rows);
                yPosition = rand.nextInt(rows);
                if (gameArr[xPosition][yPosition] == 0) {
                    gameArr[xPosition][yPosition] = i;
                    count++;
                    System.out.println(xPosition + " " + yPosition);
                } else if (gameArr[xPosition][yPosition] != 0) {
                    count++;
                    repeat--;
                }
            }
        }
        for (int i = 0; i <= gameArr.length - 1; i++) {
            for (int j = 0; j <= gameArr[i].length - 1; j++) {
                System.out.print(gameArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("count: " + count);
        return gameArr;
    }
}
