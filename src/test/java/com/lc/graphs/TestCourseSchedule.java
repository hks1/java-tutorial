package com.lc.graphs;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestCourseSchedule {
    CourseSchedule obj;
    @BeforeEach
    public void setUp(){
        obj = new CourseSchedule();
    }
    @Test
    public void testCanFinish(){
        //Example 1:
        //
        //Input: numCourses = 2, prerequisites = [[1,0]]
        //Output: true
        //Explanation: There are a total of 2 courses to take.
        //To take course 1 you should have finished course 0. So it is possible.
        //Example 2:
        //
        //Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        //Output: false
        //Explanation: There are a total of 2 courses to take.
        //To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
        //obj = new CourseSchedule();
        Assertions.assertTrue(obj.canFinish(2, new int[][]{{1,0}}));
        Assertions.assertFalse(obj.canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
