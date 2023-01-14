package com.hks.design.patterns.adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovableAdapterImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSpeed() {
        Movable bugatti = new BugattiVeyron();
        MovableAdapter bugattiAdapter = new MovableAdapterImpl(bugatti);
        Assertions.assertEquals(592.23712, bugattiAdapter.getSpeed());
        // assertEquals(float expected, float actual, float delta);
        Assertions.assertEquals(592.23712, bugattiAdapter.getSpeed(), .001);
        Assertions.assertEquals(592.2371, bugattiAdapter.getSpeed(), .001);
        //System.out.println(bugattiAdapter.getSpeed());
    }
}