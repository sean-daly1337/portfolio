package sean.app.ui.activities.home_menu.public_user.bookings;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import sean.app.R;
import sean.app.data.model.Bookings;
import sean.app.data.model.DeliverySlotModel;
import sean.app.data.repository.CurrentDatabase;
import sean.app.data.repository.FirebaseDatabaseHelper;
import sean.app.ui.activities.BaseActivity;
import sean.app.ui.activities.home_menu.public_user.profile.ProfileActivity;
import sean.app.ui.adapters.BookingsAdapter;
import sean.app.ui.adapters.DeliverySlotAdapter;
import sean.app.ui.interfaces.OnItemClickListener;
import sean.app.utils.Utils;

public class BookingsActivity extends BaseActivity implements View.OnClickListener, OnItemClickListener,
        BookingsAdapter.ItemClickListener, CalendarView.OnDateChangeListener {

    private ImageView userAvatar;

    private Button bookAppointment;

    boolean isFromMyBooking = false;
    RadioGroup radioGroup;
    RadioButton bookingNowRadioButton, myBookingRadioButton;
    private ProgressBar progressBar2;

    private ArrayList<DeliverySlotModel> deliverySlotModels;
    private DeliverySlotAdapter deliverySlotAdapter;

    private RecyclerView upcomingBookingsRecyclerView;

    private CalendarView calendarView;
    private Bookings bookings;

    private BookingsAdapter bookingsAdapter;

    private ArrayList<Bookings> bookingsArrayList = new ArrayList<>();

    @Override
    public int getView() {
        if (getIntent() != null && getIntent().getBooleanExtra("isFromMyBooking", false)) {
            isFromMyBooking = true;
            return R.layout.activity_booking_mine;
        }

        return R.layout.activity_booking;
    }

    @Override
    public void setActivityData() {
        setBottomNavigation(R.id.navigation_booking);
        radioGroup = findViewById(R.id.rg_booking);
        bookingNowRadioButton = findViewById(R.id.rb_booking_now);
        myBookingRadioButton = findViewById(R.id.rb_mybooking);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.INVISIBLE);

        bookingsAdapter = new BookingsAdapter(getApplicationContext(), bookingsArrayList);

        if (isFromMyBooking) {

            upcomingBookingsRecyclerView = findViewById(R.id.rv_upcoming_booking);
            upcomingBookingsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            bookingsAdapter.setClickListener(this);
            upcomingBookingsRecyclerView.setAdapter(bookingsAdapter);

        }

        if (!isFromMyBooking) {
            bookAppointment = findViewById(R.id.btn_book_appointment);
            bookAppointment.setOnClickListener(this);

            calendarView = findViewById(R.id.calendar_view);
            calendarView.setOnDateChangeListener(this);
            bookings = new Bookings();
            bookings.setBookingId(Utils.generateUUID());

            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                bookings.setUserId(FirebaseAuth.getInstance().getCurrentUser().getUid());
            }

            bookings.setBookingDate(Utils.timeStampToClock(calendarView.getDate()));
            bookings.setBookingTime("10:00 am");
        }

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("bookings");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookingsArrayList.clear();
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    for (DataSnapshot s : dataSnapshot.getChildren()) {
                        Bookings book = s.getValue(Bookings.class);
                        if (book.getUserId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                            bookingsArrayList.add(book);
                        }
                    }
                }
                bookingsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        userAvatar = findViewById(R.id.img_user);
        userAvatar.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));
        Utils.loadImage(getApplicationContext(), CurrentDatabase.getCurrentPublicUser().getUserId(), userAvatar);

        if (isFromMyBooking) {
            myBookingRadioButton.setChecked(true);
        } else {
            showDeliveryTime();
        }
        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            isFromMyBooking = radioGroup.getCheckedRadioButtonId() != bookingNowRadioButton.getId();
            Intent intent = new Intent(BookingsActivity.this, BookingsActivity.class);
            intent.putExtra("isFromMyBooking", isFromMyBooking);

            startActivity(intent);
            overridePendingTransition(0, 0);
            finishAffinity();
        });
    }

    public void openBarCodeActivity(View view) {
        startActivity(new Intent(getApplicationContext(), UserBarCodeView.class));
    }


    public void showDeliveryTime() {
        RecyclerView deliveryTimeRecyclerView = findViewById(R.id.rv_delivery_time);

        deliverySlotModels = new ArrayList<>();
        deliverySlotModels.add(new DeliverySlotModel(Utils.generateUUID(), "10:00 am", true, false));
        deliverySlotModels.add(new DeliverySlotModel(Utils.generateUUID(), "11:00 am", false, false));
        deliverySlotModels.add(new DeliverySlotModel(Utils.generateUUID(), "02:00 pm", false, false));
        deliverySlotModels.add(new DeliverySlotModel(Utils.generateUUID(), "03:00 pm", false, false));

        deliverySlotAdapter = new DeliverySlotAdapter(this, deliverySlotModels, this);
        deliveryTimeRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        deliveryTimeRecyclerView.setAdapter(deliverySlotAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == bookAppointment) {
            progressBar2.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                progressBar2.setVisibility(View.INVISIBLE);
                Utils.success(getApplicationContext(), "Appointment booked");
            }, 2000);
            if (bookings == null) {
                bookings.setBookingDate(Utils.timeStampToClock(calendarView.getDate()));
            }
            FirebaseDatabaseHelper.insertBooking(bookings);
            FirebaseDatabaseHelper.setBookingsArrayList(FirebaseDatabaseHelper.getAllBookings(CurrentDatabase.getCurrentPublicUser()));
        }

    }

    @Override
    public void onItemClick(int position) {
        bookings.setBookingTime(deliverySlotModels.get(position).getRange());
    }

    @Override
    public void onItemClick(View view, int position) {
        Utils.success(getApplicationContext(), "Booking cancelled");
        FirebaseDatabaseHelper.deleteBookings(bookingsArrayList.get(position));
       // bookingsArrayList.remove(bookingsArrayList.get(position));
        //bookingsAdapter.setAdapterData(bookingsArrayList);

    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month,
                                    int dayOfMonth) {
        bookings.setBookingDate(dayOfMonth + "/" + month);
    }
}