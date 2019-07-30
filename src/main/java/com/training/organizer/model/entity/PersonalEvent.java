package com.training.organizer.model.entity;

import com.training.organizer.model.Frequency;
import com.training.organizer.model.Importance;

import java.sql.Time;
import java.util.Calendar;

import static com.training.organizer.view.ITextConstant.*;
import static com.training.organizer.view.ITextConstant.TIME_START;

public class PersonalEvent extends Event {
    private String location;
    private Time timeStart;

    public PersonalEvent() {
    }

    public PersonalEvent(String title, Calendar date, Importance importance, Frequency frequency, String location, Time timeStart) {
        super(title, date, importance, frequency);
        this.location = location;
        this.timeStart = timeStart;
    }

    public String getLocation() {
        return location;
    }

    public Time getTimeStart() {
        return timeStart;
    }




}
