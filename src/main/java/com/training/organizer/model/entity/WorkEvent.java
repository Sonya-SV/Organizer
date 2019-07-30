package com.training.organizer.model.entity;

import com.training.organizer.model.Frequency;
import com.training.organizer.model.Importance;

import java.util.Calendar;

import static com.training.organizer.view.ITextConstant.*;

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

