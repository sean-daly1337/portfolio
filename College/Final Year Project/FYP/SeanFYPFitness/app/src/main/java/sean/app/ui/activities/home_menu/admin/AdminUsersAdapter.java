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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.R;
import sean.app.data.model.PublicUser;

import java.util.ArrayList;

public class AdminUsersAdapter extends RecyclerView.Adapter<AdminUsersAdapter.ViewClass> {

    ArrayList<PublicUser> models;
    Context context;

    public AdminUsersAdapter(ArrayList<PublicUser> models) {
        this.models = models;
    }

    class ViewClass extends RecyclerView.ViewHolder {

        TextView name, email, status;
        ImageView userImage;
        Button btnUnblock, btnBlock;

        public ViewClass(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            userImage = itemView.findViewById(R.id.img_user);
            btnBlock = itemView.findViewById(R.id.btnBlock);
            btnUnblock = itemView.findViewById(R.id.btnUnblock);
            status = itemView.findViewById(R.id.tv_status);

        }
    }

    @NonNull
    @Override
    @SuppressLint("InflateParams")
    public ViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_user, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewClass(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, final int position) {
        holder.name.setText(models.get(position).getName());
        holder.email.setText(models.get(position).getEmailAddress());

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

        if (models.get(position).getStatus().trim().equalsIgnoreCase("blocked")) {
            holder.btnUnblock.setVisibility(View.VISIBLE);
            holder.btnBlock.setVisibility(View.GONE);
            holder.status.setText("Account is blocked");
        } else {
            holder.btnUnblock.setVisibility(View.GONE);
            holder.btnBlock.setVisibility(View.VISIBLE);
            holder.status.setText("Account is unblocked");
        }

        holder.btnBlock.setOnClickListener(v -> {
            FirebaseDatabase.getInstance().getReference("public_user_table")
                    .child(models.get(position).getUserId())
                    .child("status").setValue("blocked");
            Toast.makeText(context, "Blocked Successfully", Toast.LENGTH_SHORT).show();
        });

        holder.btnUnblock.setOnClickListener(v -> {
            FirebaseDatabase.getInstance().getReference("public_user_table")
                    .child(models.get(position).getUserId())
                    .child("status").setValue("unblocked");
            Toast.makeText(context, "Unblocked Successfully", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
