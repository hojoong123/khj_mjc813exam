package com.mjc.studyjava;

public class Herbivore extends Mammalia {

    public Herbivore(String name, int age) {
        super(name, age);
    }

    @Override
    public Herbivore reproduce(String newName) {
        return new Herbivore(newName, 0);
    }
}
