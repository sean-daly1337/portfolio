package sean.app.ui.activities.home_menu.public_user.home;

import sean.app.R;
import sean.app.ui.activities.BaseActivity;

public class BarcodeScanResultActivity extends BaseActivity {

    @Override
    public int getView() {

        return R.layout.activity_home_scanbarcode_result;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_home);
    }
}