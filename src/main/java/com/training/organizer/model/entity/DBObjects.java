package com.training.organizer.model.entity;

import com.training.organizer.model.Frequency;
import com.training.organizer.model.Importance;

import java.sql.Time;
import java.util.*;

public enum DBObjects {

    BIRTHDAY(new PersonalEvent(
            "Birthday",
            new GregorianCalendar(1978, Calendar.JULY, 30),
            Importance.MEDIUM,
            Frequency.YEARLY,
            "Home",
            new Time(17))),
    ANNIVERSARY(new PersonalEvent(
            "Anniversary",
            new GregorianCalendar(2005, Calendar.AUGUST, 3),
            Importance.HIGH,
            Frequency.YEARLY,
            "Restaurant",
            new Time(19))),
    CLEANING(new PersonalEvent(
            "Cleaning",
            new GregorianCalendar(2018, Calendar.JANUARY, 1),
            Importance.LOW,
            Frequency.MONTLY,
            "Home", new Time(19))),


    HOMETASK(new WorkEvent(
            "Do hometask",
            new GregorianCalendar(2019, Calendar.JULY, 22),
            Importance.HIGH,
            Frequency.DAILY,
            "Me",
            true
    )),
    LECTURE(new WorkEvent(
            "Lecture",
            new GregorianCalendar(2019, Calendar.JULY, 30),
            Importance.MEDIUM,
            Frequency.WEEKLY,
            "Me",
            false
    )),
    READ(new WorkEvent(
            "Read Effective Java",
            new GregorianCalendar(2019, Calendar.JULY, 1),
            Importance.MEDIUM,
            Frequency.DAILY,
            "Me",
            false
    ));

    private final Event event;

    DBObjects(Event event) {
        this.event = event;
    }

    public Event getDBEvent() {
        return event;
    }

    public static List<Event> getDBObjectsToArray() {
        List<Event> output = new ArrayList<>();
        for (DBObjects obj : DBObjects.values())
            output.add(obj.event);
        return output;
    }

}



