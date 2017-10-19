package com.example.cobeosijek.carsapp.car_details;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cobeosijek.carsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cobeosijek on 18/10/2017.
 */

public class ImageAdapter extends PagerAdapter {

    private List<String> images;

    public ImageAdapter(List<String> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }


    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View carView = inflater.inflate(R.layout.list_item_image, container, false);

        ImageView imageView = carView.findViewById(R.id.car_image);
        Picasso.with(imageView.getContext()).load(images.get(position)).into(imageView);
        container.addView(carView, 0);

        return carView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView((View) obj);
    }
}
