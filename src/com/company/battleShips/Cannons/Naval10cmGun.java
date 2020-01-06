package com.company.battleShips.Cannons;

public class Naval10cmGun extends Cannon {
    public Naval10cmGun(){
        super();
        this.calibre = 10;
        this.cannonDamage = 100 * calibre;
        this.ignoringEnemyShipArmorRate = 0.6;

    }

//    int getCalibre() {
//        return 10;
//    }

    @Override
    protected void createCannon() {
        //fill with special characteristics for each cannon
    }
}
