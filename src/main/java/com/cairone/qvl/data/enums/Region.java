package com.cairone.qvl.data.enums;

public enum Region {
    NORTH_AMERICA(1),
    LATAM(2),
    EUROPE(3),
    ASIA(4),
    AFRICA(5),
    OCEANIA(6),
    MIDDLE_EAST(7),
    ANTARTICA(8),
    ;

    private int value;

    private Region(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static Region of(int dbValue) {
        switch (dbValue) {
            case 1:
                return NORTH_AMERICA;
            case 2:
                return LATAM;
            case 3:
                return EUROPE;
            case 4:
                return ASIA;
            case 5:
                return AFRICA;
            case 6:
                return OCEANIA;
            case 7:
                return MIDDLE_EAST;
            case 8:
                return ANTARTICA;
        default:
                return LATAM;
        }
    }
}