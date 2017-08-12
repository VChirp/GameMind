package com.gamemind;


import java.util.Arrays;
import java.util.Objects;

class Parser {
    MyPoint[][] parse(String str) {
        String[] rows = str.split("\n");
        int columnsNumber = rows[0].split("[|]").length;
        System.out.println(Arrays.toString(rows));
        MyPoint[][] status = new MyPoint[rows.length][columnsNumber];
        for (int i = 0; i < rows.length; i++) {
            String[] buffer = rows[i].split("[|]");
            MyPoint[] arr = new MyPoint[columnsNumber];
            int count = 0;
            for (String j : buffer) {
                System.out.println(count);
                arr[count] = new MyPoint();
                String characterOne = String.valueOf(j.charAt(0));
                String characterTwo = String.valueOf(j.charAt(1));
                arr[count].setValue(Integer.parseInt(characterOne));
                if (Objects.equals(characterTwo, "T")) {
                    arr[count].setWasSelected(true);
                } else {
                    arr[count].setWasSelected(false);
                }
                count++;
                status[i] = arr;
            }
            System.out.println(Arrays.toString(status[i]));
        }
        return status;
    }


}
