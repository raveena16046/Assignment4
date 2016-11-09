package com.example.gupta.recyclerlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

/**
 * Created by GUPTA on 03-11-2016.
 */

public class TaskActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PagerAdapter mAdapter;
    private List<ToDoItem> myDataset;
    private ToDoItemSource mDatabaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_task);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.show_task_toolbar);
        setSupportActionBar(myToolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);


        mViewPager = (ViewPager) findViewById(R.id.pager);
        mDatabaseHelper = new ToDoItemSource(this);
        mDatabaseHelper.open();
        myDataset = mDatabaseHelper.getAllComments();


        mAdapter = new ViewPagerAdapter(TaskActivity.this, myDataset);
        mViewPager.setAdapter(mAdapter);
        Intent intent = getIntent();
        int position = intent.getIntExtra("POSITION", 0);
        mViewPager.setCurrentItem(position);
        mDatabaseHelper.close();
    }

}


