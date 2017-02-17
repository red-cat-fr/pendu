package v2;

/**
 * Created by Ice on 14/02/2017.
 */
public interface Partie {

    void newPlay(Player player);

    boolean isFinish();

    void nextPlay();

    String getState();

	void setWordGenerator(WordsGenerator wg);

}
