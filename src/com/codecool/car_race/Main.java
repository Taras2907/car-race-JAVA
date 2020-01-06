package com.codecool.car_race;

import com.codecool.car_race.vehicles.Vehicle;
import com.codecool.car_race.vehicles.VehicleFactory;

public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void addVehicles(Race race) {
        createVehicles("car",race);
        createVehicles("truck",race);
        createVehicles("motorcycle", race);

    }

    private static void createVehicles(String vehicle,  Race race){
        int numberVehiclesOfEachTypeInTheRace = 10;
        for (int i = 0; i < numberVehiclesOfEachTypeInTheRace; i++){
            Vehicle newVehicle = VehicleFactory.createVehicle(vehicle);
            race.addVehicleToTheRace(newVehicle);
        }
    }

    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        addVehicles(race);

        race.simulateRace();
        race.printRaceResults();

    }
}
