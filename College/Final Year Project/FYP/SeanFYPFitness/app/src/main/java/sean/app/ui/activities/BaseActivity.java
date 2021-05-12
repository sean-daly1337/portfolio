package sean.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;
import sean.app.R;
import sean.app.data.model.PublicUser;
import sean.app.data.repository.CurrentDatabase;
import sean.app.ui.activities.home_menu.public_user.bookings.BookingsActivity;
import sean.app.ui.activities.home_menu.public_user.home.HomeActivity;
import sean.app.ui.activities.home_menu.public_user.membership.MembershipActivity;
import sean.app.ui.activities.home_menu.public_user.profile.ProfileActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getView();

    public abstract void setActivityData();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getView() != 0) {
            setContentView(getView());
        }

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("public_user_table");
            databaseReference.child(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    PublicUser user = dataSnapshot.getValue(PublicUser.class);
                    if (user != null) {
                        CurrentDatabase.setCurrentPublicUser(user);
                    }
                    setActivityData();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        } else {
            setActivityData();
        }

    }

    public void openHomeMenuActivity(View view) {
        startActivity(new Intent(this, HomeActivity.class));
        finishAffinity();
    }

    public void openBookingMenuActivity(View view) {
        startActivity(new Intent(this, BookingsActivity.class));
        finishAffinity();
    }

    public void openProfileMenuActivity(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
        finishAffinity();
    }

    public void openMembershipMenuActivity(View view) {
        startActivity(new Intent(this, MembershipActivity.class));
        finishAffinity();
    }

    public void onBackPress(View view) {
        finish();
    }

    public void setBottomNavigation(int id) {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bm_footer);
        bottomNavigationView.setSelectedItemId(id);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (id == item.getItemId()) {
                return false;
            }
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openHomeMenuActivity(null);
                    break;
                case R.id.navigation_booking:
                    openBookingMenuActivity(null);
                    break;
                case R.id.navigation_membership:
                    openMembershipMenuActivity(null);
                    break;
                case R.id.navigation_profile:
                    openProfileMenuActivity(null);
                    break;
            }
            overridePendingTransition(0, 0);
            return true;
        });
    }

    protected void success(String message) {
        Toasty.success(getApplicationContext(), message, Toasty.LENGTH_SHORT, true).show();
    }

    protected void error(String message) {
        Toasty.error(getApplicationContext(), message, Toasty.LENGTH_SHORT, true).show();
    }

    protected void info(String message) {
        Toasty.info(getApplicationContext(), message, Toasty.LENGTH_SHORT, true).show();
    }

    protected void warning(String message) {
        Toasty.warning(getApplicationContext(), message, Toasty.LENGTH_SHORT, true).show();
    }

}