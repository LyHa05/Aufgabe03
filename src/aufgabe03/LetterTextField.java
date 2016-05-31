package aufgabe03;

import javafx.scene.control.TextField;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse beschraenkt TextField, um nur Buchstaben eingeben zu koennen.
 */

public class LetterTextField extends TextField {

    /**Methode beschraenkt Textfelder fuer Buchstabeneingabe*/
    @Override
    public void replaceText(int start, int end, String text) {
        if (text.matches("[A-Za-z]") || text == "") {
            super.replaceText(start, end, text);
        }
    }

    /**Methode beschraenkt Textfelder fuer Buchstabeneingabe*/
    @Override
    public void replaceSelection(String text) {
        if (text.matches("[A-Za-z]") || text == "") {
            super.replaceSelection(text);
        }
    }

}
