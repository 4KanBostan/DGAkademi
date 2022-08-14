package com.furkanbostan.automobilefactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.furkanbostan.automobilefactory.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        String carInfo = extras.getString("carInfo");
        String carModel = extras.getString("carModel");
        String carMarka = extras.getString("carMarka");
        int carImage = extras.getInt("carImage");
        Log.d("deneme", carMarka);

        TextView marka = (TextView) findViewById(R.id.tv_Marka);
        marka.setText("Marka: "+carMarka);
        TextView model = (TextView) findViewById(R.id.tv_Model);
        model.setText("Model : "+carModel);
        TextView info = (TextView) findViewById(R.id.tv_Info);
        info.setText("Araç Bilgisi : "+carInfo);

        ImageView image = findViewById(R.id.car_imageView);
        image.setImageResource(carImage);



    }
}