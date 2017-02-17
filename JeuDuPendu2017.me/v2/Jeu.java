package v2;

import v2.ihm.DisplayConsole;
import v2.ihm.SaisieConsole;
import v2.jeuDuPendu.JeuDuPendu;
import v2.jeuDuPendu.JoueurDuPendu;
import v2.wordsGenerators.WGUserInput;

import java.io.FileNotFoundException;

/**
 * Created by Ice on 14/02/2017.
 */
public class Jeu {
 
	public static void main(String[] args) throws FileNotFoundException {




			PicoDi pdi = new PicoDi();
            Display display = new DisplayConsole();

            Saisie saisie = new SaisieConsole();

            Player player = new JoueurDuPendu();
            player.setSaisie(saisie);

             WordsGenerator wg = new WGUserInput(saisie);
            //WordsGenerator wg = new WGArray();
            //WordsGenerator wg = new WGOnline();

            Partie partie = new JeuDuPendu();
            partie.setWordGenerator(wg);


        String play = "y";
        while (play.equals("y")) {
            partie.newPlay(player);

            display.say("Bonjour " + player.askName());

            display.say(partie.getState());

            while (!partie.isFinish()) {
                display.say("Indiquez une lettre");
                partie.nextPlay();
                display.say(partie.getState());
            }

            play = saisie.lireChaine("On s'en refait une ?(Y/N)");
            play.toLowerCase();

        }


    }
}
