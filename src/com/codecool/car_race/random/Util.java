package com.codecool.car_race.random;

import java.util.Random;

public class Util {
    private static Random  random = new Random();
    public static int getRandom(int startRange, int endRange){
        return random.nextInt(endRange -startRange) + startRange;
    }
}

