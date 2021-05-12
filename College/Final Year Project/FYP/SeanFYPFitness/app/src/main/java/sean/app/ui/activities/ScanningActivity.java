package sean.app.ui.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;

import org.json.JSONObject;

import sean.app.R;
import sean.app.ui.activities.home_menu.admin.ProductDetailsActivity;

public class ScanningActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    private final int permissionCode = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);

        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(result -> runOnUiThread(() -> {
            startScan();

            String text = result.getText();
            try {
                JSONObject object = new JSONObject(text.trim());
                String node = object.getString("node");
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra("productNodeAddress", node);
                startActivity(intent);
            } catch (Exception e) {
                showMessageDialog("Opps. This QR Code does not belong to " + getString(R.string.app_name));
            }

        }));

        if (!isAllPermissionsAllowed()) {
            requestPermissions();
        }

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, permissionCode);
    }

    public Boolean isAllPermissionsAllowed() {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == permissionCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startScan();
            } else {
                Toast.makeText(getApplicationContext(), "Permission denied. Can not access camera for scanning qr code", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startScan() {
        if (isAllPermissionsAllowed()) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isAllPermissionsAllowed()) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {
        if (isAllPermissionsAllowed()) {
            mCodeScanner.releaseResources();
        }
        super.onPause();
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), (dialog, which) -> {
            dialog.dismiss();
        });
        Dialog alert = builder.create();
        alert.show();
    }

}