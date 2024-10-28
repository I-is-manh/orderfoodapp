package com.example.oderfoodapp.object;

public class Food {
    private int id;
    private int categoryID;
    private String name;
    private int LINKIMG;
    private String DESCRIPTION;
    private float price;
    private float DISCOUTN_PERCENT;
    private float MARK;

    public Food(int id, int categoryID, String name, int LINKIMG, String DESCRIPTION, float price, float DISCOUTN_PERCENT, float MARK) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.LINKIMG = LINKIMG;
        this.DESCRIPTION = DESCRIPTION;
        this.price = price;
        this.DISCOUTN_PERCENT = DISCOUTN_PERCENT;
        this.MARK = MARK;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLINKIMG() {
        return LINKIMG;
    }

    public void setLINKIMG(int LINKIMG) {
        this.LINKIMG = LINKIMG;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDISCOUTN_PERCENT() {
        return DISCOUTN_PERCENT;
    }

    public void setDISCOUTN_PERCENT(float DISCOUTN_PERCENT) {
        this.DISCOUTN_PERCENT = DISCOUTN_PERCENT;
    }

    public float getMARK() {
        return MARK;
    }

    public void setMARK(float MARK) {
        this.MARK = MARK;
    }
}

