package com.test.trial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.test.trail.Shapes;

class TestTrail {

    @Test
    void testComputeSquare() {
        Shapes obj = new Shapes();
        assertEquals(9, obj.ComputeSquareArea(3));
    }

    @Test
    void testComputeCircleArea() {
        Shapes obj = new Shapes();
        assertEquals(78.5, obj.ComputeCircleArea(5),
                "Area of circle calculation may be wrong");
    }
    @Test
    void testComputeCircleArea_Supplier() {
        Shapes obj = new Shapes();
        assertEquals(79, obj.ComputeCircleArea(5),()->"Area of circle may be wrong");
    }
//    executes onyl if test case fails
}