package Bill;

import Member.MemberAccount;
import Response.Response;

import java.time.LocalDate;

public abstract class BillService {

    public abstract Response makePayment(int billType, String memberCode, double amount, LocalDate date);

    public abstract Response queryBill(int billType, String memberCode);

    public abstract Response cancelPayment(int billType, String memberCode, double amount, LocalDate date);
}
