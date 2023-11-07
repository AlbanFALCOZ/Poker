package poker;
import java.util.HashMap;
import java.util.Map;
public class Score {
    MainPoker Hand;
    int scoreMain=0;
    Map<String, Integer> scoreParRule = new HashMap<>();


    public Score(MainPoker Hand){
        this.Hand=Hand;
    }


    private void initializeScoreRules() {           //score pour chaque règle
        scoreParRule.put("HighCard", 0);
        scoreParRule.put("Pair", 1);
        scoreParRule.put("DeuxPairs", 2);
        scoreParRule.put("Brelan", 3);
        scoreParRule.put("Suite", 4);
        scoreParRule.put("Couleur", 5);
        scoreParRule.put("Full", 6);
        scoreParRule.put("Carre", 7);
    }

}
