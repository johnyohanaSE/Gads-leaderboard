package com.jombeja.gadsleaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearningData {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("hours")
    @Expose
    private String time;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String learningBadge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLearningBadge() {
        return learningBadge;
    }

    public void setLearningBadge(String learningBadge) {
        this.learningBadge = learningBadge;
    }
}
