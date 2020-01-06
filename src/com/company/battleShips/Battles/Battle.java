package com.company.battleShips.Battles;

import com.company.battleShips.Round;
import com.company.battleShips.Ships.Ship;

public abstract class Battle {
    protected String coordinatesForBowTurret;
    protected String coordinatesForSternTurret;

    protected abstract void initiateTheBattle(Ship myShip, Ship enemyShip1, Ship enemyShip2, Round round);

    protected boolean allEnemyShipsAreAlive(Ship [] enemyShips){
        for (Ship enemyShip : enemyShips) {
            if (enemyShip.checkIsShipAlive()){
                return true;
            }
        }
        return false;
    }

    protected void checkWhoWon(Ship myShip){
        if (!myShip.checkIsShipAlive()) {
            System.out.println("***Admiral we lost the battle!***");
        } else{
            System.out.println("***Admiral we won this battle***");
        }
    }
    protected void moveEnemyShipsToOtherSectors(Ship[] ships){
        for (Ship ship : ships) {
            ship.moveToAnotherSector();
        }
    }

    protected void fireAtWillIfIsALive(Ship[] ships, Ship myShip) {
        for (Ship ship : ships) {
            if (ship.checkIsShipAlive()) {
                ship.hit(myShip, ship.getSternTurretDamage(), ship.getShipName());
                ship.hit(myShip, ship.getBowTurretDamage(), ship.getShipName());

            }
        }
    }

}
