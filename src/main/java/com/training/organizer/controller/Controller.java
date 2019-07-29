package com.training.organizer.controller;

import com.training.organizer.model.*;

import static com.training.organizer.model.Model.*;

import com.training.organizer.view.View;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Controller {

    private static final int forecastInDays = 3;

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
/*
        Scanner sc = new Scanner(System.in);
        InputCotroller utilityCotroller =
                new InputCotroller(view, sc);
        final Calendar checkedDate = utilityCotroller.inputDateFromConsole();
        final Calendar startDate = utilityCotroller.inputDateFromConsole();
        final Calendar endDate = utilityCotroller.inputDateFromConsole();
*/

        final Calendar checkedDate = new GregorianCalendar(2019, Calendar.JULY, 29);
        final Calendar startDate = new GregorianCalendar(2019, Calendar.JULY, 29);
        final Calendar endDate = new GregorianCalendar(2019, Calendar.AUGUST, 2);

        view.showEventsInArray(model.selectEventsByDate(checkedDate, COMPARE_BY_IMPORTANCE));

        view.showEventsInArray(model.selectEventsByDateRange(startDate, endDate, COMPARE_BY_DATE));

        view.showEventsInArray(model.selectEventsByDateRange(startDate, endDate, COMPARE_BY_IMPORTANCE));

        view.showNearestEvent(model.getNotifyEvents(startDate, forecastInDays));

    }
}

