package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view binding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize FirebaseAuth instance
        firebaseAuth = FirebaseAuth.getInstance();

        // Login button click
        binding.button3.setOnClickListener(v -> {
            String email = binding.editTextTextPersonName2.getText().toString();
            String pass = binding.editTextTextPersonName.getText().toString();

            if (!email.isEmpty() && !pass.isEmpty()) {
                // Sign in with email and password using FirebaseAuth
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        Toast.makeText(LoginActivity.this, "Login Sucessfull" , Toast.LENGTH_SHORT).show();// If login is successful, start DashboardActivity
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect email or password!", Toast.LENGTH_SHORT).show(); // If login fails, show error message with a toast
                    }
                });
            } else {
                Toast.makeText(LoginActivity.this, "Empty Fields Are Not Allowed!", Toast.LENGTH_SHORT).show(); // Show error message when email or password fields are empty
            }
        });

        binding.textView2.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgotpasswordActivity.class)); // Start Register1Activity for user registration
        });

    }
}
