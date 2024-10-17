package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sojojob.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button7.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class)); // Start LoginActivity when the button is clicked
        });

        binding.button2.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Register1Activity.class)); // Start Register1Activity when the button is clicked
        });
    }
}
