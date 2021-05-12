package shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public boolean validateData(String... args) {
        for (String arg : args) {
            if (arg.isEmpty())
                return false;
        }
        return true;
    }

    public void debug(String message) {
        System.out.println(message);
    }

    public void debug(int message) {
        System.out.println(message);
    }

    public void debug(double message) {
        System.out.println(message);
    }

    public void debug(char message) {
        System.out.println(message);
    }


    public Timestamp parseDate(String startDate) throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(startDate);
        return new Timestamp(date.getTime());
    }

    public boolean isNumeric(String string) {
        if (string.length() == 0)
            return false; //To check if string is empty

        if (string.charAt(0) == '-')
            string = string.replaceFirst("-", "");// for handling -ve numbers

        System.out.println(string);

        string = string.replaceFirst("\\.", ""); //to check if it contains more than one decimal points

        if (string.length() == 0)
            return false; // to check if it is empty string after removing -ve sign and decimal point
        System.out.println(string);

        return string.replaceAll("[0-9]", "").length() == 0;
    }
}
