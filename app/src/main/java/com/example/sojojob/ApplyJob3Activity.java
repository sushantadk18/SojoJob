package com.example.sojojob;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityApplyJob3Binding;

public class ApplyJob3Activity extends AppCompatActivity {
    private ActivityApplyJob3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityApplyJob3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Retrieve data from intent extras
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String contact = getIntent().getStringExtra("contact");
        String cv = getIntent().getStringExtra("cv");
        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName16.setText(name);
        binding.editTextTextPersonName17.setText(email);
        binding.editTextTextPersonName18.setText(contact);
        binding.editTextTextPersonName15.setText(cv);

        // Set click listener for button15
        binding.button15.setOnClickListener(v -> {
            Intent intent = new Intent(ApplyJob3Activity.this, ApplyJobEditActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("contact", contact);
            intent.putExtra("cv", cv);
            startActivity(intent); // Start ApplyJobEditActivity with the provided data
        });
        // Set click listener for button14
        binding.button14.setOnClickListener(v -> {
            Toast.makeText(ApplyJob3Activity.this, "You applied for the job successfully!", Toast.LENGTH_SHORT).show(); // Show a toast message indicating successful job application
            startActivity(new Intent(ApplyJob3Activity.this, DashboardActivity.class)); // Start DashboardActivity
        });
    }
}
