package com.furkanbostan.e_ticaret_mini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.furkanbostan.e_ticaret_mini.Menu.ProductsFragment;
import com.furkanbostan.e_ticaret_mini.Models.Product;
import com.furkanbostan.e_ticaret_mini.databinding.ActivityMainBinding;
import com.furkanbostan.e_ticaret_mini.databinding.FragmentProductsBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.sepet:
                Navigation.findNavController(item.getActionView()).navigate(R.id.shoppingCartFragment);
                break;
            case R.id.profil:
                break;

            case R.id.quit:
                break;

            case R.id.SignOut:
                break;

        }
        return super.onOptionsItemSelected(item);
    }*/
}