package sean.app.data.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PublicUser extends User implements Serializable {

    private Double moneySpent;
    private Double currentBalance;
    private String dateOfBirth;
    private String cardNumber;
    private String cardName;
    private String cardExpiry;
    private String status;
    private ArrayList<String> membershipIds;
    private ArrayList<String> bookingIds;

    public PublicUser() {
    }

    public PublicUser(String accountType, String name, String emailAddress, String password,
                      String phoneNumber, String dateOfBirth, String cardNumber, String cardName, String cardExpiry) {
        super(accountType, "", name, emailAddress, password, phoneNumber);
        this.moneySpent = 0.0;
        this.currentBalance = 0.0;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpiry = cardExpiry;
        this.status = "unblocked";
        this.membershipIds = new ArrayList<>();
        this.bookingIds = new ArrayList<>();
    }

    public Double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(Double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PublicUser{" +
                "moneySpent='" + moneySpent + '\'' +
                ", currentBalance='" + currentBalance + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", accountType='" + accountType + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
