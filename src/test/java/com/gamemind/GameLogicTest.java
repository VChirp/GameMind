package com.gamemind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameLogicTest {
    private Parser parser = new Parser();

    /*
   6T|7T|1T|7T
   3T|4T|8T|5F
   2T|4T|3T|6T
   1T|5T|8T|2T
     */
    @Test
    public void testClickTrue() throws Exception {
//        Given
        GameLogic gameLogic = new GameLogic(parser.parse("6F|5F"));

//        When
        MyPoint[][] myPoints = gameLogic.userClick(0, 0);

//        Then
        assertTrue(myPoints[0][0].isWasSelected());
    }

    @Test
    public void testClickValue() throws Exception {
        GameLogic gameLogic = new GameLogic(parser.parse("6F|5F"));

        MyPoint[][] myPoints = gameLogic.userClick(0, 1);

        assertEquals(myPoints[0][1].getValue(), 5);
    }

    @Test
    public void testClickEqualsTrue() throws Exception {
        GameLogic gameLogic = new GameLogic(parser.parse("5F|5F"));

        MyPoint[][] myPoints;
        gameLogic.userClick(0,0);
        myPoints = gameLogic.userClick(0,1);

        assertTrue(myPoints[0][0].isWasSelected());
        assertTrue(myPoints[0][1].isWasSelected());
    }

    @Test
    public void testClickEqualsFalse() throws Exception {
        GameLogic gameLogic = new GameLogic(parser.parse("5F|2F"));

        MyPoint[][] myPoints;
        gameLogic.userClick(0,0);
        myPoints = gameLogic.userClick(0,1);

        assertFalse(myPoints[0][0].isWasSelected());
        assertFalse(myPoints[0][1].isWasSelected());
    }
}
