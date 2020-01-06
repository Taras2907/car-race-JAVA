package com.company.battleShips.Turrets;

import com.company.battleShips.Cannons.Cannon;
import com.company.battleShips.Cannons.Naval28cmGun;

public class CruiserHeaveTurret extends Turret {
    public Cannon firstCannon;
    public CruiserHeaveTurret(){
        super();
        this.firstCannon = new Naval28cmGun();
        this.turretDamage = firstCannon.getCannonDamage();
        this.ignoringEnemyShipArmorRate = firstCannon.getIgnoringEnemyShipArmorRate();
    }

    @Override
    protected void createTurret() {

        //fill with special characteristics for each turret, range, chance to be broken etc.
    }
}
