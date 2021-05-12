package sean.app.data.model;

import sean.app.utils.Utils;

import java.io.Serializable;

public class Admin extends User implements Serializable {

    private String adminCode;

    public Admin() {
    }

    public Admin(String accountType, String name, String emailAddress,
                 String password, String phoneNumber, String adminCode) {
        super(accountType, Utils.generateUUID(), name, emailAddress, password, phoneNumber);
        this.adminCode = adminCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Override
    public String toString() {
        return super.toString() + "Admin{" +
                "adminCode='" + adminCode + '\'' +
                '}';
    }
}
