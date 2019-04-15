package com.example.roomii;

public class Profile {
    private String name;
    private int image;
    private String shortdesc;
    private int matchPercent;

    public Profile(String name, int image, String shortdesc, int matchPercent) {
        this.name = name;
        this.image = image;
        this.shortdesc = shortdesc;
        this.matchPercent = matchPercent;
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

    public int getMatchPercent() {
        return matchPercent;
    }
}
