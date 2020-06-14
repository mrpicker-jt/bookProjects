package com.mrpicker.pets;

import com.mrpicker.pets.vo.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private List<Class<? extends Pet>> classList = new ArrayList<>();

    public ForNameCreator() {
        List<String> classNameList = Arrays.asList(
                "com.mrpicker.pets.vo.Cat",
                "com.mrpicker.pets.vo.Pet",
                "com.mrpicker.pets.vo.Dog",
                "com.mrpicker.pets.vo.Mutt"
        );
        for (String className : classNameList) {
            try {
                Class<?> aClass = Class.forName(className);
                classList.add((Class<? extends Pet>) aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected List<Class<? extends Pet>> types() {
        return classList;
    }
}
