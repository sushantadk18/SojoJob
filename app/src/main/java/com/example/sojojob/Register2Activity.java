package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityRegister2Binding;
import com.google.firebase.auth.FirebaseAuth;

public class Register2Activity extends AppCompatActivity {

    private ActivityRegister2Binding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegister2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        binding.button3.setOnClickListener(v -> {
            // Retrieve user input from EditText fields
            String uname = binding.editTextTextPersonName2.getText().toString();
            String email = binding.editTextTextPersonName4.getText().toString();
            String pass = binding.editTextTextPersonName.getText().toString();
            String confirmPass = binding.editTextTextPersonName3.getText().toString();

            // Retrieve data passed from previous activity as intent extras
            String fullName = getIntent().getStringExtra("full_name");
            String address = getIntent().getStringExtra("address");
            String age = getIntent().getStringExtra("age");
            String gender = getIntent().getStringExtra("gender");

            if (!email.isEmpty() && !pass.isEmpty() && !confirmPass.isEmpty()) {
                if (pass.equals(confirmPass)) {
                    // Create user using Firebase Authentication
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // User creation successful, navigate to ProfileActivity and pass user data as intent extras
                            Intent profileIntent = new Intent(Register2Activity.this, ProfileActivity.class);
                            profileIntent.putExtra("full_name", fullName);
                            profileIntent.putExtra("e_mail", email);
                            profileIntent.putExtra("address", address);
                            profileIntent.putExtra("age", age);
                            profileIntent.putExtra("gender", gender);
                            startActivity(profileIntent);
                        } else {
                            Toast.makeText(Register2Activity.this, "Email already exists !", Toast.LENGTH_SHORT).show(); // User creation failed, display error message
                        }
                    });
                } else {
                    Toast.makeText(Register2Activity.this, "Password is not matching !", Toast.LENGTH_SHORT).show(); // Display error message if password and confirm password do not match
                }
            } else {
                Toast.makeText(Register2Activity.this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show(); // Display error message if any of the fields are empty
            }
        });
    }
}
