package com.mrpicker.pets;

import com.mrpicker.pets.vo.Pet;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public abstract class PetCreator implements Supplier<Pet> {
    Random random = new Random(47);


    protected abstract List<Class<? extends Pet>> types();


    @Override
    public Pet get() {
        Class<? extends Pet> aClass = types().get(random.nextInt(types().size()));
        try {
            return aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
