package com.gamemind;

public class Game {
    //    TODO Make array changeable size
    private static final int ROWS = 4;

    public static void main(String[] Args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator(ROWS);
        GameLogic logic = new GameLogic(arrayGenerator);
        new GameGui(logic);
    }
}
