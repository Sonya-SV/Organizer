package com.training.organizer.model.entity;

import java.util.Calendar;

public abstract class Event {

    private String title;
    private Calendar date;
    private Importance importance;
    private Frequency frequency;

    Event() {
        this.title = "";
        this.date = Calendar.getInstance();
        this.importance = Importance.MEDIUM;
        this.frequency = Frequency.DONT_REPEAT;
    }

    Event(String title, Calendar date, Importance importance, Frequency frequency) {
        this.title = title;
        this.date = date;
        this.importance = importance;
        this.frequency = frequency;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getDate() {
        return date;
    }

    public Importance getImportance() {
        return importance;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


}
