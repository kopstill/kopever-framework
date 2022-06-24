package com.kopever.framework.test.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowMeBugTest {

    @Test
    public void testDirection() {
        String[] params = new String[]{"WEST", "EAST", "EAST", "EAST"};
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

        List<String> result = new ArrayList<>();

        for (int i = 0; i < directions.length; i++) {
            Direction direction = Direction.valueOf(directions[i]);
            String reDirection = direction.getReDirection();

            if (i == 0) {
                if (!reDirection.equals(directions[i + 1])) {
                    result.add(directions[i]);
                    continue;
                }
            }

            if (i == directions.length - 1) {
                if (!reDirection.equals(directions[i - 1])) {
                    result.add(directions[i]);
                }
                break;
            }

            if (!reDirection.equals(directions[i + 1]) &&
                    !reDirection.equals(directions[i - 1])) {
                result.add(directions[i]);
            }
        }

        return result.toArray(new String[]{});
    }

}
