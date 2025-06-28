package com.praveen.battle;

public class Platoon {


    private final String unitClass;
    private final int soldiers;


    public Platoon(String unitClass,int soldiers){
        this.unitClass = unitClass;
        this.soldiers = soldiers;
    }

    public String getUnitClass(){
        return unitClass;
    }

    public int getSoldiers(){
        return soldiers;
    }

    public String toString(){
        return unitClass + "#" + soldiers;
    }



}
