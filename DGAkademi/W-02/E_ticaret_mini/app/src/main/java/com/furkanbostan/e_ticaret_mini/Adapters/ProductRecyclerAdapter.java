package com.furkanbostan.e_ticaret_mini.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanbostan.e_ticaret_mini.Menu.ShoppingCartFragment;
import com.furkanbostan.e_ticaret_mini.Models.Product;
import com.furkanbostan.e_ticaret_mini.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {
    private Context context;
    public ArrayList<Product> products;
    public ArrayList<Product> productsShop = new ArrayList<>();
    public ProductRecyclerAdapter(){

    }

    public ProductRecyclerAdapter(Context context, ArrayList<Product> products, ArrayList<Product> productsShop) {
        this.context = context;
        this.products = products;
        this.productsShop = productsShop;
    }

    public ProductRecyclerAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product prd = products.get(position);
        holder.name_tv.setText(prd.getName());
        holder.cost_tv.setText(prd.getCost());
        holder.count_tv.setText(String.valueOf(prd.getCounter()));
        holder.image.setImageResource(prd.getImageURL());

        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productsShop.add(prd);

                prd.setCounter(prd.getCounter()+1);
                holder.count_tv.setText(String.valueOf(prd.getCounter()));
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) productsShop);


            }
        });

        holder.remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prd.getCounter()>1){
                    prd.setCounter(prd.getCounter()-1);
                    holder.count_tv.setText(String.valueOf(prd.getCounter()));
                }else if (prd.getCounter()==1){
                    productsShop.remove(prd);
                    prd.setCounter(prd.getCounter()-1);
                    holder.count_tv.setText(String.valueOf(prd.getCounter()));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name_tv, cost_tv, count_tv;
        ImageView image;
        ImageButton add_btn;
        ImageButton remove_btn;
        public MyViewHolder(@NonNull View itemView) {
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
