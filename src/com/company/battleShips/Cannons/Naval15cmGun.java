package com.company.battleShips.Cannons;

public class Naval15cmGun extends Cannon {
    public Naval15cmGun(){
        super();
        this.calibre = 15;
        this.cannonDamage = 100 * calibre;
        this.ignoringEnemyShipArmorRate = 0.7;
    }
    @Override
    protected void createCannon() {
        //fill with special characteristics for each cannon
    }
}
