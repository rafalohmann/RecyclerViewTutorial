package com.example.tutorial.recyclerviewproject;

public class ExampleItem {
    private int mImageResource;
    private String mTitle;
    private int mQtd;

    public ExampleItem(int imageResource, String title, int qtd) {
        this.mImageResource = imageResource;
        this.mTitle = title;
        this.mQtd = qtd;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void add() {
        this.mQtd++;
    }

    public String getQtdText() {
        return "Qtd: " + mQtd;
    }
}