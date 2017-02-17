package v2.jeuDuPendu;

import v2.Player;
import v2.Saisie;


/**
 * Created by Ice on 14/02/2017.
 */
public class JoueurDuPendu implements Player {

	protected String name ;

	Saisie saisie ;
	
	@Override
	public void setSaisie(Saisie saisie) {
		
		this.saisie = saisie ;
	}

	public String getPlay() {
    	
        String sl = saisie.lireChaine("Veuillez saisir votre lettre : ");
        return sl;
    }

    public String getName(){

    	return name ;
    }

    public String askName(){
    	
        name = saisie.lireChaine("Veuillez entrer votre nom : ");
        return name ;
    }

}
