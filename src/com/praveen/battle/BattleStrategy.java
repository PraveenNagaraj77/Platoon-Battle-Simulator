package com.praveen.battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BattleStrategy {
    public static List<Platoon> findWinningArrangement(List<Platoon> yours,List<Platoon> enemies){
        List<List<Platoon>> permutations = new ArrayList<>();
        permute(yours, 0, permutations);



        for (List<Platoon> arrangement : permutations){
            int wins =0;
            for (int i = 0; i < 5; i++) {
                BattleOutcome outcome = BattleEvaluator.evaluate(arrangement.get(i),enemies.get(i));
                if (outcome == BattleOutcome.WIN) wins++;
            }
            if(wins>=3) return  arrangement;
        }
        return  null;

    }


    private static void permute(List<Platoon> list , int index ,List<List<Platoon>> result){
        if(index == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            Collections.swap(list,i,index);
            permute(list,index + 1,result);
            Collections.swap(list,i,index);
        }
    }
}
