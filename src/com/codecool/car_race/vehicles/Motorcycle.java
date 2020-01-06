package com.codecool.car_race.vehicles;

import com.codecool.car_race.Weather;
import com.codecool.car_race.random.Util;

public class Motorcycle extends Vehicle {
    private int normalSpeed = 100;
    private static int motorcycleNumber = 0;
    public Motorcycle(){
        this.speed = 100;
        this.type = "motorcycle";
        this.name = "Motorcycle ".concat(String.valueOf(getMotorcycleNumber()));

        motorcycleNumber ++;
    }
    @Override
    public void prepareForLap() {
        if (Weather.isRaining()){
            this.speed = normalSpeed - Util.getRandom(5, 45);
        }else{
            this.speed = normalSpeed;
        }
    }
    private int getMotorcycleNumber(){
        return motorcycleNumber;
    }
}
