package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityApplyJobEditBinding;

public class ApplyJobEditActivity extends AppCompatActivity {

    private ActivityApplyJobEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityApplyJobEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String contact = getIntent().getStringExtra("contact");
        String cv = getIntent().getStringExtra("cv");

        // Set the retrieved data to corresponding EditText fields
        binding.editTextTextPersonName16.setText(name);
        binding.editTextTextPersonName17.setText(email);
        binding.editTextTextPersonName18.setText(contact);

        // Set click listener for button14
        binding.button14.setOnClickListener(v -> {
            String updatedName = binding.editTextTextPersonName16.getText().toString();
            String updatedEmail = binding.editTextTextPersonName17.getText().toString();
            String updatedContact = binding.editTextTextPersonName18.getText().toString();

            if (!updatedName.isEmpty() && !updatedEmail.isEmpty() && !updatedContact.isEmpty()) {
                // Create a new intent to pass the updated data back to the ApplyJob3Activity
                Intent profileIntent = new Intent(ApplyJobEditActivity.this, ApplyJob3Activity.class);
                profileIntent.putExtra("name", updatedName);
                profileIntent.putExtra("email", updatedEmail);
                profileIntent.putExtra("contact", updatedContact);
                profileIntent.putExtra("cv", cv);
                startActivity(profileIntent); // Start ApplyJob3Activity with the updated data

                Toast.makeText(ApplyJobEditActivity.this, "Your details updated successfully!", Toast.LENGTH_SHORT).show(); // Show a toast message indicating successful update
            } else {
                Toast.makeText(ApplyJobEditActivity.this, "Empty Fields Are Not Allowed!", Toast.LENGTH_SHORT).show(); // Show a toast message indicating that empty fields are not allowed
            }
        });
    }
}
