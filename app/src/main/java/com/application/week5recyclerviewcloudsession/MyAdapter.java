package com.application.week5recyclerviewcloudsession;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<MyDataModel> personsList;

    public MyAdapter(Context mContext, ArrayList<MyDataModel> personsList) {
        this.mContext = mContext;
        this.personsList = personsList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflating the layout
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout, parent, false);
        return new MyViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        //attach data to layout views
        holder.mTextView.setText(personsList.get(position).getName());
        holder.mTextViewDescription.setText(personsList.get(position).getDescription());
        holder.imageView.setImageResource(personsList.get(position).getImage());
//        holder.mTextViewDescription.setText(personsList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        //get the size of the arraylist
        return personsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTextView, mTextViewDescription;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.nameTextView);
            mTextViewDescription = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(mContext, AnotherActivity.class)
            int position = getLayoutPosition();
            personsList.set(position, new MyDataModel("Updated Name", "Updated Description", R.drawable.floating_icon));
            notifyDataSetChanged();

        }
    }
}
