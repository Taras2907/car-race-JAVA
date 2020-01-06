package com.company.battleShips.Battles;

import com.company.battleShips.Board.Board;
import com.company.battleShips.Round;
import com.company.battleShips.Ships.*;
import com.company.battleShips.Wind.Wind;

public class BattleOfMidway extends Battle {

    public BattleOfMidway() {

        super();
        Ship myShip = new Dreadnought(false);
        Ship enemyFrigate = new Frigate(true);
        Ship enemyCruiser = new Cruiser(true);

        Ship[] enemyShips = new Ship[]{enemyCruiser, enemyFrigate};
        Ship[] allShips = new Ship[]{enemyCruiser, enemyFrigate, myShip};

        Round round = new Round();
        Wind wind = new Wind();
//    }
//
//    public void run() {

        initiateTheBattle(myShip, enemyFrigate, enemyCruiser, round);
        round.displayStartMessages(enemyShips);
        Board board = new Board();
        ;
        while (myShip.checkIsShipAlive() && allEnemyShipsAreAlive(enemyShips)) {
            round.displayEnemiesAreDetected(enemyShips);
            board.displayTheTable(allShips);
            board.cleanTable();


            coordinatesForSternTurret =  round.selectTargetPosition("stern turret: ");
            coordinatesForBowTurret = round.selectTargetPosition("bow turret: ");


            coordinatesForBowTurret = wind.makeCorrectionToTheWind(coordinatesForBowTurret, enemyFrigate);
            coordinatesForSternTurret = wind.makeCorrectionToTheWind(coordinatesForSternTurret, enemyFrigate);

            moveEnemyShipsToOtherSectors(enemyShips);

            myShip.hitIfCoordinatesEqualEnemyPosition(coordinatesForSternTurret, enemyShips, false);
            myShip.hitIfCoordinatesEqualEnemyPosition(coordinatesForBowTurret, enemyShips, true);

            fireAtWillIfIsALive(enemyShips, myShip);
        }
        checkWhoWon(myShip);

    }
    @Override
    protected void initiateTheBattle(Ship myShip, Ship enemyFrigate, Ship enemyCruiser,Round round) {
            myShip.setPosition(Position.H6);
            enemyCruiser.setPosition(Position.B4);
            enemyFrigate.setPosition(Position.B8);
    }


}
