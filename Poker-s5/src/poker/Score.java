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




}
