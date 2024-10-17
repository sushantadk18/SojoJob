package com.example.sojojob;


import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPayment2Binding;

public class Payment2Activity extends AppCompatActivity {

    private ActivityPayment2Binding binding;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view binding
        binding = ActivityPayment2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from the previous activity
        String pmethod = getIntent().getStringExtra("pmethod");
        String total = getIntent().getStringExtra("total");
        String ads = getIntent().getStringExtra("ads");

        // Display the retrieved data in the appropriate fields
        binding.editTextTextPersonName8.setText(pmethod);
        binding.editTextTextPersonName5.setText(total);

        binding.button4.setOnClickListener(v -> {
            // Open a file picker to select an image
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        // Clear the selected image and its corresponding text
        binding.button5.setOnClickListener(v -> {
            binding.imageView.setImageURI(null);
            binding.editTextTextPersonName4.setText("No file chosen");
            selectedImageUri = Uri.EMPTY;
        });

        // Pass the data back to the previous activity for editing
        binding.button6.setOnClickListener(v -> {
            Intent intent = new Intent(Payment2Activity.this, EditPaymentActivity.class);
            intent.putExtra("pmethod", pmethod);
            intent.putExtra("total", total);
            intent.putExtra("ads", ads);

            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Retrieve the selected image URI and display it
            selectedImageUri = data.getData();
            binding.imageView.setImageURI(selectedImageUri);
            binding.editTextTextPersonName4.setText(selectedImageUri.toString());
        } else {
            Toast.makeText(this, "Upload the payment proof!", Toast.LENGTH_SHORT).show(); // Display a toast message if no image is selected
        }

        binding.button3.setOnClickListener(v -> {
            if (!selectedImageUri.equals(Uri.EMPTY)) {
                startActivity(new Intent(Payment2Activity.this, DashboardActivity.class)); // Proceed to the dashboard if a payment proof is uploaded
                Toast.makeText(this, "Payment Successful!", Toast.LENGTH_SHORT).show(); // Display a toast message for the successful payment
            } else {
                Toast.makeText(this, "Upload the payment proof!", Toast.LENGTH_SHORT).show(); // Display a toast message if no payment proof is uploaded
            }
        });
    }
}
