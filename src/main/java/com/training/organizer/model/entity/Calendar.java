package com.training.organizer.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    List<Event> eventList = new ArrayList<Event>();

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }



}
