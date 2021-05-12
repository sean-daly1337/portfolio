package sean.app.ui.activities.home_menu.public_user.bookings;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import sean.app.R;

public class UserBarCodeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bar_code_view);
    }

    public void onBackPress(View view) {
        finish();
    }

}