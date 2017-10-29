package mywater.mywater.Authentication;

/**
 * Created by tyrin on 8/10/17.
 */

public class RegistrationData {
    private  String name;
    private  String phone;
    private  String password;
    public RegistrationData(String name, String phone,String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }
    public String getFirstName() {
        return this.name;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getPassword() {
        return this.password;
    }

}
