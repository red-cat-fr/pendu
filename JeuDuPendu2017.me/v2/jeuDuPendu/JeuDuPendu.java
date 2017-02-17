package v2.jeuDuPendu;

import v2.Partie;
import v2.Player;
import v2.WordsGenerator;

/**
 * Created by Ice on 14/02/2017.
 */
public class JeuDuPendu implements Partie {
    /**
     * Attribute
     */
    int errorsCount;
    int errorsCountMax = 10;
    String secretWord ;
    String currentWord ;
    Player player;
    WordsGenerator wordGenerator;

	@Override
	public void setWordGenerator(WordsGenerator wordGenerator) {

		this.wordGenerator = wordGenerator ;
	}

    public void newPlay(Player player) {

        errorsCount = 0;
        this.player = player;
        randomiseSecretWord();
        setShadowWord();
    }

    private void randomiseSecretWord() {

        secretWord = wordGenerator.getWord();
    }

    private String setShadowWord() {

    	currentWord = "";
        for (int i = 0; i < secretWord.length(); i++) {
            currentWord += "_";
        }
        return currentWord;
    }

    public boolean isFinish() {

        return secretWordFound()
               || errorsCount >= errorsCountMax;
    }

    public void nextPlay() {
    	
        String proposal = player.getPlay();

        if( proposal == null)
        	return ;
        proposal = proposal.trim();
        if( proposal.isEmpty() )
        	return ;

        if (!isInWord(proposal)){
            errorsCount++;
        } else {
        	updateCurrentWord( proposal );
        }
    }

    private boolean isInWord(String proposal){
        return secretWord.contains(proposal);
    }

    private void updateCurrentWord( String proposal )
    {
        char p = proposal.charAt(0);
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i)==p){

                StringBuilder tempWord = new StringBuilder(currentWord);
                tempWord.setCharAt(i, p);

                currentWord =  tempWord.toString();
            }
        }

    }
    
    public String getState() {
        if (!isFinish()){
            return "Le Mot : "
                    + currentWord
                    + " (reste "+ (errorsCountMax-errorsCount) + " erreur(s))";
        }else {
            return result();
        }
    }

    private boolean secretWordFound() {
        if (currentWord.equals(secretWord)){
            return true;
        }else {
            return false;
        }
    }

    private String result(){
        if (secretWordFound()){return "Victory";
        }else {

            return "You're dead, le mot etait " + secretWord;
        }
    }

}
