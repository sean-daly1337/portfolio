package sean.app.ui.activities.home_menu.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import sean.app.R;

import java.util.ArrayList;

public class AdminHomeActivity extends AppCompatActivity {

    public static AdminHomeActivity adminHomeActivityObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        if (adminHomeActivityObj != null) {
            adminHomeActivityObj.finish();
        }
        adminHomeActivityObj = this;

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AdminUsersFragment());
        fragments.add(new AdminAppointmentsFragment());
        fragments.add(new AdminProductsFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragments);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setUserInputEnabled(false);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_users) {
                viewPager.setCurrentItem(0);
            } else if (item.getItemId() == R.id.navigation_appointments) {
                viewPager.setCurrentItem(1);
            } else if (item.getItemId() == R.id.navigation_products) {
                viewPager.setCurrentItem(2);
            }
            return true;
        });

    }
}