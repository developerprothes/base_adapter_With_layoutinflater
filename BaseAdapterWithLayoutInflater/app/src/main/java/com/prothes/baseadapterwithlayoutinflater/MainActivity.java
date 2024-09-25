package com.prothes.baseadapterwithlayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private int[] flag = {
            R.drawable.bangladesh,R.drawable.russia,R.drawable.india,R.drawable.nepal,R.drawable.brazil,
            R.drawable.australia,R.drawable.canada,R.drawable.unitedkingdom,R.drawable.unitedstates,R.drawable.china,
            R.drawable.colombia,R.drawable.france,R.drawable.germany,R.drawable.hongkong,R.drawable.ireland,
            R.drawable.japan,R.drawable.myanmar,R.drawable.southkorea,R.drawable.switzerland,R.drawable.uruguay
    };
    private String[] countryName, countryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        countryName = getResources().getStringArray(R.array.item_title);
        countryDetails = getResources().getStringArray(R.array.item_details);

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this,flag,countryName,countryDetails);
        listview.setAdapter(customBaseAdapter);


    }
}