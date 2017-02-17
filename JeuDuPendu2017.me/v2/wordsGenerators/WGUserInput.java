package v2.wordsGenerators;

import v2.Saisie;
import v2.WordsGenerator;

/**
 * Saisie du mot au clavier
 *
 */
public class WGUserInput implements WordsGenerator {

    private Saisie saisie;

    public WGUserInput( Saisie saisie )
    {
        this.saisie = saisie ;
    }

    @Override
    public String getWord() {

        return saisie.lireChaine("Indiquez le mot à deviner: ");
    }

}