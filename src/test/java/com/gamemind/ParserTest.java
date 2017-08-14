package com.gamemind;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ParserTest {

    @Test
    public void oneElement() throws Exception {
        MyPoint[][] expected = new MyPoint[][]{
                {new MyPoint(2, false)}
        };

        MyPoint[][] actual = Parser.parse("2F");

        assertArrayEquals(expected,actual);
    }

    @Test
    public void twoElements() {
        MyPoint[][] expected = new MyPoint[][]{
                {new MyPoint(6, true), new MyPoint(7, true)}
        };

        MyPoint[][] actual = Parser.parse("6T|7T");


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
        MyPoint[][] actual = Parser.parse(candidate);

        assertArrayEquals(expected, actual);
    }


}