package com.example.oderfoodapp.object;

public class Category {
    private int id;
    private String name;
    private int linkimg;

    public Category(int id,String name) {
        this.id = id;
        this.name = name;
    }
    public Category(Category cate, int linkimg) {
        this.id = cate.getId();
        this.name = cate.getName();
        this.linkimg = linkimg;
    }
    public Category(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(int linkimg) {
        this.linkimg = linkimg;
    }
}
