package aufgabe03;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    @Override public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]") || text == "") {
            if(getText().length() < 2 || text == "") {
                super.replaceText(start, end, text);
            }
        }
    }

    @Override public void replaceSelection(String text) {
        if (text.matches("[0-9]") || text == "") {
            if(getText().length() < 2 || text == ""){
                super.replaceSelection(text);
            }
        }
    }

}
