package dto;

public class AgentsDto {

    private String name;
    private String phone;
    private String fax;
    private String email;
    private String username;
    private String password;

    public AgentsDto() {
    }

    public AgentsDto(String name, String phone, String fax, String email, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AgentsDto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
