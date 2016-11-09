package com.example.gupta.recyclerlist;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddTask extends AppCompatActivity {

    private static final String TAG = "ADD ACTIVITY";
    private EditText mTitleTextview;
    private EditText mDetailTextview;
    private ToDoItemSource mDbhelper = new ToDoItemSource(this);
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.add_task_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        mSaveButton = (Button) findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Saved", Toast.LENGTH_SHORT).show();
                mTitleTextview = (EditText) findViewById(R.id.title_textview);
                String title = mTitleTextview.getText().toString();

                mDetailTextview = (EditText) findViewById(R.id.detail_textview);
                String detaill = mDetailTextview.getText().toString();

                mDbhelper.open();
                ToDoItem item = mDbhelper.createItem(title, detaill);
                Log.d(TAG, item.getDetail());
                mDbhelper.close();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // your code.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
