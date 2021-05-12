package security;

import com.example.assignmenttwo.SpringApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000; // 1 day

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }
}
