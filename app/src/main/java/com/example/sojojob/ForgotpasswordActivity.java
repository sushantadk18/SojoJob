package com.example.sojojob;




import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sojojob.databinding.ActivityForgotpasswordBinding;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotpasswordActivity extends AppCompatActivity {

    private ActivityForgotpasswordBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgotpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        binding.buttonSendEmail.setOnClickListener(v -> {
            // Get the email entered by the user
            String email = binding.editTextEmail.getText().toString().trim();

            if (email.isEmpty()) {
                Toast.makeText(ForgotpasswordActivity.this, "Please enter your email!", Toast.LENGTH_SHORT).show();
            } else {
                // Send password reset email
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotpasswordActivity.this, "Reset password email sent!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ForgotpasswordActivity.this, "Error sending email: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
