package sean.app.ui.activities.home_menu.admin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.R;
import sean.app.data.model.ProductModel;

import net.glxn.qrgen.android.QRCode;

public class ProductDetailsActivity extends AppCompatActivity {

    private String productNodeAddress = "";

    ImageView productImage, codeImage;
    TextView tv_product_name;
    TextView tv_product_desc;
    TextView tv_sanitised_by;
    TextView tv_how_often_it_is_cleaned;
    TextView date;
    TextView time;

    String imageName = "";

    private boolean productCheckEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productNodeAddress = getIntent().getStringExtra("productNodeAddress");

        codeImage = findViewById(R.id.codeImage);
        productImage = findViewById(R.id.productImage);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_desc = findViewById(R.id.tv_product_desc);
        tv_sanitised_by = findViewById(R.id.tv_sanitised_by);
        tv_how_often_it_is_cleaned = findViewById(R.id.tv_how_often_it_is_cleaned);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        FirebaseDatabase.getInstance()
                .getReference("products")
                .child(productNodeAddress)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(productCheckEnabled) {
                            ProductModel model = snapshot.getValue(ProductModel.class);
                            if (model != null) {
                                setDataOnView(model);
                            } else {
                                showMessageDialog("We could not find any product with id + " + productNodeAddress + "\nIt is possible that product is deleted or removed or unavailable.");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        if (getIntent().getBooleanExtra("shouldShowEditViews", false)) {
            findViewById(R.id.editView).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.editView).setVisibility(View.GONE);
        }

        String textToWrite = "{ node:" + productNodeAddress + "}";
        Bitmap bitmap = QRCode.from(textToWrite).withSize(800, 800).bitmap();
        codeImage.setImageBitmap(bitmap);

        findViewById(R.id.btnEdit).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), EditProductActivity.class);
            intent.putExtra("productNodeAddress", productNodeAddress);
            startActivity(intent);
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            productCheckEnabled = false;
            final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                    .child("products/" + imageName);
            mStorageRef.delete();
            FirebaseDatabase.getInstance()
                    .getReference("products")
                    .child(productNodeAddress)
                    .removeValue();
            Toast.makeText(getApplicationContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private void setDataOnView(ProductModel model) {
        tv_product_name.setText(model.getName());
        tv_product_desc.setText(model.getDesc());
        tv_sanitised_by.setText(model.getSanitisedBy());
        tv_how_often_it_is_cleaned.setText(model.getHowOftenCleaned());
        date.setText(model.getLastCleanDate());
        time.setText(model.getLastCleanTime());

        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("products/" + model.getImageName());

        imageName = model.getImageName();

        mStorageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Glide.with(getApplicationContext())
                    .load(uri.toString())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(productImage);
        }).addOnFailureListener(e -> {
            productImage.setImageResource(R.drawable.placeholder);
        });

    }

    public void onBackPress(View view) {
        finish();
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), (dialog, which) -> {
            dialog.dismiss();
            finish();
        });
        Dialog alert = builder.create();
        alert.show();
    }

}