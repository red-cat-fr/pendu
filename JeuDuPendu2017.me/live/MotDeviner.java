package live;

/**
 * Created by jeromeheissler on 17/01/2017.
 */
public class MotDeviner {

    private String leMot;
    //private StringBuilder leMotCache;
    private String leMotCache;

    public MotDeviner(String mot) {
        leMot = mot;
        //leMotCache = new StringBuilder();
        leMotCache = "";
        for(int i = 0; i < mot.length(); i++) {
            //leMotCache.append("-");
            leMotCache += "-";
        }
    }

    public String getLeMotCache() {
        return leMotCache.toString();
    }

    public boolean trouver() {
        return leMotCache.toString().equals(leMot);
    }

    public boolean contient(char lettre) {
        boolean contains = leMot.contains(lettre+"");

        if(contains) {
            int position = leMot.indexOf(lettre);
            while (position != -1) {
                char[] allChar = leMotCache.toCharArray();
                allChar[position] = lettre;
                leMotCache = new String(allChar);

                //leMotCache.setCharAt(position, lettre);

                position= leMot.indexOf(lettre, position+1);
            }
        }

        return contains;
    }
}
