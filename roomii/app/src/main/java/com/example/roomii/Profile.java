package com.example.roomii;

public class Profile {
    private String name;
    private int image;
    private String shortdesc;
    private int matchPercent;
    private int age = 0;
    private String hp = "Apartment";
    private String religiousAff = "";
    private String agePref = "";

    public Profile(String name, int image, String shortdesc, int matchPercent) {
        this.name = name;
        this.image = image;
        this.shortdesc = shortdesc;
        this.matchPercent = matchPercent;
    }

    public Profile(String name, int image, String shortdesc, int matchPercent, int age, String hp, String religiousAff, String agePref) {
        this.name = name;
        this.image = image;
        this.shortdesc = shortdesc;
        this.matchPercent = matchPercent;
        this.age = age;
        this.hp = hp;
        this.agePref = agePref;
        this.religiousAff = religiousAff;
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

    public int getAge() { return age; }

    public String getHousingPref() { return hp; }

    public String getReligiousAff() { return religiousAff; }

    public String getAgePref() { return agePref; }
}
