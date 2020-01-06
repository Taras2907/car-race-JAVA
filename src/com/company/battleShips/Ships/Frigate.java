package com.company.battleShips.Ships;

import com.company.battleShips.Turrets.FrigateMainTurret;
import com.company.battleShips.Turrets.Turret;

public class Frigate extends Ship {
    public Turret bowTurret;
    public Turret sternTurret;
    public Frigate(boolean isAnEnemyShip){
        super();
        super.name = "HMS York town ";
        super.armor = 0;
        super.health = 3000;
        super.isAlive = true;
        super.rank = "Frigate";
        super.isAnEnemyShip = isAnEnemyShip;
        prepareTheTurrets();

    }

    @Override
    protected void prepareTheTurrets() {
        this.bowTurret = new FrigateMainTurret();
        this.sternTurret = new FrigateMainTurret();
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
