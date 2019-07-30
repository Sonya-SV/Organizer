package com.training.organizer.model;

public enum Frequency {
    DONT_REPEAT("dont.repeat"),
    DAILY("every.day"),
    WEEKLY("every.week"),
    MONTLY("every.month"),
    YEARLY("every.year");

    private String translate;

    Frequency(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
