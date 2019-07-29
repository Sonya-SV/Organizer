package com.training.organizer.model.entity;

public enum Importance {
    LOW("low"), MEDIUM("medium"), HIGH("high");
    private String translate;

    Importance(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
