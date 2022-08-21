package com.furkanbostan.e_ticaret_mini.Menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.furkanbostan.e_ticaret_mini.Adapters.ProductRecyclerAdapter;
import com.furkanbostan.e_ticaret_mini.Adapters.ShoppingCartRecyclerAdapter;
import com.furkanbostan.e_ticaret_mini.Models.Product;
import com.furkanbostan.e_ticaret_mini.R;
import com.furkanbostan.e_ticaret_mini.databinding.FragmentProductsBinding;
import com.furkanbostan.e_ticaret_mini.databinding.FragmentShopBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class ShoppingCartFragment extends Fragment {
    private FragmentShopBinding binding;
    private FirebaseAuth mAuth;
    public  ArrayList<Product> productsShop1= new ArrayList<>();
    private RecyclerView recyclerView;
    private ShoppingCartRecyclerAdapter shoppingCartRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentShopBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewSettings(view);



        Product prd = getArguments().getParcelable("list");
        Log.d("asdasd", prd.getName());

    }


    private void viewSettings(View v) {
        recyclerView = binding.recyclerViewShoppingCart;
        productsShop1 = new ArrayList<>();
        shoppingCartRecyclerAdapter= new ShoppingCartRecyclerAdapter(v.getContext(), productsShop1);
        recyclerView.setAdapter(shoppingCartRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
    }
}