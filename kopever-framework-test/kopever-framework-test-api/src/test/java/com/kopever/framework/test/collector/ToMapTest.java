package com.kopever.framework.test.collector;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ToMapTest {

    @Test
    public void toMap() {
        List<Pair<String, Double>> pairList = new ArrayList<>(3);
        pairList.add(Pair.of("Version", 12.10));
        pairList.add(Pair.of("Version", 12.19));
        pairList.add(Pair.of("Version", 6.28));
        Map<String, Double> map = pairList.stream().collect(
                Collectors.toMap(Pair::getLeft, Pair::getRight, (v1, v2) -> v2)
        );
        System.out.println(map);
    }

}
