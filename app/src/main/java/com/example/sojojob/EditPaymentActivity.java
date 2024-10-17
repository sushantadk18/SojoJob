package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityEditPaymentBinding;

public class EditPaymentActivity extends AppCompatActivity {

    private ActivityEditPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String pmethod = getIntent().getStringExtra("pmethod");
        String total = getIntent().getStringExtra("total");
        String ads = getIntent().getStringExtra("ads");

        // Set the retrieved data to corresponding EditText fields
        binding.editTextTextPersonName7.setText(pmethod);
        binding.editTextTextPersonName9.setText(ads);

        binding.button3.setOnClickListener(v -> {
            String updatedpmethod = binding.editTextTextPersonName7.getText().toString();
            String updatedads = binding.editTextTextPersonName9.getText().toString();

            if (!updatedpmethod.isEmpty() && !updatedads.isEmpty()) {
                int num1 = Integer.parseInt(binding.editTextTextPersonName4.getText().toString());
                int num2 = Integer.parseInt(binding.editTextTextPersonName.getText().toString());
                Integer updatedAds = null;

                try {
                    updatedAds = Integer.parseInt(updatedads);
                } catch (NumberFormatException e) {
                    Toast.makeText(EditPaymentActivity.this, "Please enter a valid number!", Toast.LENGTH_SHORT).show(); // Toast message to enter a valid number
                }

                if (updatedAds != null) {
                    int sum = (num1 * updatedAds) + num2;

                    // Create a new intent to pass the updated data to the Payment2Activity
                    Intent profileIntent = new Intent(EditPaymentActivity.this, Payment2Activity.class);
                    profileIntent.putExtra("pmethod", updatedpmethod);
                    profileIntent.putExtra("total", String.valueOf(sum));
                    profileIntent.putExtra("ads", String.valueOf(updatedAds));
                    startActivity(profileIntent);
                }
                Toast.makeText(EditPaymentActivity.this, "Your details updated successfully!", Toast.LENGTH_SHORT).show(); // Toast message for successful update
            } else {
                Toast.makeText(EditPaymentActivity.this, "Empty Fields Are Not Allowed!", Toast.LENGTH_SHORT).show(); // Toast message saying that empty fields are not allowed
            }
        });
    }
}
