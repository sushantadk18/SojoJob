package com.example.sojojob;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityEditBinding;

public class EditActivity extends AppCompatActivity {

    private ActivityEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String fullName = getIntent().getStringExtra("full_name");
        String email = getIntent().getStringExtra("e_mail");
        String address = getIntent().getStringExtra("address");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");

        // Set the retrieved data to corresponding EditText and TextView fields
        binding.editTextTextPersonName5.setText(fullName);
        binding.editTextTextPersonName7.setText(email);
        binding.editTextTextPersonName9.setText(address);
        binding.editTextTextPersonName11.setText(age);
        binding.editTextTextPersonName10.setText(gender);

        binding.button4.setOnClickListener(v -> {
            String updatedFullName = binding.editTextTextPersonName5.getText().toString();
            String updatedAddress = binding.editTextTextPersonName9.getText().toString();
            String updatedAge = binding.editTextTextPersonName11.getText().toString();
            String updatedGender = binding.editTextTextPersonName10.getText().toString();

            if (!updatedFullName.isEmpty() && !updatedAddress.isEmpty() && !updatedAge.isEmpty() && !updatedGender.isEmpty()) {
                // Create a new intent to pass the updated data back to the ProfileActivity
                Intent profileIntent = new Intent(EditActivity.this, ProfileActivity.class);
                profileIntent.putExtra("full_name", updatedFullName);
                profileIntent.putExtra("e_mail", email);
                profileIntent.putExtra("address", updatedAddress);
                profileIntent.putExtra("age", updatedAge);
                profileIntent.putExtra("gender", updatedGender);
                startActivity(profileIntent); // Start ProfileActivity with the updated data

                Toast.makeText(EditActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show(); // Show a toast message indicating successful update
            }
        });
    }
}
