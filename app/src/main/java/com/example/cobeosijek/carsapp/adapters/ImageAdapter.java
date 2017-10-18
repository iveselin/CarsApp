package com.example.cobeosijek.carsapp.adapters;

import android.content.Context;
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
    Context context;
    List<String> images;

    public ImageAdapter(Context context, List<String> images) {
        this.context = context;
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
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((View) obj);
    }
}
