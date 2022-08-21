package com.furkanbostan.e_ticaret_mini.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanbostan.e_ticaret_mini.Models.Product;
import com.furkanbostan.e_ticaret_mini.R;

import java.util.ArrayList;

public class ShoppingCartRecyclerAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerAdapter.MyViewHolder1> {

    private Context context;
    private ArrayList<Product> products;

    public ShoppingCartRecyclerAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products,parent,false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        Product prd = products.get(position);
        holder.name_tv.setText(prd.getName());
        holder.cost_tv.setText(prd.getCost());
        holder.count_tv.setText(String.valueOf(prd.getCounter()));
        holder.image.setImageResource(prd.getImageURL());

        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
         return products.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder{

        TextView name_tv, cost_tv, count_tv;
        ImageView image;
        ImageButton add_btn;
        ImageButton remove_btn;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            name_tv = itemView.findViewById(R.id.tv_name_prdct);
            cost_tv = itemView.findViewById(R.id.tv_cost_prdct);
            count_tv =itemView.findViewById(R.id.tv_counter_prdct);
            image = itemView.findViewById(R.id.image_prdct);
            add_btn = itemView.findViewById(R.id.imageButton_add_prdct);
            remove_btn =itemView.findViewById(R.id.imageButton_remove_prdct);
        }
    }
}
