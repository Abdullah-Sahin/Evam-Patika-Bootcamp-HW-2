package Help;

import java.time.LocalDate;

public class Help {

    /**
     *
     * @return the string value of current date
     */
    public static String getCurrentDate(){
        return LocalDate.now().toString();
    }
}
