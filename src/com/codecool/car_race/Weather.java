package com.codecool.car_race;

import com.codecool.car_race.random.Util;

public class Weather {
    private static boolean isRain = false;

    public Weather(){
    }
    public static void setRaining(){
        int chanceOfRain =  Util.getRandom(0, 10);
        //chance of rain is 30%
        isRain = chanceOfRain <= 3;
    }
    public static boolean isRaining(){
        return isRain;
    }
}
