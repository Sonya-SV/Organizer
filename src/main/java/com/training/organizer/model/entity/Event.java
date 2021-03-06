package com.training.organizer.model.entity;

import com.training.organizer.model.Frequency;
import com.training.organizer.model.Importance;

import java.time.LocalDate;
import java.util.Calendar;

public abstract class Event {

    private String title;
    private LocalDate date;
    private Importance importance;
    private Frequency frequency;

    Event() {
        this.title = "";
        this.date = LocalDate.now();
        this.importance = Importance.MEDIUM;
        this.frequency = Frequency.DONT_REPEAT;
    }

    Event(String title, LocalDate date, Importance importance, Frequency frequency) {
        this.title = title;
        this.date = date;
        this.importance = importance;
        this.frequency = frequency;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
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
