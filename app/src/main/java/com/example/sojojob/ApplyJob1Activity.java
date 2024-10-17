package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sojojob.databinding.ActivityApplyJob1Binding;

public class ApplyJob1Activity extends AppCompatActivity {
    private ActivityApplyJob1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using ViewBinding
        binding = ActivityApplyJob1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set click listener for button4
        binding.button4.setOnClickListener(v -> {
            startActivity(new Intent(ApplyJob1Activity.this, ApplyJob2Activity.class)); // Start ApplyJob2Activity when button4 is clicked
        });

        // Set click listener for button5
        binding.button5.setOnClickListener(v -> {
            startActivity(new Intent(ApplyJob1Activity.this, ApplyJob2Activity.class)); // Start ApplyJob2Activity when button5 is clicked
        });
    }
}
