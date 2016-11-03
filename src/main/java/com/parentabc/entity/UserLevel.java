/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.entity;

import com.parentabc.util.Constants;

/**
 *
 * @author youguilin
 */
public class UserLevel implements Comparable<UserLevel> {

    private final int points;
    private int suns = 0;
    private int moons = 0;
    private int stars = 0;

    public UserLevel(int points) {
        if (points < 0) {
            this.points = 0;
        } else {
            this.points = points;
            this.suns = this.points / Constants.DEFAULT_SUN_POINT;
            int moonPoints = this.points % Constants.DEFAULT_SUN_POINT;
            this.moons = moonPoints / Constants.DEFAULT_MOON_POINT;
            int starsPoints = moonPoints % Constants.DEFAULT_MOON_POINT;
            this.stars = starsPoints / Constants.DEFAULT_STAR_POINT;
        }
    }

    public int getPoints() {
        return points;
    }

    public int getSuns() {
        return suns;
    }

    public int getMoons() {
        return moons;
    }

    public int getStars() {
        return stars;
    }

    public void setSuns(int suns) {
        this.suns = suns;
    }

    public void setMoons(int moons) {
        this.moons = moons;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "UserLevel{" + "points=" + points + ", stars=" + stars + ", moons=" + moons + ", suns=" + suns + '}';
    }

    @Override
    public int compareTo(UserLevel o) {
        return Integer.valueOf(points).compareTo(o.getPoints());
    }

}
