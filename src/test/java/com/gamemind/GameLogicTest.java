package com.gamemind;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameLogicTest {
    /*
   6T|7T|1T|7T
   3T|4T|8T|5F
   2T|4T|3T|6T
   1T|5T|8T|2T
     */
    @Test
    public void testClick() throws Exception {
//        Given
//        TODO initialize GameLogic
        GameLogic gameLogic = new GameLogic(null);

//        When
        MyPoint[][] myPoints = gameLogic.userClick(0, 0);

//        Then
        assertTrue(myPoints[0][0].isWasSelected());
    }
}
