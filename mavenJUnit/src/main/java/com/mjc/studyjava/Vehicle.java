package com.mjc.studyjava;

public abstract class Vehicle {
    protected int wheelCount;

    public Vehicle(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public abstract void move();
    public abstract void stop();
}
