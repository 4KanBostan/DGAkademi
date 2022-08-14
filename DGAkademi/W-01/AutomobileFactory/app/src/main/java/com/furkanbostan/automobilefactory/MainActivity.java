package com.furkanbostan.automobilefactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanbostan.automobilefactory.Adapter.CarRecyclerAdapter;
import com.furkanbostan.automobilefactory.Car.Audi;
import com.furkanbostan.automobilefactory.Car.BMW;
import com.furkanbostan.automobilefactory.Car.Car;
import com.furkanbostan.automobilefactory.Car.Mercedes;
import com.furkanbostan.automobilefactory.SignIn.RegisterActivity;
import com.furkanbostan.automobilefactory.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    private ArrayList<Car> cars;
    private RecyclerView recyclerView;
    private CarRecyclerAdapter carRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        checkCurrentUser();


        Car car1 = new BMW("M8 Gran Coupe","BMW",R.drawable.img);
        Car car2 = new BMW("M8 Gran Coupe","BMW",R.drawable.img);
        Car car3 = new BMW("M8 Gran Coupe","BMW",R.drawable.img);
        Car car4 = new BMW("M8 Gran Coupe","BMW",R.drawable.img);

        Car car5 = new Audi("A4","AUDİ",R.drawable.img_4);
        Car car6 = new Audi("A4","AUDİ",R.drawable.img_4);
        Car car7 = new Audi("A4","AUDİ",R.drawable.img_4);
        Car car8 = new Audi("A4","AUDİ",R.drawable.img_4);

        Car car9 = new Mercedes("C220","AUDI",R.drawable.img_11);
        Car car10 = new Mercedes("C220","AUDI",R.drawable.img_11);
        Car car11 = new Mercedes("C220","AUDI",R.drawable.img_11);
        Car car12= new Mercedes("C220","AUDI",R.drawable.img_11);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);
        cars.add(car11);
        cars.add(car12);











    }

    private void checkCurrentUser(){
        mAuth= FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            viewSettings();// kullanıcı mevcut devam et
        }else {
            finish();
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
    private void viewSettings(){
        recyclerView = findViewById(R.id.recyclerView);
        cars = new ArrayList<>();
        carRecyclerAdapter =new CarRecyclerAdapter(this,cars);
        recyclerView.setAdapter(carRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}