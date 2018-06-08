package com.quizzood2.etiennemaxime.quizzood2.Model;

public class Category {

    private String Name;
    private String Image;

    public Category(String name, String image){
        this.Image = image;
        this.Name = name;
    }

    public String getImage() {
        return Image;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }
    public void setImage(String image){
        this.Name = image;
    }
}
