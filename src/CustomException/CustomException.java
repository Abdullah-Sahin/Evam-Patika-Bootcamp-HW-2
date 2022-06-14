package CustomException;

public class CustomException extends Exception{

    @Override
    public String getMessage(){
        return "Insufficient balance";
    }
}
