package com.example.cobeosijek.carsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cobeosijek.carsapp.utilities.CarMaker;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class PageFragment extends Fragment implements CarAdapter.OnItemClickListener {

    public static final String ARG_PAGE = "ARG_PAGE";

    RecyclerView carListRV;
    CarAdapter carAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemDecoration itemDecoration;

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        carListRV = view.findViewById(R.id.carList);
        carAdapter = new CarAdapter();
        carAdapter.setCarList(CarMaker.createCars());
        layoutManager = new LinearLayoutManager(container.getContext());
        itemDecoration = new DividerItemDecoration(container.getContext(), DividerItemDecoration.VERTICAL);

        carListRV.addItemDecoration(itemDecoration);
        carListRV.setLayoutManager(layoutManager);
        carListRV.setAdapter(carAdapter);

        carAdapter.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onCarClick(View view, int position) {
        Toast.makeText(getActivity(), "Clicked on position: " + position, Toast.LENGTH_SHORT).show();
        // TODO: 17/10/2017 why yu no wrk 
    }
}
