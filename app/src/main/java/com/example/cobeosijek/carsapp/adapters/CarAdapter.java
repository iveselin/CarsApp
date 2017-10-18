package com.example.cobeosijek.carsapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.Car;
import com.example.cobeosijek.carsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

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
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View carView = inflater.inflate(R.layout.item_car, parent, false);

        return new ViewHolder(carView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);

        holder.carName.setText(car.getCarModel());
        holder.carAge.setText("Production year: " + car.getCarAge());
        Picasso.with(holder.itemView.getContext()).load(car.getCarImages().get(0)).resize(300,200).into(holder.carImage);

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CarAdapter.OnItemClickListener listener;
        ImageView carImage;
        TextView carName;
        TextView carAge;

        public ViewHolder(View itemView, CarAdapter.OnItemClickListener listener) {
            super(itemView);

            this.carImage = itemView.findViewById(R.id.carImage);
            this.carName = itemView.findViewById(R.id.carName);
            this.carAge = itemView.findViewById(R.id.carAge);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onCarClick(view, getAdapterPosition());
            }
        }
    }
}
