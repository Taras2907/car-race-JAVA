package com.company.battleShips.Ships;
public abstract class Ship {
    protected Position position;
    protected double speed;
    protected String name = "";
    protected double health = 0;
    protected String rank = "";
    protected double armor = 0;
    protected boolean isAlive = false;
    protected boolean isAnEnemyShip = true;
    protected double chanceOfCriticalDamage = 0.05;
    protected double bowTurretDamage;
    protected double sternTurretDamage;

    private String ourOrEnemyShip() {
        return this.isAnEnemyShip ? "enemy ship " : "our ship ";
    }

    private String getName() {
        return name;
    }

    protected abstract void prepareTheTurrets();

    protected void receiveHit(double hit, String attackerName) {
        double receivedDamage = 0;

        if (isAlive) {

            receivedDamage = (int) Math.max(hit - armor, 0);
            health = health - receivedDamage;

        }
        if (health > 0) {
            System.out.println("***Admiral "
                    .concat(ourOrEnemyShip())
                    .concat(getName())
                    .concat("received " + receivedDamage)
                    .concat(" damage from ")
                    .concat(attackerName)
                    .concat(ourOrEnemyShip() + "still have " + health + " health***")
            );
        } else if (health <= 0 && isAlive) {
            isAlive = false;
            System.out.println("***Admiral "
                    .concat(ourOrEnemyShip())
                    .concat(getName())
                    .concat("received " + receivedDamage)
                    .concat(" damage from ")
                    .concat(attackerName)
                    .concat("and heroically fall in the battle***"));
        }
    }

    public void hit(Ship target, double damage, String attackerName) {
        target.receiveHit(damage, attackerName);
    }

    public double getHealth() {
        return this.health;
    }

    public void setChanceOfCriticalDamage(double newChance) {
        chanceOfCriticalDamage = newChance;
    }

    public double getShipArmor() {
        return armor;
    }

    public double getShipChanceOfCriticalDamage() {
        return chanceOfCriticalDamage;
    }

    public boolean checkIsShipAlive() {
        return isAlive;
    }

    public String getShipName() {
        return this.name;
    }

    public void setPosition(Position position) {
        position.setThereIsAShip(true);
        this.position = position;
    }

    public String getPosition() {
        return this.position.name();
    }

    public String getRank() {
        return this.rank;
    }

    public double getBowTurretDamage() {
        return bowTurretDamage;
    }

    public double getSternTurretDamage() {
        return sternTurretDamage;
    }

    public void moveToAnotherSector() {
        this.position.setThereIsAShip(false);
        int _position = this.position.ordinal();
        this.position = Position.values()[_position + 10];
        this.position.setThereIsAShip(true);
    }

    public boolean getIsEnemyShip() {
        return this.isAnEnemyShip;
    }
    public void hitIfCoordinatesEqualEnemyPosition(String coordinatesForTurret, Ship[] enemyShips, boolean isBowTurret){
        if (Position.valueOf(coordinatesForTurret).checkIsThereAShip()){

            for (Ship enemyShip : enemyShips) {

                if (coordinatesForTurret.equals(enemyShip.getPosition())){

                    if(isBowTurret){
                        this.hit(enemyShip, this.getBowTurretDamage(), this.getShipName());
                    }else{
                        this.hit(enemyShip, this.getSternTurretDamage(), this.getShipName());
                    }

                }
            }
        }else {
            System.out.println("***Admiral unfortunately there are no ships in this sector, we have missed.");
        }
}
}





