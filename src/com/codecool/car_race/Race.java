package com.codecool.car_race;

import com.codecool.car_race.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int numberOfRounds = 50;
    private List<Vehicle> vehicles = new ArrayList<>();
    public Race(){
    }


    public void simulateRace(){
        for (int i = 0; i < numberOfRounds; i++){
            Weather.setRaining();
            vehicles.forEach(Vehicle::prepareForLap);
            vehicles.forEach((Vehicle::moveForAnHour));

        }
    }
    public void printRaceResults(){
        vehicles.forEach(vehicle ->{
            System.out.println(String.format("Vehicle name : %s. Vehicle distance traveled %s km. Vehicle type: %s",
                    vehicle.getName(), vehicle.getDistanceTraveled(), vehicle.getType()));
        });
    }
    public void addVehicleToTheRace(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

}
