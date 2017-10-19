package com.example.cobeosijek.carsapp.car_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.car_showroom.Car;
import com.example.cobeosijek.carsapp.R;

import me.relex.circleindicator.CircleIndicator;

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_CAR_SENT = "car_sent";

    ImageView backV;

    ViewPager carImageVP;
    TextView carNameV;
    TextView carAgeV;
    TextView carTopSpeedV;
    TextView carRegistrationV;
    Car carToShow;

    public static Intent getLaunchIntent(Context context, Car car) {
        return new Intent(context, CarDetailsActivity.class).putExtra(KEY_CAR_SENT, car);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        getExtras();
        setUI();
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_CAR_SENT)) {
            carToShow = (Car) getIntent().getSerializableExtra(KEY_CAR_SENT);
        }
    }

    private void setUI() {
        backV = findViewById(R.id.backImage);
        carImageVP = findViewById(R.id.imagePager);
        carNameV = findViewById(R.id.carDetailsName);
        carAgeV = findViewById(R.id.carDetailsAge);
        carTopSpeedV = findViewById(R.id.carDetailsTopSpeed);
        carRegistrationV = findViewById(R.id.carDetailsRegistration);

        backV.setOnClickListener(this);

        if (carToShow != null) {
            // TODO: 19/10/2017 getCarImages to set car images, not in constr.
            ImageAdapter imageAdapter = new ImageAdapter(carToShow.getCarImages());
            carImageVP.setAdapter(imageAdapter);
            if (imageAdapter.getCount() > 1) {
                CircleIndicator circleIndicator = findViewById(R.id.indicator);
                circleIndicator.setViewPager(carImageVP);
            }

            carNameV.setText(carToShow.getCarModel());
            carAgeV.setText(String.format(getString(R.string.car_details_age_format), carToShow.getCarAge()));
            carTopSpeedV.setText(String.format(getString(R.string.car_details_speed_format), carToShow.getCarTopSpeed()));
            carRegistrationV.setText(String.format(getString(R.string.car_details_registration_format), carToShow.getCarRegistration()));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImage:
                onBackPressed();
        }
    }
}
