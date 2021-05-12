package sean.app.ui.activities.home_menu.public_user.home;

import android.content.Intent;
import android.view.View;

import sean.app.R;
import sean.app.ui.activities.BaseActivity;

public class BarcodeScanActivity extends BaseActivity {

    @Override
    public int getView() {

        return R.layout.activity_home_scanbarcode;
    }

    @Override
    public void setActivityData() {
        //  setBottomNavigation(R.id.navigation_home);
    }

    public void openBarCodeResult(View view) {
        startActivity(new Intent(this, BarcodeScanResultActivity.class));
    }
}