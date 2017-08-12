package com.gamemind;

public class Game {
    //    TODO Make array changeable size
    private static final int ROWandCOLUMNS = 6;

    public static void main(String[] Args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator(ROWandCOLUMNS);
        GameLogic logic = new GameLogic(arrayGenerator);
        new GameGui(logic, ROWandCOLUMNS);
    }
}
