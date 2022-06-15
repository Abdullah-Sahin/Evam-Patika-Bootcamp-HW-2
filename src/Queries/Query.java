package Queries;

import Bill.Bill;
import CustomExceptions.BillNotFoundException;
import CustomExceptions.MemberNotFoundException;
import Member.MemberAccount;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Query {

    /**
     * Finds the first bill in the list bills with given information,
     * throws relative exception if member or bill does not exist
     * @param billType integer that indicates the type of bill
     * @param bills list of all bills
     * @param member member account related to bill
     * @return the bill with given type belonging to given member account
     * @throws MemberNotFoundException when member does not exists
     * @throws BillNotFoundException when member found but there is no bill of given type for the member
     */
    public static Bill queryBillByMember(int billType, List<Bill> bills, MemberAccount member) throws MemberNotFoundException, BillNotFoundException {
        List<Bill> filteredBills = filterBills(billType, bills);
        Optional<Bill> billToPay = filteredBills.stream().filter(bill -> bill.getMember() == member).findFirst();
        if(!billToPay.isPresent()){
            throw new BillNotFoundException();
        }
        return billToPay.get();
    }

    /**
     * finds the member in the list with given code, throws exception if not found
     * @param memberCode the string that is unique for all member accounts
     * @param members list of all members
     * @return member with given member code
     * @throws MemberNotFoundException when member does not exists
     */
    public static MemberAccount queryMember(String memberCode, List<MemberAccount> members) throws MemberNotFoundException {
        Optional<MemberAccount> member = members.stream().filter(t -> t.getCode().equals(memberCode)).findFirst();
        if(!member.isPresent()){
            throw new MemberNotFoundException();
        }
        return member.get();
    }

    /**
     * Finds all bills of one type
     * @param billType the integer that indicates the type of bill
     * @param bills all bills
     * @return all bills that are of the given billtype
     */
    public static List<Bill> filterBills(int billType, List<Bill> bills){
        return bills.stream().filter(bill -> bill.getBillType() == billType).collect(Collectors.toList());
    }
}
