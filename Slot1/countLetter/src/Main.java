
import controller.CountLetterProgramming;
import model.Element;
import util.Library;

public class Main {

    public static void main(String[] args) {
         Library library = new Library();
        
        Element element = new Element(library.getString("Enter Your String"));
        
        new CountLetterProgramming(element).run();
    }
}
