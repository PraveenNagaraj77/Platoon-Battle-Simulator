package com.praveen.battle;

import java.util.List;
import java.util.Map;

public class BattleEvaluator {
    private static final Map<String, List<String>> ADVANTAGE_MAP = Map.of(
            "Militia", List.of("Spearmen", "LightCavalry"),
            "Spearmen", List.of("LightCavalry", "HeavyCavalry"),
            "LightCavalry", List.of("FootArcher", "CavalryArcher"),
            "HeavyCavalry", List.of("Militia", "FootArcher", "LightCavalry"),
            "CavalryArcher", List.of("Spearmen", "HeavyCavalry"),
            "FootArcher", List.of("Militia", "CavalryArcher")
    );

    public static BattleOutcome evaluate(Platoon yourPlatoon, Platoon enemyPlatoon){
        int yourCount  = yourPlatoon.getSoldiers();
        int enemyCount = enemyPlatoon.getSoldiers();
        String yourClass = yourPlatoon.getUnitClass();
        String enemyClass = enemyPlatoon.getUnitClass();


        if(ADVANTAGE_MAP.getOrDefault(yourClass,List.of()).contains(enemyClass)){
            yourCount*=2;
        }

        if(yourCount > enemyCount) return BattleOutcome.WIN;
        else if (yourCount == enemyCount) return BattleOutcome.DRAW;
        else return BattleOutcome.LOSS;

    }




}
