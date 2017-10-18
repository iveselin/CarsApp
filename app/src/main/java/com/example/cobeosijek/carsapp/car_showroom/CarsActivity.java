package com.example.cobeosijek.carsapp.car_showroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_SEND_EMAIL = "email";

    TextView userEmailTV;
    ImageView backIV;
    private List<String> tabTitles = new ArrayList<>();

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

        tabTitles.add("All");
        tabTitles.add("Favourites");

        SimpleFragmentPageAdapter pageAdapter = new SimpleFragmentPageAdapter(getSupportFragmentManager());
        pageAdapter.setTabTitles(tabTitles);
        pageAdapter.addFragment(PageFragment.newInstance(Constants.KEY_ALL_CARS));
        pageAdapter.addFragment(PageFragment.newInstance(Constants.KEY_FAVOURITE_CARS));

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);


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
