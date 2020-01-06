package com.company.battleShips.Turrets;

public abstract class Turret {

//    protected List<Cannon> cannons;

    protected double ignoringEnemyShipArmorRate;
    protected double turretDamage;
    protected double health;
    protected String color = "grey";
    protected abstract void createTurret();
    public double getTurretDamage(){
        return turretDamage;
    }
    public double getIgnoringEnemyShipArmorRate(){
        return ignoringEnemyShipArmorRate;
    }
}
