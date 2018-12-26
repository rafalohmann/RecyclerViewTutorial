package com.example.tutorial.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText editTextInsert;
    private Button buttonInsert;
    private EditText editTextRemove;
    private Button buttonRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        createRecyclerView();

        editTextInsert = findViewById(R.id.edittext_insert);
        buttonInsert = findViewById(R.id.button_insert);
        editTextRemove = findViewById(R.id.edittext_remove);
        buttonRemove = findViewById(R.id.button_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    public void insertItem(int position) {
        int lastIndex = mExampleList.size() - 1;
        if (position > lastIndex)
            position = lastIndex;
        mExampleList.add(position, new ExampleItem(R.drawable.ic_new, "New item on position " + position, "Position " + position));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        int lastIndex = mExampleList.size() - 1;
        if (position <= lastIndex)
        {
            mExampleList.remove(position);
            mAdapter.notifyItemRemoved(position);
        }
    }

    public void changeItem(int position, String newText) {
        int lastIndex = mExampleList.size() - 1;
        if (position <= lastIndex)
        {
            mExampleList.get(position).setText1(newText);
            mAdapter.notifyItemChanged(position);
        }
    }

    public void createExampleList() {
        mExampleList = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            mExampleList.add(new ExampleItem(R.drawable.ic_android, "Line " + i,"Line " + i + ".1"));
            mExampleList.add(new ExampleItem(R.drawable.ic_audio, "Line " + i,"Line " + i + ".1"));
            mExampleList.add(new ExampleItem(R.drawable.ic_sun, "Line " + i,"Line " + i + ".1"));
        }
    }

    public void createRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
        });
    }
}