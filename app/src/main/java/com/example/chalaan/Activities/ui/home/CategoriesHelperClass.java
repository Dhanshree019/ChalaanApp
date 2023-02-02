package com.example.chalaan.Activities.ui.home;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

class CategoriesHelperClass {

    int image;
    String titile ;
    Drawable gradient;

    public CategoriesHelperClass(int image, String titile, Drawable gradient) {
        this.image = image;
        this.titile = titile;
        this.gradient = gradient;
    }

    public CategoriesHelperClass(GradientDrawable gradient1, int hero, String hero1) {
    }


    public int getImage() {
        return image;
    }

    public String getTitile() {
        return titile;
    }

    public Drawable getGradient() {
        return gradient;
    }
}
