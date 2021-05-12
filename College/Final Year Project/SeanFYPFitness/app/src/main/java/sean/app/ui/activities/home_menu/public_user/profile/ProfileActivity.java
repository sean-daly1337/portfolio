package sean.app.ui.activities.home_menu.public_user.profile;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gd70.android.validator.ValidatorEditText;
import com.google.firebase.auth.FirebaseAuth;
import sean.app.R;
import sean.app.data.model.PublicUser;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.auth.login.LoginActivity;
import sean.app.utils.Utils;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private ImageView userAvatar;
    private TextView usernameTextView;

    private ValidatorEditText fullNameEditText;
    private ValidatorEditText emailEditText;
    private ValidatorEditText dobEditText;

    private Button editDetailsImageView;

    private TextView currentBalanceTextView;

    private Button editCardImageView;

    private EditText cardNumberEditText;
    private EditText cardNameEditText;
    private EditText cardExpiryEditText;

    @Override
    public int getView() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_profile);

        userAvatar = findViewById(R.id.iv_user_avatar);
        usernameTextView = findViewById(R.id.tv_username);

        userAvatar.setOnClickListener(this);

        fullNameEditText = findViewById(R.id.edt_user_name);
        emailEditText = findViewById(R.id.edt_email);
        dobEditText = findViewById(R.id.edt_dob);

        emailEditText.setEnabled(false);

        fullNameEditText.setText(CurrentDatabase.getCurrentPublicUser().getName());
        emailEditText.setText(CurrentDatabase.getCurrentPublicUser().getEmailAddress());
        dobEditText.setText(CurrentDatabase.getCurrentPublicUser().getDateOfBirth());

        editDetailsImageView = findViewById(R.id.iv_edit_details);
        editDetailsImageView.setOnClickListener(this);

        usernameTextView.setText(CurrentDatabase.getCurrentPublicUser().getName());
        Utils.loadImage(getApplicationContext(), CurrentDatabase.getCurrentPublicUser().getUserId(), userAvatar);

        currentBalanceTextView = findViewById(R.id.tv_current_balance);
        editCardImageView = findViewById(R.id.iv_card_edit);
        editCardImageView.setOnClickListener(this);

        cardNumberEditText = findViewById(R.id.tv_card_number);
        cardNameEditText = findViewById(R.id.tv_name);
        cardExpiryEditText = findViewById(R.id.tv_expiry);

        cardNumberEditText.setText(CurrentDatabase.getCurrentPublicUser().getCardNumber());
        cardNameEditText.setText(CurrentDatabase.getCurrentPublicUser().getCardName());
        cardExpiryEditText.setText(CurrentDatabase.getCurrentPublicUser().getCardExpiry());

    }

    public void openBmiActivity(View view) {
        startActivity(new Intent(this, BmiActivity.class));
    }

    public void openSettingActivity(View view) {
        startActivity(new Intent(this, SettingActivity.class));
    }

    public void logoutUser(View view) {
        CurrentDatabase.setCurrentPublicUser(null);
        Utils.clearSharedPrefs(getApplicationContext());
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view == userAvatar) {// start picker to get image for cropping and then use the image in cropping activity
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);

        }

        if (view == editDetailsImageView) {
            String fullName = fullNameEditText.getText().toString().trim();
            String dob = dobEditText.getText().toString().trim();

            if (fullName.isEmpty() || dob.isEmpty()) {
                Utils.warning(getApplicationContext(), "Invalid Data");
                return;
            }
            PublicUser publicUser = CurrentDatabase.getCurrentPublicUser();
            publicUser.setName(fullName);
            publicUser.setDateOfBirth(dob);
            CurrentDatabase.setCurrentPublicUser(publicUser);
            FirebaseDatabaseHelper.updatePublicUser(CurrentDatabase.getCurrentPublicUser());
            Utils.success(getApplicationContext(), "Data updated");
        }

        if (view == editCardImageView) {
            String cardNumber = cardNumberEditText.getText().toString().trim();
            String cardName = cardNameEditText.getText().toString().trim();
            String cardExpiry = cardExpiryEditText.getText().toString().trim();

            if (cardNumber.isEmpty() || cardName.isEmpty() || cardExpiry.isEmpty()) {
                Utils.warning(getApplicationContext(), "Invalid Data");
                return;
            } else {

                PublicUser publicUser = CurrentDatabase.getCurrentPublicUser();
                publicUser.setCardNumber(cardNumber);
                publicUser.setCardName(cardName);
                publicUser.setCardExpiry(cardExpiry);
                CurrentDatabase.setCurrentPublicUser(publicUser);
                FirebaseDatabaseHelper.updatePublicUser(CurrentDatabase.getCurrentPublicUser());
                Utils.success(getApplicationContext(), "Data updated");
            }

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                userAvatar.setImageURI(resultUri);
                Utils.uploadImage(CurrentDatabase.getCurrentPublicUser().getUserId(), resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}