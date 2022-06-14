package Bill;

import Member.MemberAccount;
import Response.Response;

import java.time.LocalDate;

public class Client  extends BillService{

    @Override
    public Response makePayment(int billType, String memberCode, double amount, LocalDate date) {
        return null;
    }

    @Override
    public Response queryBill(int billType, String memberCode) {
        return null;
    }

    public Response queryBill(int billType, String memberCode, String phoneNumber){
        return null;
    }

    @Override
    public Response cancelPayment(int billType, String memberCode, double amount, LocalDate date) {
        return null;
    }
}
