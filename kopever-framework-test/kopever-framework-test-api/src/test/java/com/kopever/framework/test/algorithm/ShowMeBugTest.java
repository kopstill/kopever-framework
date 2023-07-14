package com.kopever.framework.test.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShowMeBugTest {

    @Test
    public void testDirection() {
//        String[] params = new String[]{"WEST", "SOUTH", "EAST", "NORTH"};
//        String[] params = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
//        String[] params = new String[]{"NORTH", "SOUTH", "EAST", "WEST"};
//        String[] params = new String[]{"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"};
//        String[] params = new String[]{"NORTH", "WEST", "SOUTH", "EAST"};
        String[] params = new String[]{"NORTH", "WEST", "SOUTH", "EAST", "WEST", "NORTH", "EAST", "SOUTH", "WEST", "WEST", "EAST", "EAST"};
        String[] result = dirReduce(params);
        for (String str : result) {
            System.out.println(str);
        }
    }

    private enum Direction {
        EAST("WEST"),
        WEST("EAST"),
        SOUTH("NORTH"),
        NORTH("SOUTH");

        private final String reDirection;

        Direction(String reDirection) {
            this.reDirection = reDirection;
        }

        String getReDirection() {
            return this.reDirection;
        }
    }

    private String[] dirReduce(String[] directions) {
        if (directions == null || directions.length == 1) {
            return directions;
        }

        List<String> directionList = new LinkedList<>(Arrays.asList(directions));
        for (int i = 0; i < directionList.size() - 1; i++) {
            String cuDirection = directionList.get(i);
            String neDirection = directionList.get(i + 1);
            String reDirection = Direction.valueOf(cuDirection).getReDirection();

            if (reDirection.equals(neDirection)) {
                directionList.remove(i);
                directionList.remove(i);
                return dirReduce(directionList.toArray(new String[]{}));
            }
        }

        return directionList.toArray(new String[]{});
    }

}
