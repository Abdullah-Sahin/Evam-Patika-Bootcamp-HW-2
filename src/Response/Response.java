package Response;

import Help.Help;

public enum Response {

    // Called when process is successfull
    Res0("0", Help.getCurrentDate()),
    // Called when process is not successfull
    Res1("1", Help.getCurrentDate());


    /**
     * Constructor of class that also writes whether the process is successful on the console
     * @param code 1-digit code that indicates whether process is successful
     * @param date date of process
     */
    Response(String code, String date){
        if(code.equals("0")){
            System.out.println("İşlem Başarılı. Düzenlenme Tarihi: " + date);
        }
        else{
            System.out.println("İşlem Başarısız. Düzenlenme Tarihi: " + date);
        }
    }
}
