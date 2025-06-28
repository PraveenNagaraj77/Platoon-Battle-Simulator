
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


import com.praveen.battle.Platoon;
import com.praveen.battle.BattleStrategy;

public class BattleStrategyTest {

    @Test
    public void testFindWinningArrangement() {
        List<Platoon> yourPlatoons = Arrays.asList(
                new Platoon("Militia", 50),
                new Platoon("Spearmen", 50),
                new Platoon("LightCavalry", 50),
                new Platoon("HeavyCavalry", 50),
                new Platoon("FootArcher", 50)
        );

        List<Platoon> enemyPlatoons = Arrays.asList(
                new Platoon("Spearmen", 30),
                new Platoon("LightCavalry", 30),
                new Platoon("FootArcher", 30),
                new Platoon("Militia", 30),
                new Platoon("CavalryArcher", 30)
        );

        List<Platoon> result = BattleStrategy.findWinningArrangement(yourPlatoons, enemyPlatoons);
        assertNotNull(result, "Result should not be null");
        assertEquals(5, result.size(), "Result should contain exactly 5 platoons");
    }
}
