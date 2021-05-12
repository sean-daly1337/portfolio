package sean.app.ui.activities.home_menu.admin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.R;
import sean.app.data.model.Bookings;
import sean.app.data.model.PublicUser;

import java.util.ArrayList;

public class AdminAppointmentsAdapter extends RecyclerView.Adapter<AdminAppointmentsAdapter.ViewClass> {

    ArrayList<Bookings> models;
    Context context;

    public AdminAppointmentsAdapter(ArrayList<Bookings> models) {
        this.models = models;
    }

    class ViewClass extends RecyclerView.ViewHolder {

        TextView name, email, date, time;
        ImageView userImage;
        Button btnCancel;

        public ViewClass(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            userImage = itemView.findViewById(R.id.img_user);
            btnCancel = itemView.findViewById(R.id.btnCancel);
            date = itemView.findViewById(R.id.tv_date_text);
            time = itemView.findViewById(R.id.tv_time_text);

        }
    }

    @NonNull
    @Override
    @SuppressLint("InflateParams")
    public ViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_booking, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, final int position) {

        FirebaseDatabase.getInstance()
                .getReference("public_user_table")
                .child(models.get(position).getUserId())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        PublicUser user = snapshot.getValue(PublicUser.class);
                        if (user != null) {
                            holder.name.setText(user.getName());
                            holder.email.setText(user.getEmailAddress());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        holder.date.setText(models.get(position).getBookingDate());
        holder.time.setText(models.get(position).getBookingTime());

        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("user_profile_pictures/" + models.get(position).getUserId() + ".png");

        mStorageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Glide.with(context)
                    .load(uri.toString())
                    .placeholder(R.drawable.ic_avatar)
                    .error(R.drawable.ic_avatar)
                    .into(holder.userImage);
        }).addOnFailureListener(e -> {
            holder.userImage.setImageResource(R.drawable.ic_avatar);
        });

        holder.btnCancel.setOnClickListener(v -> {
            FirebaseDatabase.getInstance().getReference("bookings")
                    .child(models.get(position).getBookingId()).removeValue();
            Toast.makeText(context, "Cancelled Successfully", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
