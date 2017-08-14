package com.gamemind;

import java.util.Arrays;

class GameLogic {
    private MyPoint[][] status;
    private State state = State.NOCLICK;

    enum State {
        NOCLICK, FIRSTCLICK, SECONDCLICK
    }

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

    private State transition(State state) {
        switch (state) {
            case NOCLICK:
                state = State.FIRSTCLICK;
                break;
            case FIRSTCLICK:
                state = State.SECONDCLICK;
                break;
        }
        return state;
    }

    private MyPoint firstPoint;

    MyPoint[][] userClick(int x, int y) {
        System.out.printf("Received coordinates %d:%d%n", x, y);

        if (x >= 0 && y >= 0) {
            if (!status[x][y].isWasSelected()) {
                state = transition(state);
                switch (state) {
                    case FIRSTCLICK:
                        firstPoint = status[x][y];
                        firstPoint.setWasSelected(true);
                        break;
                    case SECONDCLICK:
                        MyPoint secondPoint = status[x][y];
                        secondPoint.setWasSelected(true);
                        if (firstPoint.getValue() == secondPoint.getValue()) {
                            state = State.NOCLICK;
                            System.out.println("yey");
                        } else {
                            state = State.NOCLICK;
                            firstPoint.setWasSelected(false);
                            secondPoint.setWasSelected(false);
                        }
                        break;
                    default:
                        System.err.println("Received weird coordinates");
                }
            }
        }
        return getStatus();
    }
}
