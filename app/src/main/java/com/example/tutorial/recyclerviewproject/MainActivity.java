package com.example.tutorial.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1","Line 1.1"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 2","Line 2.1"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 3","Line 3.1"));
    }
}
