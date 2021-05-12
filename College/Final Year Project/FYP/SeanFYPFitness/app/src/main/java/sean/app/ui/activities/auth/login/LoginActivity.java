package sean.app.ui.activities.auth.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.gd70.android.validator.ValidatorEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import sean.app.R;
import sean.app.data.model.PublicUser;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.auth.registration.RegisterActivity;
import sean.app.ui.activities.home_menu.admin.AdminHomeActivity;
import sean.app.ui.activities.home_menu.public_user.home.HomeActivity;
import sean.app.utils.Constants;
import sean.app.utils.Utils;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private ValidatorEditText emailEditText;
    private ValidatorEditText passwordEditText;

    private RadioGroup loginTypeRadioGroup;
    private ProgressBar progressBar;

    private TextView openRegisterTextView;

    @Override
    public int getView() {
        return R.layout.activity_login;
    }

    @Override
    public void setActivityData() {

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        emailEditText = findViewById(R.id.edt_email);
        passwordEditText = findViewById(R.id.edt_password);
        loginTypeRadioGroup = findViewById(R.id.rg_login_type);

        progressBar.setVisibility(View.INVISIBLE);

        openRegisterTextView = findViewById(R.id.tv_open_register);
        openRegisterTextView.setOnClickListener(this);

        FirebaseAuth.getInstance().signOut();
        CurrentDatabase.setCurrentPublicUser(null);
        Utils.clearSharedPrefs(getApplicationContext());

    }

    public void onLoginUserPressed(View view) {
        String loginType = getSelectedOption();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (loginType.isEmpty()) {
            warning("Please select an account type");
            return;
        }
        if (email.isEmpty() || password.isEmpty()) {
            warning("Please fill all the fields to continue");
            return;
        }
        if (!Utils.validateEmail(email)) {
            warning("Invalid email");
            return;
        }

        if (!Utils.validatePassword(password)) {
            warning("Invalid password length");
            return;
        }

        loginUser(email, password, loginType);
    }

    private String getSelectedOption() {
        int radioId = loginTypeRadioGroup.getCheckedRadioButtonId();

        if (radioId == R.id.rb_admin) {
            return "Admin";
        } else if (radioId == R.id.rb_public_user) {
            return "Public User";
        } else return "";
    }


    private void loginUser(final String email, final String password, String loginType) {
        progressBar.setVisibility(View.VISIBLE);

        if (loginType.equalsIgnoreCase("Public User")) {

            Intent finalIntent = new Intent(getApplicationContext(), HomeActivity.class);
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful() && mAuth.getCurrentUser() != null) {

                    FirebaseDatabase.getInstance()
                            .getReference("public_user_table")
                            .child(mAuth.getCurrentUser().getUid())
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    PublicUser user = snapshot.getValue(PublicUser.class);
                                    if (user != null) {
                                        if (user.getStatus().trim().equalsIgnoreCase("blocked")) {
                                            mAuth.signOut();
                                            showMessageDialog("User account is blocked by admin.\nCan not sign in. Please contact admin.");
                                        } else {
                                            new Handler(getMainLooper()).postDelayed(() -> moveToNextActivity(email, password, finalIntent), 500);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    error(Objects.requireNonNull(task.getException()).getMessage());
                                }
                            });
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    error(Objects.requireNonNull(task.getException()).getMessage());
                }
            });

        } else {
            if (FirebaseDatabaseHelper.getAdmin(email) != null) {
                CurrentDatabase.setCurrentAdmin(FirebaseDatabaseHelper.getAdmin(email));
                Log.d(TAG, "setting current admin as: " + CurrentDatabase.getCurrentAdmin().toString());
                moveToNextActivity(CurrentDatabase.getCurrentAdmin().getEmailAddress(), CurrentDatabase.getCurrentAdmin().getPassword(),
                        new Intent(getApplicationContext(), AdminHomeActivity.class));
            }

            Intent finalIntent = new Intent(getApplicationContext(), AdminHomeActivity.class);
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            new Handler().postDelayed(() -> moveToNextActivity(email, password, finalIntent), 500);

                        } else {
                            progressBar.setVisibility(View.INVISIBLE);
                            error(Objects.requireNonNull(task.getException()).getMessage());
                        }
                    });
        }

    }

    private void moveToNextActivity(String email, String password, Intent finalIntent) {
        Utils.saveDataInSharedPrefs(Constants.EMAIL, email);
        Utils.saveDataInSharedPrefs(Constants.PASSWORD, password);

        progressBar.setVisibility(View.INVISIBLE);
        success("Login Successful!");
        startActivity(finalIntent);
        finish();

    }

    @Override
    public void onClick(View view) {
        if (view == openRegisterTextView) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        }
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), (dialog, which) -> dialog.dismiss());
        Dialog alert = builder.create();
        alert.show();
    }

}