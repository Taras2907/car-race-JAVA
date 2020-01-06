package com.company.battleShips.Cannons;

public abstract class Cannon {
    protected double ignoringEnemyShipArmorRate;
    protected int calibre;
    protected int rangeOfFire;
    protected double cannonDamage;
    protected abstract void createCannon();
    public double getCannonDamage(){
        return cannonDamage;
    }
    public double getIgnoringEnemyShipArmorRate(){
        return ignoringEnemyShipArmorRate;
    }
}
