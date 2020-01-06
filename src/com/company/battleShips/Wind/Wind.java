package com.company.battleShips.Wind;

import com.company.battleShips.Ships.Position;
import com.company.battleShips.Ships.Ship;

import java.util.Random;

public class Wind {
    private static Direction  windDirection;
    private static int windSpeed;
    /// in future make wind depend of climate where the battle is
    public Wind(){
    }
    private int generateNumberInRange(int start, int end){
        Random rg = new Random();
        return rg.nextInt(end) + start;
    }
    public void setWindSpeed(){
        int minWindSpeed = 0;
        int maxWindSpeed = 150;
        windSpeed = generateNumberInRange(minWindSpeed, maxWindSpeed);
    }
    public int getWindSpeed(){
        return windSpeed;
    }
    public void setWindDirection(){
        Direction[] directions = Direction.values();
        int direction = generateNumberInRange(0, Direction.values().length);
        windDirection = directions[direction];
        System.out.println(windDirection);
    }
    public String getWindDirection (){
        return windDirection.name();
    }
    public String makeCorrectionToTheWind(String coordinatesForTurret, Ship ship){
        int cellsInRow = 10;
        int correction = countWindCorrection();
        int indexCoordinatesForTurret = Position.valueOf(coordinatesForTurret).ordinal();
        //
//        this.getWindDirection() == Direction.SOUTH;

        if (this.getWindDirection().equals("SOUTH")){
            indexCoordinatesForTurret += cellsInRow * correction;
        }else if (this.getWindDirection().equals("NORTH")){
            indexCoordinatesForTurret -=cellsInRow * correction;
        }else if (this.getWindDirection().equals("WEST")){
            indexCoordinatesForTurret -= correction;
        }else if (this.getWindDirection().equals("EAST")){
            indexCoordinatesForTurret += correction;
        }
        Position[] positions = Position.values();
        // final index check does index went out of range if yes position is not changing
        int finalIndex = Math.min(Math.max(Math.max(indexCoordinatesForTurret, 0), indexCoordinatesForTurret), 99);
        return positions[finalIndex].name();


    }

    private int countWindCorrection(){
        int correction;;
        if (windSpeed <= 50){
            correction = 0;
        }else if(windSpeed > 50 && windSpeed <=100){
            correction = 1;
        }else{
            correction = 2;
        }
        return correction;
    }

}
