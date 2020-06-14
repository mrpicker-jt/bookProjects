package com.mrpicker.pets;

import com.mrpicker.pets.vo.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class PetCounter {
    private static List<Pet> petList = new ArrayList<>();

    private static void prepareData() {
        Stream.generate(new ForNameCreator()).limit(30).forEach(pet -> petList.add(pet));
    }


    public static void count() {
        prepareData();
        System.out.println(petList);
        HashMap<String, Integer> countMap = new HashMap<>();
        petList.forEach(pet -> {
            String simpleName = pet.getClass().getSimpleName();
            Integer integer = countMap.get(simpleName);
            if (integer != null) {
                countMap.put(simpleName, ++integer);
            } else {
                countMap.put(simpleName, 1);
            }
        });
        System.out.println(countMap);
    }
}
