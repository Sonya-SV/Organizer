package com.training.organizer.model.entity;

import java.util.Calendar;

public class WorkEvent extends Event {
    private String person;
    private boolean isDone;

    public WorkEvent() {
    }

    public WorkEvent(String title, Calendar date, Importance importance,
                     Frequency frequency, String person, boolean isDOne) {
        super(title, date, importance, frequency);
        this.person = person;
        this.isDone = isDOne;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public String getPerson() {
        return person;
    }

}

