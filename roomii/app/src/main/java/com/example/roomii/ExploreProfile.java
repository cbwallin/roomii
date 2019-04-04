package com.example.roomii;

public class ExploreProfile {
    private String name;
    private String profilePicPath;

    public ExploreProfile(String name, String profilePicPath) {
        this.name = name;
        this.profilePicPath = profilePicPath;
    }

    public String getName() {
        return name;
    }

    public String getProfPic() {
        return profilePicPath;
    }
}
