package com.example.sherly.lightchecker;

/**
 * Created by SHERLY on 17/06/2017.
 */

public class LightLevelModel {
    private int id;
    private String area;
    private int light_min;
    private int light_max;
    private int type;

    public LightLevelModel(String area) {
        this.area = area;
    }

    public LightLevelModel(int id, String area, int light_min, int light_max, int type) {
        this.id = id;
        this.area = area;
        this.light_min = light_min;
        this.light_max = light_max;
        this.type = type;
    }

    public LightLevelModel(int light_min, int light_max) {
        this.light_min = light_min;
        this.light_max = light_max;
    }

    public int getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public int getLight_min() {
        return light_min;
    }

    public int getLight_max() {
        return light_max;
    }

    public int getType() {
        return type;
    }
}
