package Member;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MemberAccountService {

    private List<MemberAccount> members = new LinkedList<>();

    public List<MemberAccount> readAllMembers(){
        return members;
    }

    public Optional<MemberAccount> readOneMemberByCode(String memberCode){
        return members.stream().filter(member -> member.getCode().equals(memberCode)).findFirst();
    }

    public MemberAccount createAcoount(Long id, String name, String surname, double balance, String phoneNumber){
        return new MemberAccount(id, name, surname, balance, phoneNumber);
    }

    public MemberAccount updateAccount(String memberCode, double balance, String phoneNumber){
        Optional<MemberAccount> memberToUpdate = members.stream().filter(member -> member.getCode().equals(memberCode)).findFirst();
        if(memberToUpdate.isPresent()){
            MemberAccount member = memberToUpdate.get();
            member.setBalance(balance);
            member.setPhoneNumber(phoneNumber);
            return member;
        }
        return null;
    }

    public MemberAccount deleteAccount(String memberCode){
        Optional<MemberAccount> memberTodelete = members.stream().filter(member -> member.getCode().equals(memberCode)).findFirst();
        if(memberTodelete.isPresent()){
            members.remove(memberTodelete.get());
            return memberTodelete.get();
        }
        return null;
    }
}
