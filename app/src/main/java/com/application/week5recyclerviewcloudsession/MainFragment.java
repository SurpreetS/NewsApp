

/*
                Name = Surpreet singh
                Student Id = 218663803
                Unit = SIT305-Task5.1
*/



package com.application.week5recyclerviewcloudsession;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

// This is a Java class file for a fragment that displays news articles in a RecyclerView
public class MainFragment extends Fragment {



    // Constructor for the fragment
    public MainFragment() {
        // Required empty public constructor
    }

    // Method to create a new instance of the fragment
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call the superclass onCreate method and pass the saved instance state
        // Check if there are any arguments passed to the fragment
        if (getArguments() != null) {
            // Do something if arguments exist
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment's layout using the given inflater and container
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Declare variables for the RecyclerViews and their layouts
        RecyclerView mRecyclerView, recyclerViewNews;
        RecyclerView.LayoutManager layoutManager, layoutManagerNews;

        // Declare an ArrayList to store the news items
        ArrayList<MyDataModel> newsListArray;

        // Declare an adapter for the RecyclerView
        MyAdapter myAdapter;

        // Declare a FloatingActionButton to add news items
        FloatingActionButton floatingActionButton;

        // Find the RecyclerViews and FloatingActionButton in the fragment's layout
        mRecyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews);


        // Create an ArrayList of news items
        newsListArray = new ArrayList<>();
        newsListArray.add(new MyDataModel("The Age", "Why a new $1.1 billion prison in Victoria is sitting empty",R.drawable.theage));
        newsListArray.add(new MyDataModel("The Guardian", "Mehreen Faruqi to sue Pauline Hanson over offensive tweet",R.drawable.thegaurdian));
        newsListArray.add(new MyDataModel("9 News", "Two police officers stabbed, man shot dead in rural South Australia",R.drawable.news9));
        newsListArray.add(new MyDataModel("The Courier Mail", "Alleged killer teen’s criminal history exposes Premier’s ‘powerless’ laws",R.drawable.couriermail));
        newsListArray.add(new MyDataModel("Perth Now", "Serbian boy guns down students in Belgrade primary school rampage",R.drawable.perthnow));
        newsListArray.add(new MyDataModel("The Australian", "No money to run ‘spare $1bn prison’",R.drawable.theage));


        // Set the layouts for the RecyclerViews
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        layoutManagerNews =new GridLayoutManager(getActivity(), 2);

        // Create a new adapter and pass in the news items ArrayList
        myAdapter = new MyAdapter(getActivity(), newsListArray);

        // Set the adapter and layout manager for the RecyclerViews
        mRecyclerView.setAdapter(myAdapter);
        recyclerViewNews.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        recyclerViewNews.setLayoutManager(layoutManagerNews);



        return view;
    }
}