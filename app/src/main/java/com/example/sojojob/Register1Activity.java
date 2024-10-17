package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityRegister1Binding;

public class Register1Activity extends AppCompatActivity {

    private ActivityRegister1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegister1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            // Retrieve user input from EditText fields
            String fname = binding.editTextTextPersonName2.getText().toString();
            String addr = binding.editTextTextPersonName4.getText().toString();
            String age = binding.editTextTextPersonName.getText().toString();
            String gender = binding.editTextTextPersonName3.getText().toString();

            if (!fname.isEmpty() && !addr.isEmpty() && !age.isEmpty() && !gender.isEmpty()) {
                // Create an intent to navigate to Register2Activity and pass the user input as intent extras
                Intent intent = new Intent(Register1Activity.this, Register2Activity.class);
                intent.putExtra("full_name", fname);
                intent.putExtra("address", addr);
                intent.putExtra("age", age);
                intent.putExtra("gender", gender);
                startActivity(intent);
            } else {
                Toast.makeText(Register1Activity.this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show(); // Display a toast message if any of the fields are empty
            }
        });
    }
}
