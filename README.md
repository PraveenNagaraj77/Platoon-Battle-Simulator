# Platoon Battle Simulator

This is a Java console application that simulates battles between your army and an opponent's army. Each side has 5 platoons, and the goal is to arrange your platoons in a way that wins at least 3 out of 5 battles.

## Problem Summary

- Each platoon has a class and a number of soldiers.
- Some classes have advantages over others.
- If a class has an advantage, its soldier count is considered doubled during evaluation.
- The simulator checks all permutations of your platoons to find one that wins at least 3 battles.

## Class Advantage Rules

Militia -> Spearmen, LightCavalry  
Spearmen -> LightCavalry, HeavyCavalry  
LightCavalry -> FootArcher, CavalryArcher  
HeavyCavalry -> Militia, FootArcher, LightCavalry  
CavalryArcher -> Spearmen, HeavyCavalry  
FootArcher -> Militia, CavalryArcher

## How to Run

1. Clone the repository:
2. Navigate to the Source Directory
3. Compile the Code
4. Run the application:


`git clone https://github.com/PraveenNagaraj77/Platoon-Battle-Simulator.git`

`cd Platoon-Battle-Simulator/src`

`javac com/praveen/battle/*.java`

``java com.praveen.battle.BattleSimulator``


## Sample Input 

`Enter your 5 platoons:
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120`

`Enter enemy's 5 platoons:
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100`

## Sample Output

`Winning arrangement: Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120`

`Battle Results:
Spearmen#10 vs Militia#10 => DRAW
Militia#30 vs Spearmen#10 => WIN
FootArcher#20 vs FootArcher#1000 => LOSS
LightCavalry#1000 vs LightCavalry#120 => WIN
HeavyCavalry#120 vs CavalryArcher#100 => WIN`

`Final Result: 3 Wins, 2 Losses or Draws`
