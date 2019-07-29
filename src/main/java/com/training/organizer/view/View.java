package com.training.organizer.view;

import com.training.organizer.model.Model;
import com.training.organizer.model.entity.Event;
import com.training.organizer.model.entity.PersonalEvent;
import com.training.organizer.model.entity.WorkEvent;

import java.text.DateFormat;
import java.util.*;

import static com.training.organizer.view.ITextConstant.*;

public class View {


    private static final String BUNDLE_NAME = "message";
    static Locale locale = new Locale("uk", "UA");
//    static Locale locale = new Locale("en", "US");

    public static final ResourceBundle bundle = ResourceBundle.getBundle(
            BUNDLE_NAME,
            locale
    );

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printInputData() {
        printMessage(bundle.getString(INPUT_DATA));
    }

    public void printWrongDataInput() {
        printMessage(bundle.getString(WRONG_DATA)
                + bundle.getString(INPUT_DATA));
    }

    public String stringFormatDate(Calendar date) {
        DateFormat df = DateFormat.getDateInstance(
                DateFormat.MEDIUM, locale);
        return df.format(date.getTime());
    }

    /**
     * @param message
     * @return concatenation of messages
     */
    public String toStringConcatMessage(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String msg : message) {
            stringBuilder.append(msg + NEW_LINE);
        }
        return stringBuilder.toString();
    }

    /**
     *
     * @param map
     * @see Model #getNotifyEvents()
     *
     */
    public void showNearestEvent(Map<Calendar, ArrayList<Event>> map) {
        for (Map.Entry<Calendar, ArrayList<Event>> entry : map.entrySet()) {
            System.out.println(SPLIT + (stringFormatDate(entry.getKey()) + SPLIT));
            showEventsInArray(entry.getValue());
        }
    }

    /**
     * print Events
     * @param events
     *
     */
    public void showEventsInArray(ArrayList<Event> events) {
        for (Event event : events)
            if (event.getClass() == PersonalEvent.class)
                showPersonalEvent((PersonalEvent) event);
            else
                showWorkEvent((WorkEvent) event);
    }

    public void showPersonalEvent(PersonalEvent event) {
        printMessage(toStringConcatMessage(
                (bundle.getString(TITLE) + event.getTitle()),
                (bundle.getString(DATE) + stringFormatDate(event.getDate())),
                (bundle.getString(IMPORTANCE) + bundle.getString(event.getImportance().getTranslate())),
                (bundle.getString(FREQUENCY) + bundle.getString(event.getFrequency().getTranslate())),
                (bundle.getString(LOCATION) + event.getLocation()),
                (bundle.getString(TIME_START) + event.getTimeStart()))

        );
    }

    public void showWorkEvent(WorkEvent event) {
        printMessage(toStringConcatMessage(
                (bundle.getString(TITLE) + event.getTitle()),
                (bundle.getString(DATE) + stringFormatDate(event.getDate())),
                (bundle.getString(IMPORTANCE) + bundle.getString(event.getImportance().getTranslate())),
                (bundle.getString(FREQUENCY) + bundle.getString(event.getFrequency().getTranslate())),
                (bundle.getString(PERSON) + event.getPerson()),
                (bundle.getString(IS_DONE) + event.getIsDone())
        ));
    }


}
