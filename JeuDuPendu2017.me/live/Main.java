package live;

/**
 * Created by jeromeheissler on 17/01/2017.
 */
public class Main {

    public static void main(String[] args) {

        String s = Saisie.readChaine("Donne moi un mot : ");
        
        int nombreDeErreur = 1;

        MotDeviner motDeviner = new MotDeviner(s);
        while (!motDeviner.trouver() && nombreDeErreur > 0) {
            
        	System.out.println(motDeviner.getLeMotCache());
            
            String text = Saisie.readChaine("Saisie une lettre : ");
            
            if(!text.isEmpty()) {
                char c = text.charAt(0);
                if(!motDeviner.contient(c)) {
                    nombreDeErreur--;
                }
            }
        }

    }

}
