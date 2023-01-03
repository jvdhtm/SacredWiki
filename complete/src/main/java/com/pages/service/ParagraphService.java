package com.pages.service;

import java.util.ArrayList;
import java.util.List;
import com.pages.model.*;

public class ParagraphService {
    private List<Page> pages;

    public ParagraphService() {
        this.pages = new ArrayList<>();
    }

    public void addParagraph(int pageNumber, int paragraphNumber, Paragraph paragraph) {
        Page page = pages.get(pageNumber);
        page.addParagraph(paragraph);
    }

    public Paragraph getParagraph(int pageNumber, int paragraphNumber) {
        Page page = pages.get(pageNumber);
        List<Paragraph> paragraphs = page.getParagraphs();
        return paragraphs.get(paragraphNumber);
    }

    public List<Page> getAllPages() {
        return pages;
    }
}