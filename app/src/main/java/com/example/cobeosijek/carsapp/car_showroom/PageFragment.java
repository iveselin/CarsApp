
package com.example.cobeosijek.carsapp.car_showroom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.carsapp.car_details.CarDetailsActivity;
import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.car_showroom.utils.CarMaker;
import com.example.cobeosijek.carsapp.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class PageFragment extends Fragment implements CarAdapter.OnItemClickListener {

    private static final String KEY_CAR_TYPE = "carTYPE";

    private List<Car> carList = new ArrayList<>();
    private int carTypeFlag;
    private CarAdapter carAdapter;

    public static PageFragment newInstance(int carTypeKey) {
        Bundle args = new Bundle();
        args.putInt(KEY_CAR_TYPE, carTypeKey);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carTypeFlag = getArguments().getInt(KEY_CAR_TYPE, 1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUI(view);
    }

    private void setUI(View view) {
        carAdapter = new CarAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        carAdapter.setOnItemClickListener(this);

        RecyclerView carListRV = view.findViewById(R.id.carList);
        carListRV.addItemDecoration(itemDecoration);
        carListRV.setLayoutManager(layoutManager);
        carListRV.setAdapter(carAdapter);
        setCars();
    }

    private void setCars() {
        carList = CarMaker.createCars();

        if (carTypeFlag == Constants.KEY_FAVOURITE_CARS) {
            List<Car> favourites = new ArrayList<>();
            for (Car car : carList) {
                if (car.isFavourite()) {
                    favourites.add(car);
                }
            }
            carList = favourites;
        }
        carAdapter.setCarList(carList);
    }

    @Override
    public void onCarClick(View view, int position) {
        startActivity(CarDetailsActivity.getLaunchIntent(getActivity(), carList.get(position)));
    }
}
