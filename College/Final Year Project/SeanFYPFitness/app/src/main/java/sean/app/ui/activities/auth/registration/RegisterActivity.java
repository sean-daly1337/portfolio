package sean.app.ui.activities.auth.registration;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gd70.android.validator.ValidatorEditText;
import sean.app.R;
import sean.app.data.model.PublicUser;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.auth.login.LoginActivity;
import sean.app.ui.activities.gym_factory.GymFactoryActivity;
import sean.app.utils.Constants;
import sean.app.utils.Utils;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ValidatorEditText nameEditText;
    private ValidatorEditText emailEditText;
    private ValidatorEditText passwordEditText;
    private ValidatorEditText confirmPasswordEditText;

    private ProgressBar progressBar;

    private TextView loginAccountTextView;

    private PublicUser publicUser;

    @Override

    public int getView() {
        return R.layout.activity_register;

    }

    @Override
    public void setActivityData() {

        nameEditText = findViewById(R.id.edt_name);
        emailEditText = findViewById(R.id.edt_email);
        passwordEditText = findViewById(R.id.edt_password);
        confirmPasswordEditText = findViewById(R.id.edt_repeat_password);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        loginAccountTextView = findViewById(R.id.tv_login_account);
        loginAccountTextView.setOnClickListener(this);
    }

    public void onRegisterUserClicked(View view) {
        registerNewUser();
    }

    private void registerNewUser() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            warning("Please fill all the fields to continue");
            return;
        }
        if (!Utils.validateEmail(email)) {
            warning("Invalid email");
            return;
        }

        if (!Utils.validatePassword(password)) {
            warning("Invalid password");
            return;
        }

        if (!password.equals(confirmPassword)) {
            warning("Passwords doesn't match");
            return;
        }

        if (FirebaseDatabaseHelper.getPublicUserByEmail(email) != null) {
            error("User already registered");
            return;
        }

        publicUser = new PublicUser(Constants.PUBLIC_USER, name, email, password,
                "", "", "1234 5678 1234 2123", "CARD HOLDER", "12/32");
        FirebaseDatabaseHelper.createPublicUser(publicUser, null);

        //REMINDER: uncomment this block of code if database is cleaned and fresh copy of admin is required
//        Admin admin = new Admin(Constants.ADMIN_USER, name, email, password, "", "123");
//        FirebaseDatabaseHelper.createAdmin(admin, null);

        progressBar.setVisibility(View.VISIBLE);

        new FirebaseDatabaseHelper();

        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.INVISIBLE);
            success("User created successfully, please login!");
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }, 5000);
    }

    @Override
    public void onClick(View view) {
        if (view == loginAccountTextView) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), GymFactoryActivity.class));

    }
}