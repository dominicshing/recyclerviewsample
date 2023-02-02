package com.creativesky.recyclerviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.creativesky.recyclerviewsample.recyclerviewrequiredparts.ListItemModel;
import com.creativesky.recyclerviewsample.recyclerviewrequiredparts.RecycleViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListItemModel> listItemList;

    RecyclerView recyclerView;

    int images[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        images   = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8};

        setUpListItemModel();

        RecycleViewAdapter myAdapter = new RecycleViewAdapter(this, listItemList);
        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpListItemModel(){

        listItemList = new ArrayList<>();

        String[] imgNames = getResources().getStringArray(R.array.sample_image_name);
        String[] imgDescs = getResources().getStringArray(R.array.sample_image_desc);

        for(int i = 0; i < imgNames.length; i++) {
            ListItemModel listItem =  new ListItemModel(images[i], imgNames[i], imgDescs[i]);
            listItemList.add(listItem);
        }


    }
}