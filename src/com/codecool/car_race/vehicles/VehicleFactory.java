package com.codecool.car_race.vehicles;

public class VehicleFactory{
    public static Vehicle createVehicle(String vehicle){
        switch (vehicle) {
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            case "motorcycle":
                return new Motorcycle();
        }
        return null;
    }
}


