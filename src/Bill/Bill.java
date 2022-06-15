package Bill;

import Member.MemberAccount;

import java.time.LocalDate;

// Objects from the class holds informations of type, amount, date and person who is to pay
public class Bill {

    private Long id;
    private int billType;
    private double amount;
    private LocalDate processDate;
    private MemberAccount member;

    public Bill(Long id, int billType, double amount, LocalDate processDate, MemberAccount memberAccount) {
        this.id = id;
        this.billType = billType;
        this.amount = amount;
        this.processDate = processDate;
        this.member = memberAccount;
    }

    // Gettsers & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getProcessDate() {
        return processDate;
    }

    public void setProcessDate(LocalDate processDate) {
        this.processDate = processDate;
    }

    public MemberAccount getMember() {
        return member;
    }

    public void setMember(MemberAccount member) {
        this.member = member;
    }
}
