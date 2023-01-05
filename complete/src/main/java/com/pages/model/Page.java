package com.pages.model;
import java.util.ArrayList;
import java.util.List;

public class Page {
    private String text;
    private List<Paragraph> paragraphs;

    public Page(String text) {
        this.text = text;
        this.paragraphs = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void addParagraph(Paragraph paragraph) {
        this.paragraphs.add(paragraph);
    }

    public Paragraph getParagraph(int index) {
        return paragraphs.get(index);
    }
}
