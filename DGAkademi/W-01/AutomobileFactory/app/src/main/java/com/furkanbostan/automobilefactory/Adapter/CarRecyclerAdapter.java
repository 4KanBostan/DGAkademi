package com.furkanbostan.automobilefactory.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanbostan.automobilefactory.Car.Car;
import com.furkanbostan.automobilefactory.DetailsActivity;
import com.furkanbostan.automobilefactory.R;

import java.util.ArrayList;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Car> cars;

    public CarRecyclerAdapter(Context context, ArrayList<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_recyc_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Car car = cars.get(position);
        holder.model_tv.setText(cars.get(position).getModel());
        holder.marka_tv.setText(cars.get(position).getMarka());
        holder.imgLogo.setImageResource(cars.get(position).getLogo());
        holder.layoutCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("carInfo",  car.carInfo());
                bundle.putString("carModel",  car.getModel());
                bundle.putString("carMarka",  car.getMarka());
                bundle.putInt("carImage",  car.getLogo());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView model_tv, marka_tv;
        ImageView imgLogo;
        ConstraintLayout layoutCar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imageView);
            model_tv = itemView.findViewById(R.id.textView4);
            marka_tv = itemView.findViewById(R.id.textView3);
            layoutCar = itemView.findViewById(R.id.layout_car);

        }
    }
}
