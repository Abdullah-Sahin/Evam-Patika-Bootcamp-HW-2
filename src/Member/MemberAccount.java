package Member;

// this class holds all necessary information about a member
public class MemberAccount {

    private final Long id;
    private String name;
    private String surname;
    private double balance;
    private String phoneNumber;


    // All args constructor

    public MemberAccount(Long id, String name, String surname, double balance, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }

    // Setters & Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return this.id + this.name.substring(0,2);
    }
}
