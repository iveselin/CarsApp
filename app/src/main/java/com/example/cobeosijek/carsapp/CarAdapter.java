package com.example.cobeosijek.carsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> cars = new ArrayList<>();

    public void setCarList(List<Car> carList) {
        cars.clear();
        cars.addAll(carList);
        notifyDataSetChanged();
    }

    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View carView = inflater.inflate(R.layout.item_car, parent, false);

        return new ViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);

        holder.carName.setText(car.getCarModel());
        holder.carAge.setText("Production year: " + car.getCarAge());

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView carImage;
        TextView carName;
        TextView carAge;

        public ViewHolder(View itemView) {
            super(itemView);

            this.carImage = itemView.findViewById(R.id.carImage);
            this.carName = itemView.findViewById(R.id.carName);
            this.carAge = itemView.findViewById(R.id.carAge);
        }
    }
}
