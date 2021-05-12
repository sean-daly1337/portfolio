package sean.app.ui.activities.home_menu.public_user.profile;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import sean.app.R;
import sean.app.data.repository.CurrentDatabase;
import sean.app.ui.activities.BaseActivity;
import sean.app.utils.Utils;

public class BmiActivity extends BaseActivity implements View.OnClickListener {

    private ImageView userImageView;
    private TextView usernameTextView;

    private EditText heightEditText;
    private EditText weightEditText;

    private RadioGroup genderRadioGroup;

    private Button calculateButton;

    private TextView yourBMITextView;
    private ImageView bmiImageView;

    @Override
    public int getView() {
        return R.layout.activity_edit_profile_bmi_calculate;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_profile);

        userImageView = findViewById(R.id.img_user);
        usernameTextView = findViewById(R.id.tv_username);

        heightEditText = findViewById(R.id.edt_height);
        weightEditText = findViewById(R.id.edt_enter_weight);

        genderRadioGroup = findViewById(R.id.rg_gender);

        calculateButton = findViewById(R.id.btn_calculate);
        calculateButton.setOnClickListener(this);

        yourBMITextView = findViewById(R.id.tv_calculated_bmi);
        bmiImageView = findViewById(R.id.iv_calculated_bmi);

        Utils.loadImage(getApplicationContext(), CurrentDatabase.getCurrentPublicUser().getUserId(), userImageView);
        usernameTextView.setText(CurrentDatabase.getCurrentPublicUser().getName());

    }

    @Override
    public void onClick(View view) {
        if (view == calculateButton) {
            String height = heightEditText.getText().toString().trim();
            String weight = weightEditText.getText().toString().trim();
            String gender = "";
            int radioId = genderRadioGroup.getCheckedRadioButtonId();

            if (radioId == R.id.rb_male)
                gender = "Male";
            else if (radioId == R.id.rb_female)
                gender = "Female";

            if (height.isEmpty()) {
                Utils.warning(getApplicationContext(), "Height cannot be empty");
                return;
            }

            if (weight.isEmpty()) {
                Utils.warning(getApplicationContext(), "Weight cannot be empty");
            }

            if (TextUtils.isDigitsOnly(height) && TextUtils.isDigitsOnly(weight)) {
                double heightDouble = Double.parseDouble(height);
                double weightDoble = Double.parseDouble(weight);

                double bmi = weightDoble / (heightDouble / 100);
                String calculatedBmi = "Your BMI is: " + bmi;

                yourBMITextView.setText(calculatedBmi);
                yourBMITextView.setVisibility(View.VISIBLE);
                bmiImageView.setVisibility(View.VISIBLE);

                heightEditText.setText("");
                weightEditText.setText("");
            } else {
                Utils.error(getApplicationContext(), "Invalid input");
            }
        }
    }
}