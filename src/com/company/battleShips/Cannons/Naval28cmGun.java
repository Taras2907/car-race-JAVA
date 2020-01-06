package com.company.battleShips.Cannons;

public class Naval28cmGun extends Cannon {
    public Naval28cmGun(){
        super();
        this.calibre = 28;
        this.cannonDamage = 100 * calibre;
        this.ignoringEnemyShipArmorRate = 0.8;

    }
    @Override
    protected void createCannon() {
        //fill with special characteristics for each cannon
    }
}
