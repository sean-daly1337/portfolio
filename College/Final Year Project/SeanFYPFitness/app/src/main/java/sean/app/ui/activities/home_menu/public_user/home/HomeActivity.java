package sean.app.ui.activities.home_menu.public_user.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import sean.app.R;
import sean.app.data.model.GymFactory;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.ScanningActivity;
import sean.app.ui.activities.home_menu.public_user.bookings.BookingsActivity;
import sean.app.ui.activities.home_menu.public_user.profile.ProfileActivity;
import sean.app.ui.adapters.GymFactoryAdapter;
import sean.app.utils.Utils;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements GymFactoryAdapter.ItemClickListener {

    private ImageView userAvatar;

    ArrayList<GymFactory> gymFactoryList = new ArrayList<>();
    GymFactoryAdapter gymFactoryAdapter;
    RecyclerView gymFactoryRecyclerView;

    @Override
    public int getView() {
        return R.layout.activity_home;

    }

    @Override
    public void setActivityData() {

        setBottomNavigation(R.id.navigation_home);

        userAvatar = findViewById(R.id.img_user);
        userAvatar.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Utils.loadImage(getApplicationContext(), FirebaseAuth.getInstance().getCurrentUser().getUid(), userAvatar);
        }

        gymFactoryRecyclerView = findViewById(R.id.rv_gym_factory);

        gymFactoryList.add(new GymFactory("Beginner Level", "Shoulder Workout",
                "Full Equipment\nStrength\nTotal Time: 60 minutes", getResources().getDrawable(R.drawable.bg_exercises)));
        gymFactoryList.add(new GymFactory("Expert Level", "Back Workout",
                "Full Equipment\nStrength\nTotal Time: 40 minutes", getResources().getDrawable(R.drawable.bg_exercises)));
        gymFactoryAdapter = new GymFactoryAdapter(this, gymFactoryList);
        gymFactoryAdapter.setClickListener(this);

        gymFactoryRecyclerView.setAdapter(gymFactoryAdapter);

    }

    public void openBarCodeActivity(View view) {
        startActivity(new Intent(getApplicationContext(), ScanningActivity.class));
    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(getApplicationContext(), BookingsActivity.class));
    }
}