
/*
                Name = Surpreet singh
                Student Id = 218663803
                Unit = SIT305-Task5.1
*/



package com.application.week5recyclerviewcloudsession;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



// This Java file defines a custom adapter class for a RecyclerView.
// The adapter class is responsible for creating and binding views for each item in the RecyclerView.
// It takes a list of MyDataModel objects as input.
// The MyViewHolder class defines the layout for each item in the RecyclerView.
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // Define variables for the context and list of data models
    Context mContext;
    ArrayList<MyDataModel> personsList;

    // Constructor for MyAdapter class
    public MyAdapter(Context mContext, ArrayList<MyDataModel> personsList) {
        // Initialize context and list of data models
        this.mContext = mContext;
        this.personsList = personsList;
    }

    // Override onCreateViewHolder method to inflate layout for each item in RecyclerView
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate layout for each item in RecyclerView
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout, parent, false);
        // Return ViewHolder with inflated view
        return new MyViewHolder(view);
    }

    // Override onBindViewHolder method to bind data to layout views
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        // Bind data to views in layout
        holder.mTextView.setText(personsList.get(position).getOrganization());
        holder.mTextViewDescription.setText(personsList.get(position).getDescription());
        holder.imageView.setImageResource(personsList.get(position).getImage());
    }

    // Override getItemCount method to return the size of the list of data models
    @Override
    public int getItemCount() {
        return personsList.size();
    }

    // Define MyViewHolder class to hold layout views for each item in RecyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Define layout views
        TextView mTextView, mTextViewDescription;
        ImageView imageView;

        // Constructor for MyViewHolder class
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find views by their IDs in layout
            mTextView = itemView.findViewById(R.id.nameTextView);
            mTextViewDescription = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
            // Set click listener for item view
            itemView.setOnClickListener(this);
        }

        // Override onClick method to handle item click events
        @Override
        public void onClick(View v) {
            // Get position of clicked item
            int position = getAdapterPosition();
            // Create new NewsFragment with position and list of data models as arguments
            Fragment fragment = NewsFragment.newInstance(position,personsList);
            // Get FragmentManager from current activity
            FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
            // Start new transaction to replace current fragment with NewsFragment
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.abcd, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
