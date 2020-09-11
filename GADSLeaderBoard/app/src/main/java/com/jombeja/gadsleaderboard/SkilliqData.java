package com.jombeja.gadsleaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkilliqData {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("score")
    @Expose
    private String iq;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String scoreBadge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIq() {
        return iq;
    }

    public void setIq(String iq) {
        this.iq = iq;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getScoreBadge() {
        return scoreBadge;
    }

    public void setScoreBadge(String scoreBadge) {
        this.scoreBadge = scoreBadge;
    }
}
