package sean.app.ui.activities.home_menu.public_user.profile;

import android.annotation.SuppressLint;
import android.widget.Switch;

import sean.app.R;
import sean.app.ui.activities.BaseActivity;
import sean.app.utils.Constants;
import sean.app.utils.Utils;

public class SettingActivity extends BaseActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch rememberMeSwitch;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch goalsSwitch;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch activityAlertSwitch;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch workoutAlertSwitch;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch bookingAlertSwitch;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch soundsBeepSwitch;

    @Override
    public int getView() {
        return R.layout.activity_edit_profile_setting;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_profile);

        rememberMeSwitch = findViewById(R.id.switch_remember_me);
        goalsSwitch = findViewById(R.id.switch_goals);
        activityAlertSwitch = findViewById(R.id.switch_activity_alerts);
        workoutAlertSwitch = findViewById(R.id.switch_workout_alert);
        bookingAlertSwitch = findViewById(R.id.switch_booking_alert);
        soundsBeepSwitch = findViewById(R.id.switch_sounds_beeps);

        rememberMeSwitch.setChecked(Utils.loadSavedSwitchData(Constants.REMEMBER_ME));
        goalsSwitch.setChecked(Utils.loadSavedSwitchData(Constants.GOALS));
        activityAlertSwitch.setChecked(Utils.loadSavedSwitchData(Constants.ACTIVITY_ALERTS));
        workoutAlertSwitch.setChecked(Utils.loadSavedSwitchData(Constants.WORKOUT_ALERTS));
        bookingAlertSwitch.setChecked(Utils.loadSavedSwitchData(Constants.BOOKING_ALERTS));
        soundsBeepSwitch.setChecked(Utils.loadSavedSwitchData(Constants.SOUNDS_AND_BEEPS));

        rememberMeSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.REMEMBER_ME, b));
        goalsSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.GOALS, b));
        activityAlertSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.ACTIVITY_ALERTS, b));
        workoutAlertSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.WORKOUT_ALERTS, b));
        bookingAlertSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.BOOKING_ALERTS, b));
        soundsBeepSwitch.setOnCheckedChangeListener((compoundButton, b) -> Utils.saveDataInSharedPrefs(Constants.SOUNDS_AND_BEEPS, b));


    }
}