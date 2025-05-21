package com.mjc.studyjava;

public class Mammalia extends Animal {

    public Mammalia(String name, int age) {
        super(name, age);
    }

    public void feedingMilk() {
        System.out.println(name + " 젖을 먹인다.");
    }

    @Override
    public void eat(Object food) {
        if (food instanceof String) {
            System.out.println(name + "은 " + food + "를 먹는다");
        } else {
            System.out.println(name + "은 먹을 수 없는 것을 먹으려 한다");
        }
    }

    @Override
    public Mammalia reproduce(String newName) {
        return new Mammalia(newName, 0);
    }
}
