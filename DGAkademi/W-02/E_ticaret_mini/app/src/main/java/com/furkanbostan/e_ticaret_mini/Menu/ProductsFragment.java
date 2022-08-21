package com.furkanbostan.e_ticaret_mini.Menu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.furkanbostan.e_ticaret_mini.Adapters.ProductRecyclerAdapter;
import com.furkanbostan.e_ticaret_mini.Models.Product;
import com.furkanbostan.e_ticaret_mini.R;
import com.furkanbostan.e_ticaret_mini.databinding.FragmentProductsBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class ProductsFragment extends Fragment {
    private FragmentProductsBinding binding;
    private FirebaseAuth mAuth;
    private ArrayList<Product> products;
    public ArrayList<Product> productsShop;
    private RecyclerView recyclerView;
    private ProductRecyclerAdapter productRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkCurrentUser(view);
        binding.shopItem.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                NavDirections action = ProductsFragmentDirections.actionProductsFragmentToShoppingCartFragment((Product[]) productsShop.stream().toArray());
                Navigation.findNavController(v).navigate(action);



            }
        });

    }





    private void checkCurrentUser(View v){
        mAuth= FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            viewSettings(v);
            productAdd(); // kullanıcı mevcut devam et
        }else {
            NavDirections action = ProductsFragmentDirections.actionProductsFragmentToLoginFragment();
            Navigation.findNavController(v).navigate(action);
        }
    }

    private void viewSettings(View v) {
        recyclerView = binding.recyclerViewProduct;
        products = new ArrayList<>();

        productRecyclerAdapter = new ProductRecyclerAdapter(v.getContext(), products,productsShop);
        recyclerView.setAdapter(productRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
    }

    private void productAdd(){

        addList( new Product("Pantolon","340",R.drawable.img,0));
        addList(  new Product("Pantolon","340",R.drawable.img_1,0));
        addList(  new Product("Şort","340",R.drawable.img_2,0));
        addList(  new Product("Şort","340",R.drawable.img_3,0));
        addList(  new Product("T-Shirt","340",R.drawable.img_4,0));
        addList(  new Product("T-Shirt","340",R.drawable.img_5,0));
        addList(  new Product("T-Shirt","340",R.drawable.img_6,0));
        addList(  new Product("Ayakkabı","340",R.drawable.img_7,0));
        addList(  new Product("Ayakkabı","340",R.drawable.img_8,0));
        addList(  new Product("Ayakkabı","340",R.drawable.img_9,0));
        addList(  new Product("Ayakkabı","340",R.drawable.img_10,0));

    }
    private void addList(Product product){
        products.add(product);
    }
}