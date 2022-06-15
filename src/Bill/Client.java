package Bill;

import CustomExceptions.BillNotFoundException;
import CustomExceptions.InvalidPhoneNumberException;
import CustomExceptions.MemberNotFoundException;
import Member.MemberAccount;
import Queries.Query;
import Response.Response;

import java.util.List;

//Extends BillService, a safer way for members to query bills
public class Client  extends BillService{

    private List<Bill> bills;
    private List<MemberAccount> members;



    /**
     * A safer way to query bills, requires phone number and makes validation on membercode and phone number
     * @param billType integer which indicates the type of bill
     * @param memberCode string which is unique to all members
     * @param phoneNumber phone number of member
     * @return Response.0 if process is succesfull, Response.1 otherwise
     */
    public Response queryBill(int billType, String memberCode, String phoneNumber){
        try{
            MemberAccount member = Query.queryMember(memberCode, members);
            if(!member.getPhoneNumber().equals(phoneNumber)){
                throw new InvalidPhoneNumberException();
            }
            Bill bill = Query.queryBillByMember(billType, bills, member);
            System.out.println("Ödenecek tutar: " + bill.getAmount());
        }catch(MemberNotFoundException e){
            e.getMessage();
            return Response.Res1;
        }catch(InvalidPhoneNumberException e){
            e.getMessage();
            return Response.Res1;
        }catch(BillNotFoundException e) {
            e.getMessage();
            return Response.Res1;
        }
        return Response.Res0;
    }


}
