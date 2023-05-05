
/*
                Name = Surpreet singh
                Student Id = 218663803
                Unit = SIT305-Task5.1
*/




package com.application.week5recyclerviewcloudsession;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


// This is a Java class named NewsFragment that extends the Fragment class.
public class NewsFragment extends Fragment {

    // Define the Context and position variables as instance variables.
    Context mContext;
    int position;


    // Public constructor that initializes the NewsFragment class.
    public NewsFragment() {

    }

    // Static method to create a new instance of NewsFragment with arguments.
    // Takes an integer position and an ArrayList of MyDataModel objects.
    public static NewsFragment newInstance(int position,ArrayList<MyDataModel> arrayList) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putSerializable("myDataList", arrayList);
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }


    // Override the onCreate() method of the Fragment class.
    // Called when the fragment is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContext = getContext();


        }
    }

    // Override the onCreateView() method of the Fragment class.
    // Called when the fragment's UI is first created.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_news, container, false);

        // Define variables for a RecyclerView, its LayoutManager, an ImageView and an Adapter.
        RecyclerView mRecyclerViewRelatedNews;
        RecyclerView.LayoutManager layoutManagerRelatedNews;
        ImageView imageView;
        MyAdapter myAdapterRelatedNews;

        // Retrieve the arguments passed to the fragment using getArguments().
        // Extract the ArrayList and position information.
        ArrayList<MyDataModel> myDataList = (ArrayList<MyDataModel>) getArguments().getSerializable("myDataList");
        int position2 = getArguments().getInt("position");

        // Find the relevant UI elements in the inflated layout.
        TextView textViewTitle = view.findViewById(R.id.textView7);
        TextView editTextDes = view.findViewById(R.id.textView10);
        mRecyclerViewRelatedNews = view.findViewById(R.id.recyclerViewFrag);
        imageView = view.findViewById(R.id.imageView4);

        // Set up the RecyclerView's LayoutManager and Adapter.
        layoutManagerRelatedNews = new GridLayoutManager(getActivity(), 2);
        myAdapterRelatedNews = new MyAdapter(getActivity(), myDataList);
        mRecyclerViewRelatedNews.setAdapter(myAdapterRelatedNews);
        mRecyclerViewRelatedNews.setLayoutManager(layoutManagerRelatedNews);

        // Set the title, description and image of the news item to the relevant UI elements.
        textViewTitle.setText(myDataList.get(position2).getOrganization());
        editTextDes.setText(myDataList.get(position2).getDescription());
        imageView.setImageResource(myDataList.get(position2).getImage());

        // Return the inflated layout as the fragment's UI.
        return view;
    }
}