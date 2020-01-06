package com.company.battleShips.Turrets;

import com.company.battleShips.Cannons.Cannon;
import com.company.battleShips.Cannons.Naval15cmGun;

public class CruiserMainTurret extends Turret {
    public Cannon firstCannon;
    public Cannon secondCannon;
    public CruiserMainTurret(){
        this.firstCannon = new Naval15cmGun();
        this.secondCannon = new Naval15cmGun();
        this.turretDamage = firstCannon.getCannonDamage() + secondCannon.getCannonDamage();
        this.ignoringEnemyShipArmorRate = firstCannon.getIgnoringEnemyShipArmorRate();
    }
    @Override
    protected void createTurret() {
        //fill with special characteristics for each turret, range, chance to be broken etc.
    }
}
