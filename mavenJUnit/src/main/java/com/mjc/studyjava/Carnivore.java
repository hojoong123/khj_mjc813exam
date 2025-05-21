package com.mjc.studyjava;

public class Carnivore extends Mammalia {

    public Carnivore(String name, int age) {
        super(name, age);
    }

    public void eat(Herbivore prey) {
        System.out.println(name + "은 " + prey.name + "를 먹는다");
    }

    @Override
    public Carnivore reproduce(String newName) {
        return new Carnivore(newName, 0);
    }
}
