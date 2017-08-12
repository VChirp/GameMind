package com.gamemind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class MyPoint {
    private int value = 0;
    private boolean wasSelected = false;

    @Override
    public String toString() {
        return String.format("[%d]:%s", value, wasSelected ? "t" : "f");
    }
}
