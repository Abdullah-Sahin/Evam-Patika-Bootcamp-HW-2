package CustomExceptions;

//thrown when the phone number and member code do not agree
public class InvalidPhoneNumberException extends Exception {
    @Override
    public String getMessage(){
        return "Üye kodu ve numara uyumsuzluğu!!";
    }
}
