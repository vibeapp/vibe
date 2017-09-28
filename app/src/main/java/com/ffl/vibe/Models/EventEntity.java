package com.ffl.vibe.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/25/2017.
 */

public class EventEntity implements Serializable{
    public String Event_poster;
    public String Event_name;
    public String Event_date;
    public String Event_guest;
    public String Event_club;
    public String Event_price;
    public String Event_sponsor;

    public String getEvent_poster() {
        return Event_poster;
    }

    public void setEvent_poster(String event_poster) {
        Event_poster = event_poster;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String event_name) {
        Event_name = event_name;
    }

    public String getEvent_date() {
        return Event_date;
    }

    public void setEvent_date(String event_date) {
        Event_date = event_date;
    }

    public String getEvent_guest() {
        return Event_guest;
    }

    public void setEvent_guest(String event_guest) {
        Event_guest = event_guest;
    }

    public String getEvent_club() {
        return Event_club;
    }

    public void setEvent_club(String event_club) {
        Event_club = event_club;
    }

    public String getEvent_price() {
        return Event_price;
    }

    public void setEvent_price(String event_price) {
        Event_price = event_price;
    }

    public String getEvent_sponsor() {
        return Event_sponsor;
    }

    public void setEvent_sponsor(String event_sponsor) {
        Event_sponsor = event_sponsor;
    }
    public static ArrayList<EventEntity> fromListMap(List<Map> map){

        ArrayList<EventEntity> Eventlist = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            EventEntity evt = new EventEntity();

            evt.setEvent_name((String)map.get(i).get("event_name"));
            evt.setEvent_poster((String) map.get(i).get("event_poster"));
            evt.setEvent_date((String)map.get(i).get("event_date"));
            evt.setEvent_price((String) map.get(i).get("event_price"));
            evt.setEvent_guest((String)map.get(i).get("event_guest"));
            evt.setEvent_club((String) map.get(i).get("event_club"));
            evt.setEvent_sponsor((String)map.get(i).get("event_sponsor"));
            Eventlist .add(evt);

        }

        return  Eventlist ;

    }
}
