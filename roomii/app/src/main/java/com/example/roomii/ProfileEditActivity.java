package com.example.roomii;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.os.Handler;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ProfileEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        Spinner politicalSpinner = (Spinner) findViewById(R.id.political_spinner);
        ArrayAdapter<CharSequence> politicalAdapter = ArrayAdapter.createFromResource(this,
                R.array.political_array, android.R.layout.simple_spinner_item);
        politicalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        politicalSpinner.setAdapter(politicalAdapter);

        Spinner sleepSpinner = (Spinner) findViewById(R.id.sleep_time_spinner);
        ArrayAdapter<CharSequence> sleepAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        sleepAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sleepSpinner.setAdapter(sleepAdapter);

        Spinner relationshipSpinner = (Spinner) findViewById(R.id.relationship_spinner);
        ArrayAdapter<CharSequence> relationshipAdapter = ArrayAdapter.createFromResource(this,
                R.array.relationship_array, android.R.layout.simple_spinner_item);
        relationshipAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relationshipSpinner.setAdapter(relationshipAdapter);

        Spinner extroversionSpinner = (Spinner) findViewById(R.id.extroversion_spinner);
        ArrayAdapter<CharSequence> extroversionAdapter = ArrayAdapter.createFromResource(this,
                R.array.extrovert_array, android.R.layout.simple_spinner_item);
        extroversionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        extroversionSpinner.setAdapter(extroversionAdapter);

        Spinner housingSpinner = (Spinner) findViewById(R.id.housing_spinner);
        ArrayAdapter<CharSequence> housingAdapter = ArrayAdapter.createFromResource(this,
                R.array.housing_array, android.R.layout.simple_spinner_item);
        housingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        housingSpinner.setAdapter(housingAdapter);

        Spinner religionSpinner = (Spinner) findViewById(R.id.religion_spinner);
        ArrayAdapter<CharSequence> religionAdapter = ArrayAdapter.createFromResource(this,
                R.array.religion_array, android.R.layout.simple_spinner_item);
        religionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religionSpinner.setAdapter(religionAdapter);

        Spinner foodSpinner = (Spinner) findViewById(R.id.food_spinner);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(this,
                R.array.food_habits_array, android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(foodAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Profile Changes Saved!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
