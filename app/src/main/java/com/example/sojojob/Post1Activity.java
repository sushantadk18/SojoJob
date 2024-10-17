package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPost1Binding;

public class Post1Activity extends AppCompatActivity {

    private ActivityPost1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPost1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            // Retrieve input values from the text fields
            String jobRole = binding.editTextTextPersonName2.getText().toString();
            String salary = binding.editTextTextPersonName4.getText().toString();
            String company = binding.editTextTextPersonName.getText().toString();
            String address = binding.editTextTextPersonName3.getText().toString();
            String category = binding.editTextTextPersonName10.getText().toString();

            if (!jobRole.isEmpty() && !salary.isEmpty() && !company.isEmpty() && !address.isEmpty() && !category.isEmpty()) {
                // Proceed to the next activity if all fields are filled
                Intent intent = new Intent(Post1Activity.this, Post2Activity.class);
                intent.putExtra("jobRole", jobRole);
                intent.putExtra("salary", salary);
                intent.putExtra("company", company);
                intent.putExtra("address", address);
                intent.putExtra("category", category);
                startActivity(intent);
            } else {
                Toast.makeText(Post1Activity.this, "Empty Fields Are not Allowed!", Toast.LENGTH_SHORT).show(); // Display a toast message if any field is empty
            }
        });
    }
}
