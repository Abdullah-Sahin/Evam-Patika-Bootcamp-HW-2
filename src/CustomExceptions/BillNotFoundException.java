package CustomExceptions;

//thrown when bill doesn't exists
public class BillNotFoundException extends Exception {
    @Override
    public String getMessage(){
        return "Fatura bulunamadı";
    }
}
