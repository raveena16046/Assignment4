package com.example.gupta.recyclerlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUPTA on 02-11-2016.
 */

public class ToDoItemSource {

    private static final String TAG = "ADD TASK ACTIVITY";
    private SQLiteDatabase database;
    private MySqliteHelper dbHelper;
    private String[] allColumns = {MySqliteHelper.COLUMN_ID,
            MySqliteHelper.COLUMN_TITLE, MySqliteHelper.COLUMN_DETAIL};

    public ToDoItemSource(Context context) {
        dbHelper = new MySqliteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ToDoItem createItem(String title, String detail) {
        ContentValues values = new ContentValues();
        values.put(MySqliteHelper.COLUMN_TITLE, title);
        values.put(MySqliteHelper.COLUMN_DETAIL, detail);

        long insertId = database.insert(MySqliteHelper.TABLE_COMMENTS, null,
                values);
        Cursor cursor = database.query(MySqliteHelper.TABLE_COMMENTS,
                allColumns, MySqliteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        ToDoItem newComment = cursorToComment(cursor);
        cursor.close();
        Log.d(TAG, "Task written");
        return newComment;
    }

    public void deleteComment(ToDoItem comment) {

        database.delete(MySqliteHelper.TABLE_COMMENTS, MySqliteHelper.COLUMN_TITLE
                + "='" + comment.getTitle() + "' AND " + MySqliteHelper.COLUMN_DETAIL +
                "='" + comment.getDetail() + "' ;", null);
        Log.d(TAG, "Comment deleted");
    }

    public List<ToDoItem> getAllComments() {
        List<ToDoItem> comments = new ArrayList<ToDoItem>();

        Cursor cursor = database.query(MySqliteHelper.TABLE_COMMENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ToDoItem comment = cursorToComment(cursor);
            comments.add(comment);
            //Log.d(TAG , comment.getTitle() + " "+ comment.getDetail());
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    private ToDoItem cursorToComment(Cursor cursor) {
        ToDoItem comment = new ToDoItem();
        // Log.d(TAG , cursor.getString(1) ) ;
        comment.setTitle(cursor.getString(1));

        comment.setDetail(cursor.getString(2));
        return comment;
    }

}
