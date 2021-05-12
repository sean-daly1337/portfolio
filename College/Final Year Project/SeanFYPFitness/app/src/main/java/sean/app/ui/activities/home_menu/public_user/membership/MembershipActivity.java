package sean.app.ui.activities.home_menu.public_user.membership;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import sean.app.R;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.home_menu.public_user.profile.ProfileActivity;
import sean.app.ui.adapters.MembershipAdapter;
import sean.app.utils.Utils;

public class MembershipActivity extends BaseActivity implements MembershipAdapter.ItemClickListener {

    private ImageView userAvatar;

    private RecyclerView membershipRecyclerView;
    private MembershipAdapter membershipAdapter;

    @Override
    public int getView() {
        return R.layout.activity_membership;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_membership);

        userAvatar = findViewById(R.id.img_user);
        userAvatar.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));
        Utils.loadImage(getApplicationContext(), CurrentDatabase.getCurrentPublicUser().getUserId(), userAvatar);

        membershipRecyclerView = findViewById(R.id.rv_membership);
        membershipRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        membershipAdapter = new MembershipAdapter(getApplicationContext(), FirebaseDatabaseHelper.getMembershipArrayList());
        membershipAdapter.setClickListener(this);
        membershipRecyclerView.setAdapter(membershipAdapter);
    }

    public void openMembershipDetailActivity(View view) {
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, MembershipPlanDetailActivity.class);
        intent.putExtra("ID", FirebaseDatabaseHelper.getMembershipArrayList().get(position).getMembershipId());
        startActivity(intent);

    }
}