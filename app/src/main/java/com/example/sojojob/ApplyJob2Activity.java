package com.example.sojojob;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sojojob.databinding.ActivityApplyJob2Binding;

public class ApplyJob2Activity extends AppCompatActivity {

    private ActivityApplyJob2Binding binding;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityApplyJob2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set click listener for button16
        binding.button16.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST); // Start activity to pick an image
        });

        // Set click listener for button12
        binding.button12.setOnClickListener(v -> {
            binding.imageView.setImageURI(null); // Clear the image view
            binding.editTextTextPersonName15.setText("No file chosen"); // Set the text to indicate no file is chosen
            selectedImageUri = Uri.EMPTY; // Set the selected image URI to empty
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            binding.imageView.setImageURI(selectedImageUri); // Set the selected image to the image view
            binding.editTextTextPersonName15.setText(selectedImageUri.toString()); // Set the text to display the selected image URI
        }

        // Set click listener for button14
        binding.button14.setOnClickListener(v -> {
            String name = binding.editTextTextPersonName16.getText().toString();
            String email = binding.editTextTextPersonName17.getText().toString();
            String contact = binding.editTextTextPersonName18.getText().toString();
            String cv = binding.editTextTextPersonName15.getText().toString();

            if (!name.isEmpty() && !email.isEmpty() && !contact.isEmpty() && !cv.isEmpty()) {
                Intent intent = new Intent(ApplyJob2Activity.this, ApplyJob3Activity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("contact", contact);
                intent.putExtra("cv", cv);

                if (!selectedImageUri.equals(Uri.EMPTY)) {
                    startActivity(intent); // Start ApplyJob3Activity with the provided data
                } else {
                    Toast.makeText(ApplyJob2Activity.this, "Upload the CV!", Toast.LENGTH_SHORT).show(); // Show a toast message if no CV is uploaded
                }
            }
        });
    }
}
