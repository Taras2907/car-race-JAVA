package com.company.battleShips.Board;

import com.company.battleShips.Ships.*;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int margin = 33;
    private int rowsInTable = 10;

    private String [] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private Map<String, Integer> lettersRows = new HashMap<String, Integer>();

    // Set colors

    private String blueBackground = TextColors.ANSI_BLUE_BACKGROUND.getUnicodeSymbolOfAnsiColor();
    private String colorTextWhite = TextColors.ANSI_WHITE.getUnicodeSymbolOfAnsiColor();
    private String colorTextRed = TextColors.ANSI_RED.getUnicodeSymbolOfAnsiColor();
    private String colorTextGreen = TextColors.ANSI_GREEN.getUnicodeSymbolOfAnsiColor();
    private String returnColorFormattingToBasic = TextColors.ANSI_RESET.getUnicodeSymbolOfAnsiColor();

    // Set row, headers and row boarders

    private String headers = " ".repeat(margin) + blueBackground + colorTextWhite + "     1     2     3     4     5     6     7     8     9     10  " + returnColorFormattingToBasic;
    private String theRowBorder = (blueBackground + colorTextWhite + "  +" + "-----+".repeat(rowsInTable) + returnColorFormattingToBasic + "\n");
    private String theRowContent = (blueBackground + colorTextWhite +  " |" + "     |".repeat(rowsInTable) + returnColorFormattingToBasic + "\n");
    private StringBuilder theTable = new StringBuilder();

    private String enemyShip;
    private String myShip;

    public Board(){
        fillTheLetterRows();
    }

    private void fillTheLetterRows(){
        for (int i = 0; i < letters.length; i++) {
            lettersRows.put(letters[i], i);
        }
    }
    private String getShipModel(String shipRank){
        String ship = "<###>";
        switch (shipRank) {
            case "Dreadnought":
                ship = "<###>";
                return ship;
            case "Cruiser":
                ship = " <##>";
                return ship;
            case "Frigate":
                ship = " <#> ";
                return ship;
            default:
                ship = "something went wrong with ship rank";
                break;
        }
        return ship;
    }
    private String getEnemyShip(){
        // <blueBg><red>SHIP</red></blueBg>  <>...</>

        return blueBackground + colorTextRed+  this.enemyShip + returnColorFormattingToBasic + blueBackground + colorTextWhite;
    }
    private String getMyShip(){
        return blueBackground + colorTextGreen + this.myShip + returnColorFormattingToBasic + blueBackground + colorTextWhite;
    }
    private int[] getShipIndex(String shipPosition){
        int row = lettersRows.get(shipPosition.substring(0,1));
        int cell = Integer.parseInt(shipPosition.substring(1)) -1; // correction for index, indexing starts with zero
        return new int[]{row, cell};
    }

    private String placeShipsOnTheRow(Ship[] ships , int currentRow){
        StringBuilder currentRowWithShips = new StringBuilder();
        currentRowWithShips.append(theRowContent);
        String theShip ;
        for (Ship ship : ships) {
             int[] thisShipPosition = getShipIndex(ship.getPosition());
             int thisShipRow = thisShipPosition[0];
             int thisShipCell = thisShipPosition[1];

             if (thisShipRow == currentRow){
                 theShip = setShipModel(ship);

                 int startIndex2 = getIndex(currentRowWithShips.toString(), thisShipCell) + 1;
                 int endIndex2 = getIndex(currentRowWithShips.toString(), thisShipCell + 1);

                 currentRowWithShips.replace(startIndex2 , endIndex2 , theShip);
             }
        }
        return currentRowWithShips.toString();
    }
    private int getIndex(String currentRowWithShips, int thisShipCell){
        int index = (currentRowWithShips.indexOf("|"));
        for (int i =0; i< thisShipCell; i++){
            index = currentRowWithShips.indexOf("|", index + 1);
        }
        return index;
    }

    private void generateTable(Ship [] ships){
        for(int i =0; i<rowsInTable; i++){
            this.theTable.append(" ".repeat(margin));
            this.theTable.append(theRowBorder);
            this.theTable.append(" ".repeat(margin));
            this.theTable.append(blueBackground)
                    .append(colorTextWhite)
                    .append(letters[i]);
            this.theTable.append(placeShipsOnTheRow(ships, i));

        }
        this.theTable.append(" ".repeat(margin));
        this.theTable.append(theRowBorder);
    }

    public void displayTheTable(Ship [] ships){
        generateTable(ships);
        System.out.println(headers);
        System.out.println(theTable.toString());
    }
    public void cleanTable(){
        theTable.setLength(0);
    }
    private String setShipModel(Ship ship){
        String theShip;
        if (ship.getIsEnemyShip()){
            enemyShip = getShipModel(ship.getRank());
            theShip = ship.checkIsShipAlive() ? getEnemyShip() : enemyShip;
        }else{
            myShip = getShipModel(ship.getRank());
            theShip = ship.checkIsShipAlive() ? getMyShip() : myShip;
        }
        return theShip;
    }
}
