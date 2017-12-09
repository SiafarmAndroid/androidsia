package com.siafarm.mainactivity.model;


public class App {

    private int mDrawable;
    private String mName;


    public App(String name, int drawable, float rating) {
        mName = name;
        mDrawable = drawable;
    }



    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }
}

