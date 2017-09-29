package com.ffl.vibe.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/25/2017.
 */

public class ClubEntity implements Serializable {
    public String Club_name;
    public String Club_address;
    public String Club_city;
    public String Club_phone;

    public String getClub_name() {
        return Club_name;
    }

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }

    public String getClub_address() {
        return Club_address;
    }

    public void setClub_address(String club_address) {
        Club_address = club_address;
    }

    public String getClub_city() {
        return Club_city;
    }

    public void setClub_city(String club_city) {
        Club_city = club_city;
    }

    public String getClub_phone() {
        return Club_phone;
    }

    public void setClub_phone(String club_phone) {
        Club_phone = club_phone;
    }

    public static ArrayList<ClubEntity> fromListMap(List<Map> map){

        ArrayList<ClubEntity>Clublist = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            ClubEntity clb = new ClubEntity();

            clb.setClub_name((String)map.get(i).get("club_name"));
            clb.setClub_address((String)map.get(i).get("club_adress"));
            clb.setClub_city((String)map.get(i).get("club_city"));
            clb.setClub_phone((String)map.get(i).get("club_phone"));
            Clublist.add(clb);

        }

        return  Clublist;

    }
}
