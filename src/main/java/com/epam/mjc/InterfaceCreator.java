package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean res = true;
            for (String el : x) {
                res = Character.isUpperCase(el.charAt(0));
                if (el.matches(".*\\d.*")) return false;
            }
            return res;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            for (Integer value : x) {
                if (value % 2 == 0) {
                    evenValues.add(value);
                }
            }
            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String el : values) {
                if (el.split(" ").length > 3 && Character.isUpperCase(el.charAt(0)) && el.endsWith(".")) res.add(el);
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> res = new HashMap<>();
            for (String el : x) res.put(el, el.length());
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> res = new ArrayList<>();
            res.addAll(list1);
            res.addAll(list2);
            return res;
        };
    }
}
