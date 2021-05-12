package sean.app.ui.activities.auth.registration;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import sean.app.R;
import sean.app.data.model.PublicUser;
import sean.app.databinding.ActivityRegisterEditProfileBinding;
import sean.app.ui.activities.BaseActivity;
import sean.app.utils.Constants;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class RegisterFinalActivity extends BaseActivity implements View.OnClickListener {

    private ActivityRegisterEditProfileBinding binding;
    private PublicUser publicUser;

    private Uri pictureUri;

    @Override
    public int getView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_edit_profile);
        return R.layout.activity_register_edit_profile;
    }

    @Override
    public void setActivityData() {

        publicUser = new PublicUser();
        publicUser.setEmailAddress(getIntent().getStringExtra(Constants.INTENT_KEY_EMAIL));
        publicUser.setPassword(getIntent().getStringExtra(Constants.INTENT_KEY_PASSWORD));
        publicUser.setName(getIntent().getStringExtra(Constants.INTENT_KEY_NAME));

        binding.btnUpdate.setOnClickListener(this);
        binding.ivAvatar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == binding.ivAvatar) {
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                pictureUri = result.getUri();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}