package com.codecool.car_race.vehicles;

import com.codecool.car_race.random.Util;

public class Car extends Vehicle {
    private String[] carNames = {
            "Union", "Surge",
            "Cosmos", "Encounter",
            "Dominion", "Curiosity",
            "Virtue", "Aurora",
            "Harmony", "Formula"
    };
    public Car(){
        this.type = "car";
        this.speed = Util.getRandom(80, 110);// base speed
        this.name = getCarName() + " " + getCarName();
    }
    private String getCarName(){
        int index = Util.getRandom(0, carNames.length);
        return carNames[index];
    }

    @Override
    public void prepareForLap() {
        if (Truck.isBroken){
            this.speed = Util.getRandom(0, 75); // sets max speed to 75 km/ph
        }
        else{
            this.speed = Util.getRandom(80, 110);
        }
    }
}
