package com.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestTowerOfHanoi {
    TowerOfHanoi obj;
    @BeforeEach
    public void setUp(){
        obj = new TowerOfHanoi();
    }
    @Test
    @DisplayName("test tower of hanoi")
    public void testTowerOfHanoi(){
        obj.move(3, "source", "dest", "helper");
    }
}
