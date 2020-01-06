package com.company.battleShips.Cannons;

public class Naval38cmGun extends Cannon {
    public Naval38cmGun(){
        super();
        this.calibre = 38;
        cannonDamage = calibre * 100;
        this.ignoringEnemyShipArmorRate = 0.9;

    }
    @Override
    protected void createCannon() {
        //fill with special characteristics for each cannon
    }
}
