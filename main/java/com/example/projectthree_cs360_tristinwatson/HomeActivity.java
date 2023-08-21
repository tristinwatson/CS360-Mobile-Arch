package com.example.projectthree_cs360_tristinwatson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.projectthree_cs360_tristinwatson.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    // variables
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // content binding
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // basic variables (should be updated to sqldatabase later)
        String[] flowerName = {"Rose", "Lotus", "Lily", "Jasmine", "Tulip",
                "Orchid", "Lavender", "Rosemary", "Sunflower", "Carnation"};
        int[] flowerImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};

        // grid item display
        GridAdapter gridAdapter = new GridAdapter(HomeActivity.this, flowerName, flowerImages);
        binding.gridView.setAdapter(gridAdapter);

        // grid item onclick listener
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this, "You Clicked on " + flowerName[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}







