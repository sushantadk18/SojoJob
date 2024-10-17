package com.example.sojojob;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPost2Binding;

public class Post2Activity extends AppCompatActivity {

    private ActivityPost2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPost2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String jobRole = getIntent().getStringExtra("jobRole");
        String salary = getIntent().getStringExtra("salary");
        String company = getIntent().getStringExtra("company");
        String address = getIntent().getStringExtra("address");
        String category = getIntent().getStringExtra("category");

        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName2.setText(jobRole);
        binding.editTextTextPersonName4.setText(salary);
        binding.editTextTextPersonName.setText(company);
        binding.editTextTextPersonName3.setText(address);
        binding.editTextTextPersonName11.setText(category);

        binding.button.setOnClickListener(v -> {
            // Proceed to the next activity and pass the data to it
            Intent intent = new Intent(Post2Activity.this, Post3Activity.class);
            intent.putExtra("jobRole", jobRole);
            intent.putExtra("salary", salary);
            intent.putExtra("company", company);
            intent.putExtra("address", address);
            intent.putExtra("category", category);
            startActivity(intent);

            Toast.makeText(Post2Activity.this, "Job ad posted successfully!", Toast.LENGTH_SHORT).show(); // Display a toast message to indicate successful job ad posting
        });
    }
}
