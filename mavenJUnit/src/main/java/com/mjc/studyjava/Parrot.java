package com.mjc.studyjava;

public class Parrot extends Bird {

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(name + " " + wings + " 조금만 난다.");
    }

    @Override
    public void eat(Object feed) {
        if (feed instanceof String) {
            System.out.println(name + "은 " + feed + "를 먹는다");
        } else {
            System.out.println(name + "은 먹을 수 없는 것을 먹으려 한다");
        }
    }

    @Override
    public Parrot reproduce(String newName) {
        return new Parrot(newName, 0);
    }
}
