package com.company.battleShips.Ships;

import com.company.battleShips.Turrets.DreadnoughtHeavyTurret;
import com.company.battleShips.Turrets.DreadnoughtTurret;
import com.company.battleShips.Turrets.Turret;

public class Dreadnought extends Ship {
    private Turret bowTurret;
    private Turret sternTurret;

    public Dreadnought(boolean isAnEnemyShip){
        super();
        this.name = "Yamato ";
        this.armor = 0;
        this.health = 100000;
        this.isAlive = true;
        this.rank = "Dreadnought";
        this.isAnEnemyShip = isAnEnemyShip;
        this.position = Position.B1;
        prepareTheTurrets();

    }

    @Override
    protected void prepareTheTurrets() {
        this.bowTurret = new DreadnoughtHeavyTurret();
        this.sternTurret = new DreadnoughtTurret();
        this.bowTurretDamage = this.bowTurret.getTurretDamage();
        this.sternTurretDamage = this.sternTurret.getTurretDamage();
    }

}
