package reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Р›РёР·Р°
 * Date: 15.11.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class Russian extends Language {
    private static String[] beforeName = {"г","ул","пр","ш"};
    
    public Russian(){
        setName("ru");
    }
    
    @Override
    public boolean isName(String word) {
        for (String before : beforeName) {
            if (word.equals(before)) {
                return true;
            }
        }
        return false;
    }
}
