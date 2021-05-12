package sean.app.ui.activities.home_menu.admin;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import sean.app.R;
import sean.app.data.model.ProductModel;
import sean.app.utils.DatePickerFragment;
import sean.app.utils.DatePickerListener;
import sean.app.utils.ImageUtils;
import sean.app.utils.TimePickerFragment;
import sean.app.utils.TimePickerListener;
import sean.app.utils.TimeUtils;

import java.util.HashMap;
import java.util.Objects;

public class EditProductActivity extends AppCompatActivity implements DatePickerListener, TimePickerListener {

    private String productNodeAddress = "";

    private String selectedDate = "";
    private String selectedTime = "";
    private boolean isTimeSelected = false;
    private boolean isDateSelected = false;

    private TextView tvDate, tvTime;
    private ImageView productImage;
    private EditText productName;
    private EditText productDesc;
    private EditText sanitisedBy;
    private EditText howOftenCleaned;

    private final int permissionCode = 15;
    private final int requestImageCode = 16;
    private Uri imageUri;
    private String imgPath;
    private Bitmap selectedImage = null;

    private String prevImageName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        productNodeAddress = getIntent().getStringExtra("productNodeAddress");
        FirebaseDatabase.getInstance()
                .getReference("products")
                .child(productNodeAddress)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ProductModel model = snapshot.getValue(ProductModel.class);
                        if (model != null) {
                            setDataOnView(model);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        tvDate = findViewById(R.id.date);
        tvTime = findViewById(R.id.time);
        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.et_product_name);
        productDesc = findViewById(R.id.et_product_desc);
        sanitisedBy = findViewById(R.id.et_sanitised_by);
        howOftenCleaned = findViewById(R.id.et_how_often_it_is_cleaned);

        productImage.setOnClickListener(v -> {
            if (isAllPermissionsAllowed()) {
                startImagePickerIntent();
            } else {
                requestPermissions();
            }
        });

    }

    private void setDataOnView(ProductModel model) {
        prevImageName = model.getImageName();

        isDateSelected = true;
        selectedDate = model.getLastCleanDate();
        tvDate.setText(model.getLastCleanDate());

        isTimeSelected = true;
        selectedTime = model.getLastCleanTime();
        tvTime.setText(model.getLastCleanTime());

        productName.setText(model.getName());
        productDesc.setText(model.getDesc());
        sanitisedBy.setText(model.getSanitisedBy());
        howOftenCleaned.setText(model.getHowOftenCleaned());

        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference()
                .child("products/" + prevImageName);

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

    public void selectDateClicked(View view) {
        DialogFragment fragment = new DatePickerFragment(this);
        fragment.show(getSupportFragmentManager(), "DatePickerFragment");
    }

    public void selectTimeClicked(View view) {
        DialogFragment fragment = new TimePickerFragment(this);
        fragment.show(getSupportFragmentManager(), "TimePickerFragment");
    }

    public void onBackPress(View view) {
        finish();
    }

    public void saveBtnClicked(View view) {
        String productNameStr = productName.getText().toString().trim();
        String productDescStr = productDesc.getText().toString().trim();
        String sanitisedByStr = sanitisedBy.getText().toString().trim();
        String howOftenCleanedStr = howOftenCleaned.getText().toString().trim();

        boolean isError = false;

        if (howOftenCleanedStr.isEmpty()) {
            isError = true;
            howOftenCleaned.setError(getString(R.string.how_often_it_is_cleaned_required));
            howOftenCleaned.requestFocus();
        }

        if (sanitisedByStr.isEmpty()) {
            isError = true;
            sanitisedBy.setError(getString(R.string.sanitised_by_required));
            sanitisedBy.requestFocus();
        }

        if (productDescStr.isEmpty()) {
            isError = true;
            howOftenCleaned.setError(getString(R.string.product_desc_required));
            howOftenCleaned.requestFocus();
        }

        if (productNameStr.isEmpty()) {
            isError = true;
            productName.setError(getString(R.string.product_name_required));
            productName.requestFocus();
        }

        if (!isError) {

            if (!isDateSelected) {
                showMessageDialog(getString(R.string.last_clean_date_required));
            } else if (!isTimeSelected) {
                showMessageDialog(getString(R.string.last_clean_time_required));
            } else if (selectedImage == null) {
                addProductToDatabaseWithoutImage(productNameStr, productDescStr, sanitisedByStr, howOftenCleanedStr);
            } else {
                addProductToDatabaseWithImage(productNameStr, productDescStr, sanitisedByStr, howOftenCleanedStr);
            }

        }

    }

    private void addProductToDatabaseWithoutImage(String productNameStr, String productDescStr, String sanitisedByStr, String howOftenCleanedStr) {
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("products");
        ProductModel deviceModel = new ProductModel(
                productNodeAddress,
                productNameStr,
                productDescStr,
                sanitisedByStr,
                howOftenCleanedStr,
                selectedDate,
                selectedTime,
                prevImageName
        );
        databaseReference.child(productNodeAddress).setValue(deviceModel);
        Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void addProductToDatabaseWithImage(final String productNameStr, final String productDescStr, final String sanitisedByStr, final String howOftenCleanedStr) {
        HashMap map = loaderWithText(this, getString(R.string.adding_product, "1 %"));
        AlertDialog loadingDialog = (AlertDialog) map.get("dialog");
        TextView textView = (TextView) map.get("textView");

        FirebaseStorage.getInstance().getReference()
                .child("products/" + prevImageName).delete();

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("products");
        final String nodeAddress = productNodeAddress;
        final StorageReference firebaseStorage = FirebaseStorage.getInstance().getReference().child("products");
        final String name = nodeAddress + "_" + System.currentTimeMillis() + ImageUtils.getFileType();

        firebaseStorage.child(name).putBytes(ImageUtils.getBytes(selectedImage)).addOnSuccessListener(taskSnapshot -> firebaseStorage.child(name).getDownloadUrl().addOnSuccessListener(uri -> {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }

            if (nodeAddress != null) {
                ProductModel deviceModel = new ProductModel(
                        nodeAddress,
                        productNameStr,
                        productDescStr,
                        sanitisedByStr,
                        howOftenCleanedStr,
                        selectedDate,
                        selectedTime,
                        name
                );
                databaseReference.child(nodeAddress).setValue(deviceModel);
                Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                finish();
            }

        })).addOnProgressListener(taskSnapshot -> {
            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
            textView.setText(getString(R.string.adding_product, ((int) progress) + " %"));
        }).addOnFailureListener(e -> {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            showMessageDialog("Something went wrong.\n" + e.getMessage());
        });
    }

    @Override
    public void datePicked(int year, int month, int dayOfMonth) {
        isDateSelected = true;
        selectedDate = TimeUtils.getReadableDate(year, month, dayOfMonth);
        tvDate.setText(selectedDate);
    }

    @Override
    public void timePicked(int hourOfDay, int minute) {
        isTimeSelected = true;
        selectedTime = TimeUtils.getReadableTime(hourOfDay, minute);
        tvTime.setText(TimeUtils.getReadableTime(hourOfDay, minute));
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), (dialog, which) -> dialog.dismiss());
        Dialog alert = builder.create();
        alert.show();
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, permissionCode);
    }

    public Boolean isAllPermissionsAllowed() {
        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == permissionCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                startImagePickerIntent();
            } else {
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void startImagePickerIntent() {
        Intent intentGallery = new Intent(Intent.ACTION_PICK);
        intentGallery.setType("image/*");
        if (intentGallery.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intentGallery, requestImageCode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == requestImageCode && resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            if (data != null && data.getData() != null) {
                imageUri = data.getData();
                bitmap = ImageUtils.resizeImage(ImageUtils.getBitmapFromUri(imageUri, getApplicationContext()));
            }

            if (bitmap != null) {
                selectedImage = bitmap;
                bitmap = ImageUtils.resizeImage(bitmap);
                productImage.setImageBitmap(bitmap);
            }
        }

    }

    public static HashMap<String, Object> loaderWithText(Activity activity, String message) {
        HashMap<String, Object> map = new HashMap<>();
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        final View customView = layoutInflater.inflate(R.layout.loading_dialog_layout, null);
        AlertDialog.Builder myBox = new AlertDialog.Builder(activity);
        myBox.setView(customView);
        final TextView message_textView = customView.findViewById(R.id.message);
        message_textView.setText(message);
        final AlertDialog customProgressDialog = myBox.create();
        customProgressDialog.setCancelable(false);
        customProgressDialog.show();
        map.put("dialog", customProgressDialog);
        map.put("textView", message_textView);
        return map;
    }

}