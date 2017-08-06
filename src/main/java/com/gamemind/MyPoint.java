package com.gamemind;

import lombok.Data;

@Data
class MyPoint {
    private int value = 0;
    private boolean wasSelected = false;

    @Override
    public String toString() {
        return String.format("[%d]:%s", value, wasSelected ? "t" : "f");
    }
}
