package com.company.battleShips.Turrets;

import com.company.battleShips.Cannons.Cannon;
import com.company.battleShips.Cannons.Naval10cmGun;

public class FrigateMainTurret extends Turret {
    public Cannon firstCannon;
    public Cannon secondCannon;
    public FrigateMainTurret(){
        super();
        this.firstCannon = new Naval10cmGun();
        this.secondCannon = new Naval10cmGun();
        this.turretDamage = firstCannon.getCannonDamage() + secondCannon.getCannonDamage();
        this.ignoringEnemyShipArmorRate = firstCannon.getIgnoringEnemyShipArmorRate();
    }
    @Override
    protected void createTurret() {

        //fill with special characteristics for each turret, range, chance to be broken etc.
    }

}
