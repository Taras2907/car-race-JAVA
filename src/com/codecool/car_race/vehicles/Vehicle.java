package com.codecool.car_race.vehicles;

public abstract class Vehicle {
    int speed;
    String name;
    String type;

    private int distanceTraveled = 0;
    public Vehicle(){

    }
    public void moveForAnHour(){
        this.distanceTraveled += this.speed;
    }
    public abstract void prepareForLap ();
    public String getName(){
        return this.name;
    }
    public int getDistanceTraveled(){
        return this.distanceTraveled;
    }
    public String getType(){
        return this.type;
    }

}// factory design pattern
