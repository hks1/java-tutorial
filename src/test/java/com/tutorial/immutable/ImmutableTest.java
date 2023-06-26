package com.tutorial.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableTest {
    Immutable obj;

    @BeforeEach
    void setUp() {
        obj = new Immutable();
    }

    @Test
    void testImmutableObjects() {
        String name = "Power One";
        String newName = name.replace("One", "----");

        assertEquals("Power One", name);
        assertEquals("Power ----", newName);
    }

    @Test
    void testImmutableObjectReference(){
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("ImmutableTest");
        assertEquals(0, strings.size());
    }

    @Test
    void main() {
    }
}