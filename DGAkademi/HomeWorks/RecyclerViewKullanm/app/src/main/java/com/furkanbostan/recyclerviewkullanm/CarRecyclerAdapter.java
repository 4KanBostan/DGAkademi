package com.furkanbostan.recyclerviewkullanm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.MyViewHolder> {
    private ArrayList<Car> cars;

    public CarRecyclerAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.model_tv.setText(cars.get(position).getModel());
        holder.marka_tv.setText(cars.get(position).getModel());
        holder.imgLogo.setImageResource(cars.get(position).getLogo());

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView model_tv, marka_tv;
        ImageView imgLogo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imageView);
            model_tv = itemView.findViewById(R.id.textView4);
            marka_tv = itemView.findViewById(R.id.textView3);
        }
    }
}
