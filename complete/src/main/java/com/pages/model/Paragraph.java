package com.pages.model;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private String text;
    private List<Phrase> phrases;

    public Paragraph(String text) {
        this.text = text;
        this.phrases = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public void addPhrase(Phrase phrase) {
        this.phrases.add(phrase);
    }

    public Phrase getPhrase(String text) {
        for (Phrase phrase : phrases) {
            if (phrase.getText().equals(text)) {
                return phrase;
            }
        }
        return null;
    }
}
