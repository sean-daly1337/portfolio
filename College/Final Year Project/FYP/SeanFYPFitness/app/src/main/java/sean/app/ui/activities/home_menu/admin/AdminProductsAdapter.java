package sean.app.ui.activities.home_menu.admin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.R;
import sean.app.data.model.ProductModel;

import java.util.ArrayList;

public class AdminProductsAdapter extends RecyclerView.Adapter<AdminProductsAdapter.ViewClass> {

    ArrayList<ProductModel> models;
    Context context;

    public AdminProductsAdapter(ArrayList<ProductModel> models) {
        this.models = models;
    }

    class ViewClass extends RecyclerView.ViewHolder {

        TextView name, desc;
        ImageView productImage;

        public ViewClass(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name = itemView.findViewById(R.id.tv_name);
            desc = itemView.findViewById(R.id.tv_desc);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }

    @NonNull
    @Override
    @SuppressLint("InflateParams")
    public ViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_product, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, final int position) {
        holder.name.setText(models.get(position).getName());
        holder.desc.setText(models.get(position).getDesc());

        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("products/" + models.get(position).getImageName());

        mStorageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Glide.with(context)
                    .load(uri.toString())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(holder.productImage);
        }).addOnFailureListener(e -> {
            holder.productImage.setImageResource(R.drawable.placeholder);
        });

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailsActivity.class);
            intent.putExtra("productNodeAddress", models.get(position).getNodeAddress());
            intent.putExtra("shouldShowEditViews", true);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
