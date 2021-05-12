package sean.app;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

import sean.app.data.model.MembershipPlan;
import sean.app.data.repository.FirebaseDatabaseHelper;


/**
 * The type Application context.
 */
public class ApplicationContext extends Application {

    private static final String TAG = "ApplicationContext";

    private static Context singleton;

    /**
     * Gets context.
     *
     * @return the context
     */
    public static Context getContext() {
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabaseHelper databaseHelper = new FirebaseDatabaseHelper();
        singleton = getApplicationContext();
        addData();
    }

    public void addData() {
        ArrayList<MembershipPlan> membershipPlans = new ArrayList<>();

        membershipPlans.add(new MembershipPlan(
                "1",
                "SeanFYPFitness  - Unlimited",
                "Unlimited package with all the necessary things you'll need.",
                "4 Weeks",
                50.0));

        membershipPlans.add(new MembershipPlan(
                "2",
                "SeanFYPFitness  - Newbie Offer",
                "Please note that offer is valid for first timers only",
                "4 Weeks",
                100.0));

        FirebaseDatabaseHelper.createMembership(membershipPlans.get(0));
        FirebaseDatabaseHelper.createMembership(membershipPlans.get(1));

    }
}
