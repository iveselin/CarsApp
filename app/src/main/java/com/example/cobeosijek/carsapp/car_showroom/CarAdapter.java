package com.example.cobeosijek.carsapp.car_showroom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    public interface OnItemClickListener {
        void onCarClick(View view, int position);
    }

    private List<Car> cars = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setCarList(List<Car> carList) {
        cars.clear();
        cars.addAll(carList);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View carView = inflater.inflate(R.layout.item_car, parent, false);

        return new CarViewHolder(carView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        if (cars.isEmpty() || cars.get(position) == null) {
            return;
        }
        Car car = cars.get(position);

        Context holderContext = holder.itemView.getContext();
        holder.carName.setText(car.getCarModel());
        holder.carAge.setText(String.format(holderContext.getString(R.string.car_list_age_format), car.getCarAge()));
        if (car.getCarImages() != null && !car.getCarImages().isEmpty()) {
            Picasso.with(holderContext).load(car.getCarImages().get(0)).into(holder.carImage);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
