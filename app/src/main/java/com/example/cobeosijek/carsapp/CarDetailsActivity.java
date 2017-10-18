package com.example.cobeosijek.carsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.adapters.ImageAdapter;

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_CAR_SENT = "car_sent";

    public static Intent getLaunchIntent(Context context, Car car) {
        return new Intent(context, CarDetailsActivity.class).putExtra(KEY_CAR_SENT, car);
    }

    ImageView backV;
    ViewPager carImageVP;
    TextView carNameV;
    TextView carAgeV;
    TextView carTopSpeedV;
    TextView carRegistrationV;

    Car carToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        carToShow = (Car) getIntent().getSerializableExtra(KEY_CAR_SENT);
        setUI();

    }

    private void setUI() {
        backV = findViewById(R.id.backImage);
        carImageVP = findViewById(R.id.imagePager);
        carNameV = findViewById(R.id.carDetailsName);
        carAgeV = findViewById(R.id.carDetailsAge);
        carTopSpeedV = findViewById(R.id.carDetailsTopSpeed);
        carRegistrationV = findViewById(R.id.carDetailsRegistration);

        ImageAdapter imageAdapter = new ImageAdapter(this, carToShow.getCarImages());
        carImageVP.setAdapter(imageAdapter);

        backV.setOnClickListener(this);

        carNameV.setText(carToShow.getCarModel());
        carAgeV.setText(String.format("Age: %d", carToShow.getCarAge()));
        carTopSpeedV.setText(String.format("Top speed: %d", carToShow.getCarTopSpeed()));
        carRegistrationV.setText(String.format("Registration: %s", carToShow.getCarRegistration()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImage:
                onBackPressed();
        }
    }
}
