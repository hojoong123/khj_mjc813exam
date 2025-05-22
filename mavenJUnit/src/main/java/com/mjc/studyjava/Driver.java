package com.mjc.studyjava;

public class Driver {
    private String name;
    private int age;
    private Vehicle vehicle;

    public Driver(String name, int age, Vehicle vehicle) {
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }

    public void drive() {
        vehicle.move();

        if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.print("운전수" + name + "은 ");
            truck.move();
        } else if (vehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) vehicle;
            System.out.println("운전수" + name + "은 ");
            bicycle.move();
        }
    }

    public void brake() {
        if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            vehicle.stop();
            System.out.println("운전수" + name + "은 트럭");
            truck.stop();
        } else if (vehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) vehicle;
            vehicle.stop();
            System.out.println("운전수" + name + "은 자전거");
            bicycle.stop();
        }
    }
}
