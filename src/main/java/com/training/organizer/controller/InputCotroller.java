package com.training.organizer.controller;

import static com.training.organizer.view.ITextConstant.*;

import com.training.organizer.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


class InputCotroller {

    private View view;
    private Scanner sc;

    InputCotroller(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    /**
     * check the input value
     *
     * @return date
     */
    Calendar inputDateFromConsole() {
        Calendar userDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, View.bundle.getLocale());
        String input;
        view.printInputData();
        while (!(sc.hasNext() && (input = sc.next()).matches(REGEX_DATE))) {
            view.printWrongDataInput();
        }
        try {
            userDate.setTime(sdf.parse(input));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userDate;
    }
}
