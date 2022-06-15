package Bill;

import CustomExceptions.BillNotFoundException;
import CustomExceptions.InsufficientBalanceException;
import CustomExceptions.MemberNotFoundException;
import Member.MemberAccount;
import Queries.Query;
import Response.Response;

import java.util.List;

//This class makes the necessary operations on bills
public class BillService {

    private List<Bill> bills;
    private List<MemberAccount> members;

    /**
     * If possible makes the payment according to parameters. Throws exception otherwise
     * @param billType integer which indicates the type of bill
     * @param memberCode string which is unique to all members
     * @return Response.0 if process is succesfull, Response.1 otherwise
     */
    public Response makePayment(int billType, String memberCode){
        try{
            MemberAccount member = Query.queryMember(memberCode, members);
            Bill billToPay = Query.queryBillByMember(billType, bills, member);
            if(member.getBalance() < billToPay.getAmount()){
                throw new InsufficientBalanceException();
            }else{
                member.setBalance(member.getBalance() - billToPay.getAmount());
            }
        }catch (MemberNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }catch (BillNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }catch (InsufficientBalanceException e){
            e.getMessage();
            return Response.Res1;
        }
        return Response.Res0;
    }

    /**
     * Tries to find the first bill according to given parameters
     * @param billType integer that indicates the type of the bill
     * @param memberCode String that is unique to all members
     * @return Response.0 if process is succesfull, Response.1 otherwise
     */
    public Response queryBill(int billType, String memberCode){
        try{
            MemberAccount member = Query.queryMember(memberCode, members);
            Bill billToPay = Query.queryBillByMember(billType, bills, member);
            System.out.println("Fatura bulundu. Miktarı: " + billToPay.getAmount());
        }catch (MemberNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }catch (BillNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }
        return Response.Res0;
    }

    /**
     * Find and calcels payment of the first bill according to given parameters
     * @param billType integer that indicates the type of the bill
     * @param memberCode String that is unique to all members
     * @return Response.0 if process is succesfull, Response.1 otherwise
     */
    public Response cancelPayment(int billType, String memberCode){
        try{
            MemberAccount member = Query.queryMember(memberCode, members);
            Bill billToCancel = Query.queryBillByMember(billType, bills, member);
            member.setBalance(member.getBalance() + billToCancel.getAmount());
        }catch (MemberNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }catch (BillNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }
        return Response.Res0;
    }
}
