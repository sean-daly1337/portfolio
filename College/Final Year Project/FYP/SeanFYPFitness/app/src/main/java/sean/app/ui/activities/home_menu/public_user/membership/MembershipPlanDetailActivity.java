package sean.app.ui.activities.home_menu.public_user.membership;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import sean.app.R;
import sean.app.data.model.MembershipPlan;
import sean.app.data.model.PublicUser;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.home_menu.public_user.profile.ProfileActivity;
import sean.app.utils.Utils;

public class MembershipPlanDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView userAvatar;
    private Button buyMembershipButton;

    private TextView membershipNameTextView;
    private TextView membershipDescriptionTextView;
    private TextView membershipFeesTextView;
    private TextView membershipDurationTextView;

    private MembershipPlan membershipPlan;

    @Override
    public int getView() {
        return R.layout.activity_membership_plan_detail;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_membership);

        String id = getIntent().getStringExtra("ID");
        membershipPlan = FirebaseDatabaseHelper.getMembershipById(id);

        membershipNameTextView = findViewById(R.id.tv_membership_name);
        membershipDescriptionTextView = findViewById(R.id.tv_membershipt_details);
        membershipFeesTextView = findViewById(R.id.tv_membership_fees);
        membershipDurationTextView = findViewById(R.id.tv_duration);

        if (membershipPlan != null) {
            membershipNameTextView.setText(membershipPlan.getName());
            membershipDescriptionTextView.setText(membershipPlan.getDesc());
            membershipFeesTextView.setText(membershipPlan.getPrice() + " USD");
            membershipDurationTextView.setText(membershipPlan.getDuration());
        } else {
            Utils.warning(getApplicationContext(), "Error occurred while fetching data, please try again");
            finish();
        }

        userAvatar = findViewById(R.id.img_user);
        userAvatar.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));
        Utils.loadImage(getApplicationContext(), CurrentDatabase.getCurrentPublicUser().getUserId(), userAvatar);

        buyMembershipButton = findViewById(R.id.btn_buy_membership);
        buyMembershipButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buyMembershipButton) {
            if (CurrentDatabase.getCurrentPublicUser().getCurrentBalance() < membershipPlan.getPrice())
                Utils.warning(getApplicationContext(), "You don't have sufficient balance, Please recharge by contacting admin");
            else {
                PublicUser publicUser = CurrentDatabase.getCurrentPublicUser();
                publicUser.setCurrentBalance((CurrentDatabase.getCurrentPublicUser().getCurrentBalance() - membershipPlan.getPrice()));
                CurrentDatabase.setCurrentPublicUser(publicUser);
                Utils.success(getApplicationContext(), "Membership purchased successfully");
            }
        }
    }
}