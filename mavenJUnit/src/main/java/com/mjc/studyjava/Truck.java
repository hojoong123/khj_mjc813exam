package com.mjc.studyjava;

public class Truck extends Vehicle {
    private String name;
    private int ton;

    public Truck(String name, int ton, int wheelCount) {
        super(wheelCount);
        this.name = name;
        this.ton = ton;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("트럭" + name + "은 " + wheelCount + "개의 바퀴로 이동한다.");
    }

    @Override
    public void stop() {
        System.out.println("트럭" + name + "은 정지한다.");
    }
}
