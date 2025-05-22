package com.mjc.studyjava;

public class Bicycle extends Vehicle {
    private String name;

    public Bicycle(String name, int wheelCount) {
        super(wheelCount);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("자전거" + name + "는 " + wheelCount + "개의 바퀴로 이동한다.");
    }

    @Override
    public void stop() {
        System.out.println("자전거" + name + "는 정지한다.");
    }
}
