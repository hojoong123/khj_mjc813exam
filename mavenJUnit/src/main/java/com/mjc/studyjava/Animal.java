package com.mjc.studyjava;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(Object feed) {
        System.out.println(name + "은 " + feed + "를 먹는다");
    }

    public void sleep() {
        System.out.println(name + " 잔다");
    }

    public void move() {
        System.out.println(name + " 이동한다");
    }

    public Animal reproduce(String newName) {
        return new Animal(newName, 0);
    }
}


