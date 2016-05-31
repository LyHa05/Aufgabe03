package aufgabe03;

import javafx.scene.control.TextField;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'NumberTextField' beschraenkt TextField, um nur zweistellige Zahlen eingeben zu können.
 */

public class NumberTextField extends TextField {

    /**Methode beschraenkt Textfelder fuer Zahleneingabe*/
    @Override public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]") || text == "") {
            if(getText().length() < 2 || text == "") {
                super.replaceText(start, end, text);
            }
        }
    }

    /**Methode beschraenkt Textfelder fuer Zahleneingabe*/
    @Override public void replaceSelection(String text) {
        if (text.matches("[0-9]") || text == "") {
            if(getText().length() < 2 || text == ""){
                super.replaceSelection(text);
            }
        }
    }

}
