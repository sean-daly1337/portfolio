package sean.app.ui.activities.home_menu.public_user.bookings;

import sean.app.R;
import sean.app.ui.activities.BaseActivity;

public class MyBarcodeActivity extends BaseActivity {

    @Override
    public int getView() {

        return R.layout.activity_booking_scanbarcode;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_booking);
    }
}