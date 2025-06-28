
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import com.praveen.battle.BattleOutcome;

public class BattleOutcomeTest {

    @Test
    public void testEnumValuesExist() {
        assertNotNull(BattleOutcome.valueOf("WIN"));
        assertNotNull(BattleOutcome.valueOf("LOSS"));
        assertNotNull(BattleOutcome.valueOf("DRAW"));
    }
}
