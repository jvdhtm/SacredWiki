package com.pages.model;

import java.util.ArrayList;
import java.util.List;

public class Phrase {
    private String text;
    private boolean primary;
    private List<String> variations;

    public Phrase(String text, boolean primary) {
        this.text = text;
        this.primary = primary;
        this.variations = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public void addVariation(String variation) {
        this.variations.add(variation);
    }
}

