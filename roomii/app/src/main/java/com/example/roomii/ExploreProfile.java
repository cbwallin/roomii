package com.example.roomii;

public class ExploreProfile {
    private String name;
    private int image;
    private String shortdesc;

    public ExploreProfile(String name, int image, String shortdesc) {
        this.name = name;
        this.image = image;
        this.shortdesc = shortdesc;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getShortdesc() {
        return shortdesc;
    }
}
