package com.example.gupta.recyclerlist;

import android.view.View;

/**
 * Created by Anuj on 11/6/2016.
 */

public interface TaskClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
