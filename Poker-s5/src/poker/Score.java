package poker;
import java.util.HashMap;
import java.util.Map;
public class Score {
    MainPoker Hand;
    int scoreHand =0;
    Map<String, Integer> scoreByRule = new HashMap<>();


    public Score(MainPoker Hand){
        this.Hand=Hand;
        initializeScoreRules();
    }


    public void initializeScoreRules() {           //score pour chaque règle
        scoreByRule.put("HighCard", 0);
        scoreByRule.put("Pair", 1);
        scoreByRule.put("DeuxPairs", 2);
        scoreByRule.put("Brelan", 3);
        scoreByRule.put("Suite", 4);
        scoreByRule.put("Couleur", 5);
        scoreByRule.put("Full", 6);
        scoreByRule.put("Carre", 7);
        scoreByRule.put("QuinteFlush",8);
    }


    public int calculateScoreHand() {         //déterminer le score de la main
        if (Hand.carre()) scoreHand = scoreByRule.get("Carre");
        else if (Hand.full()) scoreHand = scoreByRule.get("Full");
        else if (Hand.couleur()) scoreHand = scoreByRule.get("Couleur");
        else if (Hand.suite()) scoreHand = scoreByRule.get("Suite");
        else if (Hand.brelan()) scoreHand = scoreByRule.get("Brelan");
        else if (Hand.deuxPaires()) scoreHand = scoreByRule.get("DeuxPairs");
        else if (Hand.pair()) scoreHand = scoreByRule.get("Pair");
        else if (Hand.quinteFlush()) scoreHand= scoreByRule.get("QuinteFlush");
        else scoreHand = scoreByRule.get("HighCard"); //aucune combinaison, carte haute

        return scoreHand;
    }





}
