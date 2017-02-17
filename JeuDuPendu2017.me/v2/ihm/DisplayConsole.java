package v2.ihm;

import v2.Display;

/**
 * Created by Ice on 15/02/2017.
 */
public class DisplayConsole implements Display {

    public void say(String message) {
        System.out.println( message );
    }
}
