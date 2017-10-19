package com.example.cobeosijek.carsapp.car_showroom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.R;

/**
 * Created by Ivan on 19.10.2017..
 */

public class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CarAdapter.OnItemClickListener listener;
    ImageView carImage;
    TextView carName;
    TextView carAge;

    public CarViewHolder(View itemView, CarAdapter.OnItemClickListener listener) {
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
