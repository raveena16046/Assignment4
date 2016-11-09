package com.example.gupta.recyclerlist;

/**
 * Created by GUPTA on 02-11-2016.
 */

public class ToDoItem {

    private String title;
    private String detail;


    public ToDoItem() {

    }

    public ToDoItem(String title, String detail) {

        this.title = title;
        this.detail = detail;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
