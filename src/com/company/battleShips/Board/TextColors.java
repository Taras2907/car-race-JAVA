package com.company.battleShips.Board;

public enum TextColors {
    ANSI_RED("ANSI_RED", "\u001B[31m"),
    ANSI_RESET("ANSI_RESET", "\u001B[0m"),
    ANSI_WHITE("ANSI_WHITE", "\u001B[37m"),
    ANSI_PURPLE("ANSI_PURPLE", "\u001B[35m"),
    ANSI_CYAN("ANSI_CYAN", "\u001B[36m"),
    ANSI_BLACK_BACKGROUND("ANSI_BLACK_BACKGROUND", "\u001B[40m"),
    ANSI_BLUE_BACKGROUND("ANSI_BLUE_BACKGROUND", "\u001B[44m"),
    ANSI_GREEN("ANSI_GREEN", "\u001B[32m");

    private final String ansiColor;
    private final String  unicodeSymbolOfAnsiColor;

    TextColors(String ansiColor, String unicodeSymbolOfAnsiColor) {
        this.ansiColor = ansiColor;
        this.unicodeSymbolOfAnsiColor = unicodeSymbolOfAnsiColor;
    }
    public String getUnicodeSymbolOfAnsiColor(){
        return unicodeSymbolOfAnsiColor;
    }
}
