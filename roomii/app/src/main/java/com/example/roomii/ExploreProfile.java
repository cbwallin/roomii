package com.example.roomii;

public class ExploreProfile {
    private String name;
    private int image;
    private String shortdesc;
    private int matchPercent;

    public ExploreProfile(String name, int image, String shortdesc, int matchPercent) {
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
