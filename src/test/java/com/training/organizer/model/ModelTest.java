package com.training.organizer.model;

import static com.training.organizer.model.Model.*;

import com.training.organizer.model.entity.*;

import static com.training.organizer.model.entity.DBObjects.*;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.assertArrayEquals;

import java.util.*;


import static org.junit.Assert.*;

public class ModelTest {
    private static Model model;
    private static Event personalEvent;
    private static Calendar checkDate, startDate, endDate;

    @BeforeClass
    public static void runTest() {
        model = new Model();
        personalEvent = new PersonalEvent();
        checkDate = Calendar.getInstance();
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();
    }

    @Test
    public void isFitToDateTest() {
        personalEvent.getDate().set(1900, Calendar.MAY, 5);
        personalEvent.setFrequency(Frequency.MONTLY);

        checkDate.set(2019, Calendar.JULY, 5);
        assertTrue(model.isFitToDate(checkDate, personalEvent));

        checkDate.set(2019, Calendar.JULY, 6);
        assertFalse(model.isFitToDate(checkDate, personalEvent));


    }

    @Test
    public void isFitToDateRangeTest() {
        personalEvent.getDate().set(1900, Calendar.MAY, 5);
        personalEvent.setFrequency(Frequency.MONTLY);

        startDate.set(2019, Calendar.JULY, 5);
        endDate.set(2019, Calendar.JULY, 8);
        assertTrue(model.isFitToDateRange(startDate, endDate, personalEvent));

        personalEvent.getDate().set(1900, Calendar.JULY, 8);
        personalEvent.setFrequency(Frequency.YEARLY);
        assertTrue(model.isFitToDateRange(startDate, endDate, personalEvent));

        personalEvent.getDate().set(1900, Calendar.MAY, 9);
        assertFalse(model.isFitToDateRange(startDate, endDate, personalEvent));


    }

    @Test
    public void selectEventsByDate() {
        checkDate.set(2019, Calendar.JULY, 1);

        ArrayList<Event> hamcrestMatchers = new ArrayList<>();
        hamcrestMatchers.add(HOMETASK.getDBEvent());
        hamcrestMatchers.add(READ.getDBEvent());
        hamcrestMatchers.add(CLEANING.getDBEvent());

        List<Event> checkArray = model.selectEventsByDate(checkDate, COMPARE_BY_DATE);
        Collections.sort(hamcrestMatchers, COMPARE_BY_DATE);

        assertArrayEquals(checkArray.toArray(), (hamcrestMatchers).toArray());

    }

    @Test
    public void selectEventsByDateRangeTest() {

        startDate.set(2019, Calendar.JULY, 29);
        endDate.set(2019, Calendar.AUGUST, 2);

        ArrayList<Event> hamcrestMatchers = new ArrayList<>();

        hamcrestMatchers.add(HOMETASK.getDBEvent());
        hamcrestMatchers.add(READ.getDBEvent());
        hamcrestMatchers.add(LECTURE.getDBEvent());
        hamcrestMatchers.add(BIRTHDAY.getDBEvent());
        hamcrestMatchers.add(CLEANING.getDBEvent());

        List<Event> checkArray = model.selectEventsByDateRange(startDate, endDate, COMPARE_BY_DATE);
        Collections.sort(hamcrestMatchers, COMPARE_BY_DATE);

        assertArrayEquals(checkArray.toArray(), (hamcrestMatchers).toArray());

    }

}