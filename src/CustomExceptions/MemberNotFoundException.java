package CustomExceptions;

//thrown when member not found
public class MemberNotFoundException extends Exception {

    @Override
    public String getMessage(){
        return "Kullanıcı Bulunamadı";
    }
}
