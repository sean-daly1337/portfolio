package sean.app.data.repository;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import sean.app.data.model.Admin;
import sean.app.data.model.Bookings;
import sean.app.data.model.MembershipPlan;
import sean.app.data.model.PublicUser;
import sean.app.utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class FirebaseDatabaseHelper {

    private static final String TAG = "FirebaseDatabaseHelper";

    private static FirebaseAuth firebaseAuth;
    private static DatabaseReference publicUserEndPoint;
    private static DatabaseReference adminEndPoint;
    private static DatabaseReference membershipEndPoint;
    private static DatabaseReference bookingEndPoint;

    private static ArrayList<PublicUser> publicUserArrayList;
    private static ArrayList<Admin> adminArrayList;
    private static ArrayList<MembershipPlan> membershipArrayList;
    private static ArrayList<Bookings> bookingsArrayList;

    public FirebaseDatabaseHelper() {

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        publicUserEndPoint = firebaseDatabase.getReference("public_user_table");
        adminEndPoint = firebaseDatabase.getReference("admin_table");
        membershipEndPoint = firebaseDatabase.getReference("membership_plans");
        bookingEndPoint = firebaseDatabase.getReference("bookings");

        publicUserArrayList = getAllPublicUsersFromFirebase();
        adminArrayList = getAllAdminsFromFirebase();
        membershipArrayList = getAllMembershipPlans();
    }

    private static ArrayList<PublicUser> getAllPublicUsersFromFirebase() {
        final ArrayList<PublicUser> publicUsers = new ArrayList<>();
        readData(publicUserEndPoint, dataSnapshot -> {
            for (DataSnapshot s : dataSnapshot.getChildren()) {
                publicUsers.add(s.getValue(PublicUser.class));
            }
        });
        return publicUsers;
    }

    private static ArrayList<Admin> getAllAdminsFromFirebase() {
        final ArrayList<Admin> admins = new ArrayList<>();
        readData(adminEndPoint, dataSnapshot -> {
            for (DataSnapshot s : dataSnapshot.getChildren()) {
                admins.add(s.getValue(Admin.class));
            }
        });
        return admins;
    }

    private static ArrayList<MembershipPlan> getAllMembershipPlans() {
        final ArrayList<MembershipPlan> membershipPlans = new ArrayList<>();
        readData(membershipEndPoint, dataSnapshot -> {
            for (DataSnapshot s : dataSnapshot.getChildren()) {
                membershipPlans.add(s.getValue(MembershipPlan.class));
            }
        });
        return membershipPlans;
    }

    public static ArrayList<Bookings> getAllBookings(PublicUser user) {
        final ArrayList<Bookings> bookings = new ArrayList<>();
        readData(bookingEndPoint, dataSnapshot -> {
            for (DataSnapshot s : dataSnapshot.getChildren()) {
                Bookings book = s.getValue(Bookings.class);
                if (book.getUserId().equals(user.getUserId()))
                    bookings.add(book);
            }
        });
        return bookings;
    }

    public static ArrayList<PublicUser> getAllPublicUsers() {
        return publicUserArrayList;
    }

    public static ArrayList<Admin> getAllAdmins() {
        return adminArrayList;
    }

    public static ArrayList<MembershipPlan> getMembershipArrayList() {
        return membershipArrayList;
    }

    public static ArrayList<Bookings> getBookingsArrayList() {
        return bookingsArrayList;
    }

    public static void setBookingsArrayList(ArrayList<Bookings> bookingsArrayList) {
        FirebaseDatabaseHelper.bookingsArrayList = bookingsArrayList;
    }

    /* *********************************** PUBLIC USER CRUD ********************************** */
    public static void createPublicUser(final PublicUser publicUser, Uri uri) {
        if (firebaseAuth != null) {
            firebaseAuth.createUserWithEmailAndPassword(publicUser.getEmailAddress(), publicUser.getPassword())
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Log.e(TAG, "Auth Created");
                            publicUser.setUserId(firebaseAuth.getCurrentUser().getUid());
                            publicUserEndPoint.child(publicUser.getUserId()).
                                    setValue(publicUser).addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()) {
                                    if (uri != null) {
                                        Utils.uploadImage(publicUser.getUserId(), uri);
                                        Log.e(TAG, "Database entry created");
                                        publicUserArrayList.add(publicUser);
                                    }
                                } else {
                                    Log.e(TAG, task1.getException().toString());
                                    Objects.requireNonNull(firebaseAuth.getCurrentUser()).delete();
                                }
                            });
                        } else Log.e(TAG, task.getException().toString());
                    });
        }
    }

    public static PublicUser getPublicUserByEmail(String email) {
        ArrayList<PublicUser> publicUsers = getAllPublicUsersFromFirebase();
        for (int i = 0; i < publicUsers.size(); i++) {
            if (publicUsers.get(i).getEmailAddress().equals(email))
                return publicUsers.get(i);
        }
        return null;
    }

    public static PublicUser getPublicUserByID(String id) {
        for (int i = 0; i < publicUserArrayList.size(); i++) {
            if (publicUserArrayList.get(i).getUserId().equals(id))
                return publicUserArrayList.get(i);
        }
        return null;
    }

    public static void updatePublicUser(final PublicUser publicUser) {
        publicUserEndPoint.child(publicUser.getUserId()).
                setValue(publicUser).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.e(TAG, "Database entry created");
                updateLocalUsersList(publicUser);
            } else {
                Log.e(TAG, task.getException().toString());
            }
        });
    }

    public static boolean deletePublicUser(final PublicUser publicUser) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(publicUser.getEmailAddress(),
                publicUser.getPassword()).addOnSuccessListener(authResult -> {
            auth.getCurrentUser().delete();
            publicUserEndPoint.child(publicUser.getUserId())
                    .removeValue().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.e(TAG, "Child deleted Successfully");
                    publicUserArrayList.remove(publicUser);
                } else {
                    Log.e(TAG, "Error Deleting child");
                }
            });
        });
        return true;
    }

    /* ***********************************  ADMIN CRUD ********************************* */

    public static boolean createAdmin(final Admin admin, Uri uri) {
        firebaseAuth.createUserWithEmailAndPassword(admin.getEmailAddress(), admin.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.e(TAG, "Auth Created");
                        admin.setUserId(firebaseAuth.getCurrentUser().getUid());
                        adminEndPoint.child(admin.getUserId()).
                                setValue(admin).addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                if (uri != null)
                                    Utils.uploadImage(admin.getUserId(), uri);
                                Log.e(TAG, "Database entry created");
                                adminArrayList.add(admin);
                            } else {
                                Log.e(TAG, task1.getException().toString());
                                Objects.requireNonNull(firebaseAuth.getCurrentUser()).delete();
                            }
                        });
                    } else Log.e(TAG, task.getException().toString());
                });
        return true;
    }

    public static Admin getAdmin(String email) {
        for (int i = 0; i < adminArrayList.size(); i++) {
            if (adminArrayList.get(i).getEmailAddress().equals(email))
                return adminArrayList.get(i);
        }
        return null;
    }

    public static void updateAdmin(final Admin admin) {
        adminEndPoint.child(admin.getUserId()).
                setValue(admin).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.e(TAG, "Database entry created");
                updateLocalAdminsList(admin);
            } else {
                Log.e(TAG, task.getException().toString());
            }
        });
    }

    public static boolean deleteAdmin(final Admin admin) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(admin.getEmailAddress(),
                admin.getPassword()).addOnSuccessListener(authResult -> {
            auth.getCurrentUser().delete();
            adminEndPoint.child(admin.getUserId())
                    .removeValue().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.e(TAG, "Child deleted Successfully");
                    adminArrayList.remove(admin);
                } else {
                    Log.e(TAG, "Error Deleting child");
                }
            });
        });
        return true;
    }


    ///////////////////////////////////////// MEMBERSHIP PLANS ///////////////////////////////////////////////////////

    public static void createMembership(final MembershipPlan membershipPlan) {
        membershipEndPoint.child(membershipPlan.getMembershipId()).
                setValue(membershipPlan).addOnCompleteListener(task1 -> {
            if (task1.isSuccessful()) {
                Log.i(TAG, "Database entry created");
            } else {
                Log.e(TAG, task1.getException().toString());
            }
        });
    }

    public static MembershipPlan getMembershipById(String id) {
        for (int i = 0; i < membershipArrayList.size(); i++) {
            if (membershipArrayList.get(i).getMembershipId().equals(id))
                return membershipArrayList.get(i);
        }
        return null;
    }

    ///////////////////////////////////////// BOOKING PLANS ///////////////////////////////////////////////////////

    public static void insertBooking(final Bookings bookings) {
        bookingEndPoint.child(bookings.getBookingId()).
                setValue(bookings).addOnCompleteListener(task1 -> {
            if (task1.isSuccessful()) {
                Log.e(TAG, "Database entry created");
            } else {
                Log.e(TAG, task1.getException().toString());
            }
        });
    }

    public static Bookings getBookingById(String id) {
        for (int i = 0; i < bookingsArrayList.size(); i++) {
            if (bookingsArrayList.get(i).getBookingId().equals(id))
                return bookingsArrayList.get(i);
        }
        return null;
    }

    public static boolean deleteBookings(final Bookings bookings) {
        bookingEndPoint.child(bookings.getBookingId())
                .removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.e(TAG, "Booking deleted Successfully");
                bookingsArrayList.remove(bookings);
            } else {
                Log.e(TAG, "Error Deleting booking");
            }
        });
        return true;
    }


    ///////////////////////////////////////// HELPER METHODS ///////////////////////////////////////////////////////

    private static void readData(DatabaseReference databaseReference,
                                 final OnGetDataListener listener) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private static void updateLocalUsersList(PublicUser user) {
        for (int i = 0; i < publicUserArrayList.size(); i++) {
            if (publicUserArrayList.get(i).equals(user)) {
                publicUserArrayList.get(i).setName(user.getName());
                publicUserArrayList.get(i).setPassword(user.getPassword());
                publicUserArrayList.get(i).setPhoneNumber(user.getPhoneNumber());
                publicUserArrayList.get(i).setName(user.getName());
                publicUserArrayList.get(i).setMoneySpent(user.getMoneySpent());
                publicUserArrayList.get(i).setCurrentBalance(user.getCurrentBalance());
                publicUserArrayList.get(i).setDateOfBirth(user.getDateOfBirth());
                break;
            }
        }
    }

    private static void updateLocalAdminsList(Admin admin) {
        for (int i = 0; i < adminArrayList.size(); i++) {
            if (adminArrayList.get(i).equals(admin)) {
                adminArrayList.get(i).setName(admin.getName());
                adminArrayList.get(i).setPassword(admin.getPassword());
                adminArrayList.get(i).setPhoneNumber(admin.getPhoneNumber());
                adminArrayList.get(i).setName(admin.getName());
                adminArrayList.get(i).setAdminCode(admin.getAdminCode());
            }
        }
    }

    public interface OnGetDataListener {
        //this is for callbacks
        void onSuccess(DataSnapshot dataSnapshot);
    }
}
