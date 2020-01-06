package com.company.battleShips.Turrets;

import com.company.battleShips.Cannons.Cannon;
import com.company.battleShips.Cannons.Naval38cmGun;

public class DreadnoughtHeavyTurret extends Turret {
    public Cannon firstCannon;
    public DreadnoughtHeavyTurret(){
        super();
        this.firstCannon = new Naval38cmGun();
        this.turretDamage = firstCannon.getCannonDamage();
        this.ignoringEnemyShipArmorRate = firstCannon.getIgnoringEnemyShipArmorRate();
    }
    @Override
    protected void createTurret() {

        //fill with special characteristics for each turret, range, chance to be broken etc.
    }
}
