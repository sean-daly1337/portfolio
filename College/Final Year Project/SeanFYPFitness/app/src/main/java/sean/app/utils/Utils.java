package sean.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.ApplicationContext;
import sean.app.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.dmoral.toasty.Toasty;

import static sean.app.utils.Constants.INIT_LOGIN;

public class Utils {

    public static final String PUBLIC_USER_TYPE = "PUBLIC_USER";
    public static final String ADMIN_TYPE = "ADMIN";

    public static final String ACCEPTED = "ACCEPTED";
    public static final String REJECTED = "REJECTED";
    public static final String PENDING = "PENDING";


    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(CharSequence emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validatePassword(CharSequence passwordStr) {
        return passwordStr.length() >= 6;
    }

    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static void loadImage(Context context, String userId, ImageView imageView) {
        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("user_profile_pictures/" + userId + ".png");

        mStorageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Glide.with(context)
                    .load(uri.toString())
                    .placeholder(R.drawable.ic_avatar)
                    .into(imageView);
        });
    }

    public static void uploadImage(String id, Uri imageUri) {
        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("user_profile_pictures/" + id + ".png");

        mStorageRef.putFile(imageUri);
    }


    public static void success(Context context, String message) {
        Toasty.success(context, message, Toasty.LENGTH_SHORT, true).show();
    }

    public static void error(Context context, String message) {
        Toasty.error(context, message, Toasty.LENGTH_SHORT, true).show();
    }

    public static void info(Context context, String message) {
        Toasty.info(context, message, Toasty.LENGTH_SHORT, true).show();
    }

    public static void warning(Context context, String message) {
        Toasty.warning(context, message, Toasty.LENGTH_SHORT, true).show();
    }

    public static void setFirstLogin() {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.INIT_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putBoolean(Constants.LOGIN_KEY, true);
        editor.apply();
    }

    public static boolean isFirstLogin() {

        boolean firstLogin;
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(INIT_LOGIN, Context.MODE_PRIVATE);
        firstLogin = settings.getBoolean(Constants.LOGIN_KEY, false);

        return firstLogin;
    }


    public static void setGymSelected() {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.INIT_GYM_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(Constants.GYM_NAME, true);
        editor.apply();
    }

    public static boolean isGymSelected() {

        boolean gymName;
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.INIT_GYM_PREF, Context.MODE_PRIVATE);
        gymName = settings.getBoolean(Constants.GYM_NAME, false);

        return gymName;
    }

    public static void saveDataInSharedPrefs(String key, String value) {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.APP_SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString(key, value);
        editor.apply();
    }

    public static void saveDataInSharedPrefs(String key, boolean value) {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.APP_SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String loadDataInSharedPrefs(String key) {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.APP_SHARED_PREF, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    public static boolean loadSavedSwitchData(String key) {
        SharedPreferences settings = ApplicationContext.getContext().getSharedPreferences(Constants.APP_SHARED_PREF, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }

    public static void clearSharedPrefs(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.EMAIL, "").apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.PASSWORD, "").apply();
    }

    public static String timeStampToClock(Long bookingDate) {
        Date date = new Date(bookingDate);
        Format format = new SimpleDateFormat("dd/MM");
        return format.format(date);
    }
}
