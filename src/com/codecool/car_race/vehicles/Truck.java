package com.codecool.car_race.vehicles;

import com.codecool.car_race.random.Util;

public class Truck extends Vehicle {
    public static boolean isBroken = false;
    private int normalSpeed = 100;
    private int breakdownTurnsLeft;
    public Truck(){
        this.speed = normalSpeed;
        this.type = "truck";
        this.name = String.valueOf(Util.getRandom(0, 1000));
    }
    private void checkIsTruckBroken(){
        int chanceOfBecameBroken = Util.getRandom(1, 19); // chance is 5%
        if (chanceOfBecameBroken == 5){
            breakdownTurnsLeft = 2;
            isBroken = true;
        }
    }
    @Override
    public void prepareForLap() {
        checkIsTruckBroken();
        if (breakdownTurnsLeft <= 2 && breakdownTurnsLeft > 0){
            breakdownTurnsLeft --;
            this.speed = 0;
        }else{
            this.speed = normalSpeed;
        }
    }
}
