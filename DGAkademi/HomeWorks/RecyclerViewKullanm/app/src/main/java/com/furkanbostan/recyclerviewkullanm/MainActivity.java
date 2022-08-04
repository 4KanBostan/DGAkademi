package com.furkanbostan.recyclerviewkullanm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Car> cars;
    private RecyclerView recyclerView;
    private CarRecyclerAdapter carRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewSettings();

        cars.add(new Car("M8 Gran Coupe","BMW",R.drawable.img));
        cars.add(new Car("Fiesta","FORD",R.drawable.img_1));
        cars.add(new Car("Corolla","TOYOTA",R.drawable.img_10));
        cars.add(new Car("Scala","SKODA",R.drawable.img_2));
        cars.add(new Car("CONTİNENTAL GT S","BENTLEY",R.drawable.img_3));
        cars.add(new Car("A4","AUDİ",R.drawable.img_4));
        cars.add(new Car("Giulietta","ALFA ROMEO",R.drawable.img_5));
        cars.add(new Car("Astra","OPEL",R.drawable.img_6));
        cars.add(new Car("Duster","DACIA",R.drawable.img_7));
        cars.add(new Car("Model S","TESLA",R.drawable.img_8));
        cars.add(new Car("Corvette","CHEVROLET",R.drawable.img_9));

    }

    private void viewSettings(){
        recyclerView = findViewById(R.id.recylclerView);
        cars = new ArrayList<>();
        carRecyclerAdapter =new CarRecyclerAdapter(cars);
        recyclerView.setAdapter(carRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}