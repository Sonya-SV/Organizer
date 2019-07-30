package com.training.organizer.model;

import com.training.organizer.model.entity.DBObjects;
import com.training.organizer.model.entity.Event;

import java.util.*;

public class Model {


    /**
     * @param comparator - sorting by date or by importance
     * @return sorted by comparator arrayList of events matching the date
     * @see Model#COMPARE_BY_DATE
     * @see Model#COMPARE_BY_IMPORTANCE
     */
    public List<Event> selectEventsByDate(Calendar date, Comparator<Event> comparator) {
        List<Event> output = new ArrayList<>();
        for (Event event : DBObjects.getDBObjectsToArray()) {
            if (isFitToDate(date, event)) {
                output.add(event);
            }
        }
        Collections.sort(output, comparator);
        return output;
    }

    /**
     * @param comparator - sorting by date or by importance
     * @return sorted by comparator arrayList of events matching the date range
     * @see Model#COMPARE_BY_DATE
     * @see Model#COMPARE_BY_IMPORTANCE
     */
    public List<Event> selectEventsByDateRange(Calendar dateStart, Calendar dateEnd, Comparator<Event> comparator) {
        ArrayList<Event> output = new ArrayList<>();
        for (Event event : DBObjects.getDBObjectsToArray()) {
            if (isFitToDateRange(dateStart, dateEnd, event)) {
                output.add(event);
            }
        }
        Collections.sort(output, comparator);
        return output;
    }

    /**
     * @param forecastInDays - period of time for planned events
     * @return map : key - date, value - arrayList of events
     */
    public Map<Calendar, List<Event>> getNotifyEvents(Calendar startDate, int forecastInDays) {
        Calendar endDate = (Calendar) startDate.clone();
        endDate.add(Calendar.DATE, forecastInDays);

        Map<Calendar, List<Event>> mapEvent = new TreeMap<>();
        Calendar currentDate = (Calendar) startDate.clone();

        while (currentDate.before(endDate)) {
            Calendar date = (Calendar) currentDate.clone();
            mapEvent.put(date, selectEventsByDate(currentDate, COMPARE_BY_DATE));
            currentDate.add(Calendar.DATE, 1);
        }
        return mapEvent;
    }

    public static Comparator<Event> COMPARE_BY_DATE = new Comparator<Event>() {
        public int compare(Event one, Event other) {
            return one.getDate().compareTo(other.getDate());
        }
    };

    public static Comparator<Event> COMPARE_BY_IMPORTANCE = new Comparator<Event>() {
        public int compare(Event one, Event other) {
            return other.getImportance().compareTo(one.getImportance());
        }
    };

    boolean isFitToDate(Calendar currentDate, Event event) {
        switch (event.getFrequency()) {
            case DAILY: {
                return true;
            }
            case WEEKLY: {
                return event.getDate().get(Calendar.DAY_OF_WEEK) == currentDate.get(Calendar.DAY_OF_WEEK);
            }
            case MONTLY: {
                return event.getDate().get(Calendar.DATE) == currentDate.get(Calendar.DATE);
            }
            case YEARLY: {
                return event.getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                        && event.getDate().get(Calendar.DATE) == currentDate.get(Calendar.DATE);
            }
            case DONT_REPEAT: {
                return event.getDate().get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)
                        && event.getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                        && event.getDate().get(Calendar.DATE) == currentDate.get(Calendar.DATE);
            }
        }
        return false;
    }

    boolean isFitToDateRange(Calendar startDate, Calendar endDate, Event event) {
        Calendar temp = (Calendar) event.getDate().clone();
        switch (event.getFrequency()) {
            case DAILY: {
                return true;
            }
            case WEEKLY: {
                startDate.add(Calendar.DATE, -1);
                endDate.add(Calendar.DATE, 1);
                temp.set(Calendar.MONTH, startDate.get(Calendar.MONTH) - 1);
                while (temp.before(endDate)) {
                    temp.add(Calendar.DATE, 7);
                    if (temp.after(startDate) && temp.before(endDate))
                        return true;
                }
            }
            case MONTLY: {
                startDate.add(Calendar.DATE, -1);
                endDate.add(Calendar.DATE, 1);
                temp.set(Calendar.YEAR, startDate.get(Calendar.YEAR));
                for (int i = startDate.get(Calendar.MONTH); i <= endDate.get(Calendar.MONTH); i++) {
                    temp.set(Calendar.MONTH, i);
                    if (temp.before(endDate) && temp.after(startDate))
                        return true;
                }
            }
            case YEARLY: {
                return event.getDate().get(Calendar.DAY_OF_YEAR) >= startDate.get(Calendar.DAY_OF_YEAR)
                        && event.getDate().get(Calendar.DAY_OF_YEAR) <= endDate.get(Calendar.DAY_OF_YEAR);
            }
            case DONT_REPEAT: {
                return event.getDate().get(Calendar.YEAR) >= startDate.get(Calendar.YEAR)
                        && event.getDate().get(Calendar.YEAR) <= endDate.get(Calendar.YEAR)
                        && event.getDate().get(Calendar.DAY_OF_YEAR) >= startDate.get(Calendar.DAY_OF_YEAR)
                        && event.getDate().get(Calendar.DAY_OF_YEAR) <= endDate.get(Calendar.DAY_OF_YEAR);
            }
        }
        return false;
    }


}
