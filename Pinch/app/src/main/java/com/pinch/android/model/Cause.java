package com.pinch.android.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by matthewferguson on 6/15/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class Cause {
    final public String charityImage;
    final public String charityName;
    final public String detail;
    final public Double endDate;
    final public Integer goalAmount;
    final public String leadingImage;
//    final public String missions;
    final public Integer progressAmount;
    final public String title;

    public Cause() {
        this.charityImage = null;
        this.charityName = null;
        this.detail = null;
        this.endDate = 0.0;
        this.goalAmount = 0;
        this.leadingImage = null;
//        this.missions = null;
        this.progressAmount = 0;
        this.title = null;
    }

    @Override
    public String toString() {
        return "Cause{" +
                "charityImage='" + charityImage + '\'' +
                ", charityName='" + charityName + '\'' +
                ", detail='" + detail + '\'' +
                ", endDate=" + endDate +
                ", goalAmount=" + goalAmount +
                ", leadingImage='" + leadingImage + '\'' +
                ", progressAmount=" + progressAmount +
                ", title='" + title + '\'' +
                '}';
    }
}
