package com.example.tutorial.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<ExampleItem> exampleList = new ArrayList();

        setContentView(R.layout.activity_main);        for (int i = 1; i <= 10; i++) {
            exampleList.add(new ExampleItem(R.drawable.ic_android, "Line " + i,"Line " + i + ".1"));
            exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line " + i,"Line " + i + ".1"));
            exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line " + i,"Line " + i + ".1"));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
