package com.example.cobeosijek.carsapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_SEND_EMAIL = "email";

    TextView userEmailTV;
    ImageView backIV;

    public static Intent getLaunchIntent(Context context, String email) {
        return new Intent(context, CarsActivity.class).putExtra(KEY_SEND_EMAIL, email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        setUI();
    }

    private void setUI() {
        userEmailTV = findViewById(R.id.userEmail);
        userEmailTV.setText(getIntent().getStringExtra(KEY_SEND_EMAIL));
        backIV = findViewById(R.id.backImage);
        backIV.setOnClickListener(this);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new SimpleFragmentPageAdapter(getSupportFragmentManager(), this));

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImage:
                onBackPressed();
                break;
        }
    }
}
