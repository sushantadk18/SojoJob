package com.example.sojojob;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPost3Binding;

public class Post3Activity extends AppCompatActivity {

    private ActivityPost3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPost3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String jobRole = getIntent().getStringExtra("jobRole");
        String salary = getIntent().getStringExtra("salary");
        String company = getIntent().getStringExtra("company");
        String address = getIntent().getStringExtra("address");
        String category = getIntent().getStringExtra("category");

        // Set the retrieved data to corresponding TextView fields
        binding.textView.setText(jobRole);
        binding.textView10.setText(salary);
        binding.textView12.setText(company);
        binding.textView13.setText(address);
        binding.textView14.setText(category);

        binding.button3.setOnClickListener(v -> {
            // Proceed to the edit activity and pass the data to it
            Intent intent = new Intent(Post3Activity.this, PostEditActivity.class);
            intent.putExtra("jobRole", jobRole);
            intent.putExtra("salary", salary);
            intent.putExtra("company", company);
            intent.putExtra("address", address);
            intent.putExtra("category", category);
            startActivity(intent);
        });

        binding.button2.setOnClickListener(v -> {
            // Delete the data
            getSharedPreferences("post_data", MODE_PRIVATE).edit()
                    .remove("job_role")
                    .remove("salary")
                    .remove("company")
                    .remove("address")
                    .remove("category")
                    .apply();

            Toast.makeText(Post3Activity.this, "Job ad deleted successfully!", Toast.LENGTH_SHORT).show(); // Display a toast message to indicate successful deletion

            // Finish the activity and go back to the previous one
            finish();
            startActivity(new Intent(Post3Activity.this, Post3Activity.class)); // Finish the activity and go back to the previous one
        });

        binding.button4.setOnClickListener(v -> {
            startActivity(new Intent(Post3Activity.this, DashboardActivity.class)); // Go back to the dashboard activity
        });
    }
}
