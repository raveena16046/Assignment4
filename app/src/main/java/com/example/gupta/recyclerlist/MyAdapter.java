package com.example.gupta.recyclerlist;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.start;
import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by GUPTA on 02-11-2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ToDoItem> mDataset;
    private ToDoItem mTask;
    private int mPosition = 0;

    public MyAdapter(List<ToDoItem> moviesList) {
        this.mDataset = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mPosition = position;
        mTask = mDataset.get(position);
        holder.title.setText(mTask.getTitle());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;

        public MyViewHolder(final View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ToDoItem myObject = mDataset.get(getAdapterPosition());
            //  Toast.makeText(view.getContext() , myObject.getTitle() ,Toast.LENGTH_SHORT).show();

        }
    }


}
