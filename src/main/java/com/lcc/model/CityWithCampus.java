package com.lcc.model;

import java.util.ArrayList;

/**
 * Created by lcc on 2016/12/24.
 */
public class CityWithCampus extends City{
    private ArrayList<Campus> campuses;

    public ArrayList<Campus> getCampuses() {
        return campuses;
    }

    public void setCampuses(ArrayList<Campus> campuses) {
        this.campuses = campuses;
    }

}
