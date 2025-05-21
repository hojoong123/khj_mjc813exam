package com.mjc.studyjava;

public class Eagle extends Bird {

    public Eagle(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(name + " " + wings + " 높이 난다.");
    }

    // eat 메소드 오버로딩 (Animal 타입만 받도록)
    public void eat(Animal prey) {
        System.out.println(name + "은 " + prey.name + "를 먹는다");
    }

    @Override
    public Eagle reproduce(String newName) {
        return new Eagle(newName, 0);
    }
}
