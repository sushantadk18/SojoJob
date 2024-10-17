package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Retrieve data from intent extras
        String fullName = getIntent().getStringExtra("full_name");
        String email = getIntent().getStringExtra("e_mail");
        String address = getIntent().getStringExtra("address");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");

        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName5.setText(fullName);
        binding.editTextTextPersonName7.setText(email);
        binding.editTextTextPersonName9.setText(address);
        binding.editTextTextPersonName11.setText(age);
        binding.editTextTextPersonName10.setText(gender);

        binding.button6.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class)); // Sign out the user and navigate to the LoginActivity
            finish();
        });

        binding.button4.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
            intent.putExtra("full_name", fullName);
            intent.putExtra("e_mail", email);
            intent.putExtra("address", address);
            intent.putExtra("age", age);
            intent.putExtra("gender", gender);
            startActivity(intent); // Navigate to the EditActivity to edit user profile
        });

        binding.button5.setOnClickListener(v -> {
            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                user.delete().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Delete user's data from Firebase Realtime Database
                        FirebaseDatabase.getInstance().getReference("Users").child(user.getUid()).removeValue().addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                Toast.makeText(ProfileActivity.this, "User account deleted successfully!", Toast.LENGTH_SHORT).show(); // Toast message to display the user account deleted
                                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(ProfileActivity.this, "Failed to delete user data!", Toast.LENGTH_SHORT).show(); // Toast message to display fail to delete the user data
                            }
                        });
                    } else {
                        Toast.makeText(ProfileActivity.this, "Failed to delete user account!", Toast.LENGTH_SHORT).show(); // Toast message to display fail to delete the user account
                    }
                });
            }
        });
    }
}
