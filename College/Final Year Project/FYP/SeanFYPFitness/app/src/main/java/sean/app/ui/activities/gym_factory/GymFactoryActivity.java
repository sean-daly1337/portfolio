package sean.app.ui.activities.gym_factory;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import sean.app.R;
import sean.app.WebViewActivity;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.auth.login.LoginActivity;
import sean.app.ui.activities.auth.registration.RegisterActivity;

public class GymFactoryActivity extends BaseActivity implements View.OnClickListener {

    private Button openLoginActivityButton;
    private Button openRegisterActivityButton;

    @Override
    public int getView() {
        return R.layout.activity_gym_factory;
    }

    @Override
    public void setActivityData() {
        openLoginActivityButton = findViewById(R.id.btn_login_open);
        openRegisterActivityButton = findViewById(R.id.btn_register_open);

        openLoginActivityButton.setOnClickListener(this);
        openRegisterActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == openLoginActivityButton) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        if (view == openRegisterActivityButton) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        }

    }

    public void onTermsCondClicked(View view) {
        startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
    }
}