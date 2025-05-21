package com.mjc.studyjava;

public class Bird extends Animal {
    protected String wings = "날개";

    public Bird(String name, int age) {
        super(name, age);
    }

    public void flap() {
        System.out.println(name + " " + wings + " 날개짓한다.");
    }

    public void fly() {
        System.out.println(name + " " + wings + " 난다.");
    }

    @Override
    public Bird reproduce(String newName) {
        return new Bird(newName, 0);
    }
}
