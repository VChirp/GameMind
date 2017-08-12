package com.gamemind;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ParserTest {

    private final Parser parser = new Parser();

    @Test
    public void oneElement() throws Exception {
        MyPoint[][] expected = new MyPoint[][]{
                {new MyPoint(2, false)}
        };

        MyPoint[][] actual = parser.parse("2F");

        assertArrayEquals(expected,actual);
    }

    @Test
    public void twoElements() {
        MyPoint[][] expected = new MyPoint[][]{
                {new MyPoint(6, true), new MyPoint(7, true)}
        };

        MyPoint[][] actual = parser.parse("6T|7T");


        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoLines() throws Exception {

        MyPoint[][] expected = new MyPoint[][]{
                {new MyPoint(6, true), new MyPoint(7, true)},
                {new MyPoint(4, false), new MyPoint(8, true)}
        };

        String candidate =
                        "6T|7T\n" +
                        "4F|8T";
        MyPoint[][] actual = parser.parse(candidate);

        assertArrayEquals(expected, actual);
    }


}