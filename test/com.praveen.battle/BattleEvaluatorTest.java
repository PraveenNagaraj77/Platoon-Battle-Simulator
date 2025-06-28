
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.praveen.battle.Platoon;
import com.praveen.battle.BattleOutcome;
import com.praveen.battle.BattleEvaluator;

public class BattleEvaluatorTest {

    @Test
    public void testWinWithAdvantage() {
        Platoon p1 = new Platoon("Militia", 20);
        Platoon p2 = new Platoon("Spearmen", 15);
        BattleOutcome result = BattleEvaluator.evaluate(p1, p2);
        assertEquals(BattleOutcome.WIN, result);
    }

    @Test
    public void testLossWithoutAdvantage() {
        Platoon p1 = new Platoon("Militia", 10);
        Platoon p2 = new Platoon("HeavyCavalry", 50);
        BattleOutcome result = BattleEvaluator.evaluate(p1, p2);
        assertEquals(BattleOutcome.LOSS, result);
    }

    @Test
    public void testDraw() {
        Platoon p1 = new Platoon("FootArcher", 20);
        Platoon p2 = new Platoon("FootArcher", 20);
        BattleOutcome result = BattleEvaluator.evaluate(p1, p2);
        assertEquals(BattleOutcome.DRAW, result);
    }
}
