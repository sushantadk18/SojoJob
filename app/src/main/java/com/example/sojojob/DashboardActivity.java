package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sojojob.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {
    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set click listeners for the buttons in the layout

        // Button to navigate to LoginActivity
        binding.button9.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, LoginActivity.class)));

        // Button to navigate to Post1Activity
        binding.button7.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, Post1Activity.class)));

        // Button to navigate to Payment1Activity
        binding.button8.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, Payment1Activity.class)));

        // Button to navigate to ApplyJob1Activity
        binding.button.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, ApplyJob1Activity.class)));
    }
}
