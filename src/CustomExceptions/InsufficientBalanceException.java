package CustomExceptions;

//thrown when member has not enough money to pay the bill
public class InsufficientBalanceException extends Exception {

    @Override
    public String getMessage(){
        return "Yetersiz bakiye";
    }
}
