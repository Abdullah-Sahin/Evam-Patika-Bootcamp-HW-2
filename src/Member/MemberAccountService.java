package Member;

import CustomExceptions.MemberNotFoundException;
import Queries.Query;

import java.util.LinkedList;
import java.util.List;

//This class conducts the necessary operations belonging to MemberAccount class
public class MemberAccountService {

    private List<MemberAccount> members = new LinkedList<>();

    public List<MemberAccount> readAllMembers(){
        return members;
    }

    /**
     * Queries for the member with given member code
     * @param memberCode the unique string for each member
     * @return the member with given memborcode if exists, null otherwise
     */
    public MemberAccount readOneMemberByCode(String memberCode){
        try {
            return Query.queryMember(memberCode, members);
        } catch (MemberNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Takes a member as a parameter, and adds it to list
     * @param memberAccount the member account to be added to member-list
     * @return the member created
     */
    public MemberAccount createAcoount(MemberAccount memberAccount){
        members.add(memberAccount);
        return memberAccount;
    }

    /**
     * Queries for the member with given member code, then updates features according to given parameters
     * @param memberCode the unique string for each member
     * @return the member with given memborcode and updated values if exists, null otherwise
     */
    public MemberAccount updateAccount(String memberCode, double balance, String phoneNumber){
        try{
            MemberAccount memberToUpdate = Query.queryMember(memberCode, members);
            memberToUpdate.setBalance(balance);
            memberToUpdate.setPhoneNumber(phoneNumber);
            return memberToUpdate;
        }catch(MemberNotFoundException e){
            e.getMessage();
        }
        return null;
    }

    /**
     * Queries for the member with given member code and removes it from the list
     * @param memberCode the unique string for each member
     * @return the member-to-delete with given memborcode if exists, null otherwise
     */
    public MemberAccount deleteAccount(String memberCode){
        try{
            MemberAccount memberTodelete = Query.queryMember(memberCode, members);
            members.remove(memberTodelete);
            return memberTodelete;
        }catch (MemberNotFoundException e){
            e.getMessage();
        }
        return null;
    }
}
