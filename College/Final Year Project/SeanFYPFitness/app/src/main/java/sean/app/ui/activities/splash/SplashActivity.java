package sean.app.ui.activities.splash;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.auth.login.LoginActivity;
import sean.app.ui.activities.find_studio.FindStudioActivity;
import sean.app.ui.activities.gym_factory.GymFactoryActivity;
import sean.app.ui.activities.home_menu.public_user.home.HomeActivity;
import sean.app.utils.Constants;
import sean.app.utils.NetworkStateReceiver;
import sean.app.utils.Utils;

public class SplashActivity extends BaseActivity implements NetworkStateReceiver.NetworkStateReceiverListener {

    private static final String TAG = "SplashActivity";

    private Snackbar snackbar;
    private NetworkStateReceiver networkStateReceiver;

    private boolean opened = true;


    @Override
    public int getView() {
        return 0;
    }

    @Override
    public void setActivityData() {

        View parentLayout = findViewById(android.R.id.content);
        snackbar = Snackbar.make(parentLayout, "Not connected to Internet! Please turn on wifi or mobile data", Snackbar.LENGTH_INDEFINITE);

        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);

        registerReceiver(networkStateReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkStateReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(networkStateReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            unregisterReceiver(networkStateReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void splashScreenTime() {

        Log.e(TAG, "In Splash Screen");

        if (Utils.isGymSelected()) {
            if (Utils.isFirstLogin()) {
                startActivity(new Intent(getApplicationContext(), GymFactoryActivity.class));
                Utils.setFirstLogin();
            } else {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        } else {
            startActivity(new Intent(getApplicationContext(), FindStudioActivity.class));
        }

    }

    @Override
    public void networkAvailable() {
        snackbar.dismiss();
        if (opened) {
            new Handler(Looper.myLooper()).postDelayed(this::splashScreenTime, 4000);
            opened = false;
        }
    }

    @Override
    public void networkUnavailable() {
        snackbar.show();
    }

}