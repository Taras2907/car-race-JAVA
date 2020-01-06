package com.company.battleShips.Ships;

import com.company.battleShips.Turrets.CruiserHeaveTurret;
import com.company.battleShips.Turrets.CruiserMainTurret;
import com.company.battleShips.Turrets.Turret;

public class Cruiser extends Ship{
    public Turret bowTurret;
    public Turret sternTurret;
    public Cruiser(boolean isAnEnemyShip){
        super();
        this.name = "Scharnhorst ";
        this.armor = 0;
        this.health = 4000;
        this.isAlive = true;
        this.rank = "Cruiser";
        this.isAnEnemyShip = isAnEnemyShip;
        prepareTheTurrets();
    }

    @Override
    protected void prepareTheTurrets() {
        this.bowTurret = new CruiserHeaveTurret();
        this.sternTurret = new CruiserMainTurret();
        this.bowTurretDamage = this.bowTurret.getTurretDamage();
        this.sternTurretDamage = this.sternTurret.getTurretDamage();
    }
    public double getBowTurretDamage() {
        return bowTurret.getTurretDamage();
    }

    public double getSternDamage(){
        return sternTurret.getTurretDamage();
    }
}
