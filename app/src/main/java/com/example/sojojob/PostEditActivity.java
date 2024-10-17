package com.example.sojojob;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPostEditBinding;

public class PostEditActivity extends AppCompatActivity {

    private ActivityPostEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPostEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent extras
        String jobRole = getIntent().getStringExtra("jobRole");
        String salary = getIntent().getStringExtra("salary");
        String company = getIntent().getStringExtra("company");
        String address = getIntent().getStringExtra("address");
        String category = getIntent().getStringExtra("category");

        // Set the retrieved data to corresponding EditText fields
        binding.editTextTextPersonName2.setText(jobRole);
        binding.editTextTextPersonName4.setText(salary);
        binding.editTextTextPersonName.setText(company);
        binding.editTextTextPersonName3.setText(address);
        binding.editTextTextPersonName10.setText(category);

        binding.button3.setOnClickListener(v -> {
            // Retrieve the updated values from the EditText fields
            String updatedJobRole = binding.editTextTextPersonName2.getText().toString();
            String updatedSalary = binding.editTextTextPersonName4.getText().toString();
            String updatedCompany = binding.editTextTextPersonName.getText().toString();
            String updatedAddress = binding.editTextTextPersonName3.getText().toString();
            String updatedCategory = binding.editTextTextPersonName10.getText().toString();

            if (!updatedJobRole.isEmpty() && !updatedSalary.isEmpty() && !updatedCompany.isEmpty() && !updatedAddress.isEmpty() && !updatedCategory.isEmpty()) {
                // Create a new intent to pass the updated data back to the Post3Activity
                Intent profileIntent = new Intent(PostEditActivity.this, Post3Activity.class);
                profileIntent.putExtra("jobRole", updatedJobRole);
                profileIntent.putExtra("salary", updatedSalary);
                profileIntent.putExtra("company", updatedCompany);
                profileIntent.putExtra("address", updatedAddress);
                profileIntent.putExtra("category", updatedCategory);
                startActivity(profileIntent);

                Toast.makeText(PostEditActivity.this, "Job ad updated successfully!", Toast.LENGTH_SHORT).show(); // Display a toast message to indicate successful update
            }
        });
    }
}
