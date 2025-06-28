package com.praveen.battle;

import java.util.*;
import java.util.stream.Collectors;

public class BattleSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Medieval Battle Simulator ===");

        while (true) {
            System.out.println("\nEnter your 5 platoons (format: Class#Count;Class#Count;...):");
            List<Platoon> yourPlatoons = readPlatoons(scanner);

            System.out.println("Enter enemy's 5 platoons (format: Class#Count;Class#Count;...):");
            List<Platoon> enemyPlatoons = readPlatoons(scanner);

            if (yourPlatoons.size() != 5 || enemyPlatoons.size() != 5) {
                System.out.println("Each side must have exactly 5 platoons. Exiting...");
                return;
            }

            List<Platoon> winningArrangement = BattleStrategy.findWinningArrangement(yourPlatoons, enemyPlatoons);

            if (winningArrangement == null) {
                System.out.println("There is No Chance of Winning.");
            } else {
                System.out.print("Winning arrangement: ");
                String arrangementLine = winningArrangement.stream()
                        .map(Platoon::toString)
                        .collect(Collectors.joining(";"));
                System.out.println(arrangementLine);
                printBattleResults(winningArrangement, enemyPlatoons);
            }

            System.out.print("\nRun another simulation? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("y")) {
                System.out.println("Exiting the simulator. Goodbye!");
                break;
            }
        }
    }

    private static List<Platoon> readPlatoons(Scanner scanner) {
        String input = scanner.nextLine();
        return parsePlatoonLine(input);
    }

    private static List<Platoon> parsePlatoonLine(String line) {
        return Arrays.stream(line.split(";"))
                .map(BattleSimulator::parsePlatoon)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static Platoon parsePlatoon(String token) {
        try {
            String[] parts = token.trim().split("#");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid format");
            }

            String unitClass = parts[0].trim();
            int count = Integer.parseInt(parts[1].trim());

            if (count < 0) {
                throw new NumberFormatException("Negative soldier count");
            }

            return new Platoon(unitClass, count);
        } catch (Exception e) {
            System.out.println("Skipping invalid entry: " + token);
            return null;
        }
    }

    private static void printBattleResults(List<Platoon> yourPlatoons, List<Platoon> enemyPlatoons) {
        System.out.println("\nBattle Results:");
        int winCount = 0;

        for (int i = 0; i < 5; i++) {
            Platoon yours = yourPlatoons.get(i);
            Platoon enemy = enemyPlatoons.get(i);
            BattleOutcome outcome = BattleEvaluator.evaluate(yours, enemy);

            if (outcome == BattleOutcome.WIN) {
                winCount++;
            }

            System.out.println(yours + " vs " + enemy + " => " + outcome);
        }

        System.out.println("\nFinal Result: " + winCount + " Wins, " + (5 - winCount) + " Losses or Draws");
    }
}
