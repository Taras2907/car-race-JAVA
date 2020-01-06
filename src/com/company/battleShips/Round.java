package com.company.battleShips;

import com.company.battleShips.Ships.Ship;
import com.company.battleShips.Wind.Wind;

import java.util.Scanner;

public class Round {
    private Wind wind = new Wind();
    public Round(){
    }

    public String selectTargetPosition(String bowOrSternTurret){
        displaySelectTargetForYour(bowOrSternTurret);
        Scanner scann = new Scanner(System.in);
        return scann.nextLine();
    }

    public void displayPrepareForEngage(){
        System.out.println("Prepare to engage!");
    }

    public void displayEnemiesAreDetected(Ship[] enemyShips){
        System.out.println();
        System.out.println("*** Admiral we have detected such enemy ships: ");
        for (Ship enemyShip : enemyShips) {
            if (enemyShip.checkIsShipAlive()){
                System.out.print("enemy ".concat(enemyShip.getRank() + " " + enemyShip.getShipName()));
                System.out.println(" was detected in sector " + enemyShip.getPosition());
            }
        }
        displayWindSpeedDirection();
        displayPrepareForEngage();
        System.out.println();
    }

    public void displaySelectTargetForYour(String bowOrSternTurret){
        System.out.println("Select target for our ".concat(bowOrSternTurret));
    }

    public void displayGameInstructions(){
        System.out.println("***Admiral we have detected japanese ships our sector \n"
                            .concat("they are moving to us, You need to destroy them before they make us any damage.\n \n")
                            .concat("We know You are a great Admiral but just to remind You there is a short instruction how to control the fire :\n \n"
                            .concat("   1. Consider the wind, for example if it is North wind with speed between 50 km/ph and 100 km/ph\n ")
                            .concat("and enemy ship is in sector C5 you should shoot directly in D5, wind will blow away the shell just for one cell \n")
                            .concat("if wind is under 50km/ph just do not pay attention, and if for example South-East wind with speed\n ")
                            .concat("between 100 km/ph and 150 km/ph you should shoot in A3 because such strong will blow away the shell for two cells\n \n")
                            .concat("   2. Consider the enemy ships speed. Our intelligence inform us that enemy Frigate moves 60km/ph \n")
                            .concat("this is enough to move for two cells enemy Cruiser 40 km/ph that means one cell\n")
                            .concat("and the Most dangerous type is Dreadnoughts, they move 27km/ph that means that sometimes they move for 1 cell \n")
                            .concat("and sometimes the don't so try to be very careful\n ")));
    }
    public void displayStartMessages(Ship[] enemyShips){
        displayGameInstructions();

    }
    public void displayWindSpeedDirection(){
        wind.setWindSpeed();
        wind.setWindDirection();
        System.out.println(String.format("The speed of wind is %d km/ph and direction is %s",
                wind.getWindSpeed(), wind.getWindDirection()));
    }
}
