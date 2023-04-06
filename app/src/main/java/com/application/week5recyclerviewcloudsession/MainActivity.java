package com.application.week5recyclerviewcloudsession;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<MyDataModel> personsList;

    MyAdapter myAdapter;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        personsList = new ArrayList<>();
        personsList.add(new MyDataModel("Name 1", "This is description 1", R.drawable.ic_action_name));
        personsList.add(new MyDataModel("Name 2", "This is description 2",R.drawable.ic_action_name));
        personsList.add(new MyDataModel("Name 3", "This is description 3",R.drawable.ic_action_name));
        personsList.add(new MyDataModel("Name 4", "This is description 4",R.drawable.ic_action_name));
        personsList.add(new MyDataModel("Name 5", "This is description 5",R.drawable.ic_action_name));
        personsList.add(new MyDataModel("Name 6", "This is description 6",R.drawable.ic_action_name));


        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(this, personsList);

        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personsList.add(new MyDataModel("Added Name", "This is description 1",R.drawable.ic_action_name));
                mRecyclerView.getAdapter().notifyItemInserted(personsList.size());
                mRecyclerView.smoothScrollToPosition(personsList.size());


            }
        });


    }


}