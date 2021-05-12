package sean.app.ui.activities.find_studio;

import android.content.Intent;
import android.view.View;

import com.gd70.android.validator.ValidatorEditText;
import sean.app.R;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.gym_factory.GymFactoryActivity;
import sean.app.utils.Constants;
import sean.app.utils.Utils;

public class FindStudioActivity extends BaseActivity {

    private ValidatorEditText nameEditText;

    @Override
    public int getView() {
        return R.layout.activity_find_studio;
    }

    @Override
    public void setActivityData() {
        nameEditText = findViewById(R.id.edt_find_studio);

    }


    public void onProceedClicked(View view) {
        String studioName = nameEditText.getText().toString().trim();
        if (studioName.isEmpty())
            Utils.warning(getApplicationContext(), "Please enter a valid name");
        else {
            Utils.setGymSelected();
            Utils.saveDataInSharedPrefs(Constants.GYM_NAME, studioName);
            startActivity(new Intent(getApplicationContext(), GymFactoryActivity.class));
            finish();
        }
    }
}