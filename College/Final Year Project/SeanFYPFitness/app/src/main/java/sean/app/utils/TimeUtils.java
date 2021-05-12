package sean.app.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeUtils {

    public static String getReadableTime(int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        SimpleDateFormat mFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        return mFormat.format(calendar.getTimeInMillis());
    }

    public static String getReadableDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        SimpleDateFormat mFormat = new SimpleDateFormat("EEE d, MMM yyyy", Locale.ENGLISH);
        return mFormat.format(calendar.getTimeInMillis());
    }

}
