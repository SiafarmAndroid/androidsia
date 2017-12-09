package com.siafarm.homefragment.model;

public class modern_agri_data {
    String name;
    int drawable;
    Float rating;

    public modern_agri_data(String name, int drawable, float rating) {
        this.name = name;
        this.drawable = drawable;
        this.rating = rating;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }


}
