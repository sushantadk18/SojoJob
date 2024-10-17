package com.example.sojojob;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sojojob.databinding.ActivityPayment1Binding;

public class Payment1Activity extends AppCompatActivity {

    private ActivityPayment1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPayment1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            // Get the selected payment method from the input field
            String pmethod = binding.editTextTextPersonName7.getText().toString();

            if (!pmethod.isEmpty()) {
                // Get the numerical input values for calculations
                int num1 = Integer.parseInt(binding.editTextTextPersonName4.getText().toString());
                int num2 = Integer.parseInt(binding.editTextTextPersonName.getText().toString());
                Integer num3 = null;

                try {
                    num3 = Integer.parseInt(binding.editTextTextPersonName9.getText().toString());
                } catch (NumberFormatException e) {
                    // num3 remains null if parsing fails
                }

                if (num3 != null) {
                    int sum = (num1 * num3) + num2; // Calculation

                    // Create intent to pass the calculated data to the next activity
                    Intent profileIntent = new Intent(Payment1Activity.this, Payment2Activity.class);
                    profileIntent.putExtra("pmethod", pmethod);
                    profileIntent.putExtra("total", String.valueOf(sum));
                    profileIntent.putExtra("ads", String.valueOf(num3));
                    startActivity(profileIntent);
                } else {
                    Toast.makeText(this, "Please enter a valid number!", Toast.LENGTH_SHORT).show(); // Display a toast message if the entered number is invalid
                }
            } else {
                Toast.makeText(this, "Enter a payment method!", Toast.LENGTH_SHORT).show(); // Display a toast message if no payment method is entered
            }
        });
    }
}
