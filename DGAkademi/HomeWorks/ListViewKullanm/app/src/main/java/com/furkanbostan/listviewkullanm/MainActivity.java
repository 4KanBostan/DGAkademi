package com.furkanbostan.listviewkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.furkanbostan.listviewkullanm.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] okullar = {"Marmara","İTÜ", "Boğaziçi","Medeniyet", "ODTÜ",
            "Marmara","İTÜ", "Boğaziçi","Medeniyet", "ODTÜ",
            "Marmara","İTÜ", "Boğaziçi","Medeniyet", "ODTÜ",
            "Marmara","İTÜ", "Boğaziçi","Medeniyet", "ODTÜ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        listView =(ListView) binding.mainActivityListView;
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, okullar);
        listView.setAdapter(adapter);
    }
}