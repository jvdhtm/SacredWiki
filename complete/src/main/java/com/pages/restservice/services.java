package com.pages.restservice;

import java.util.ArrayList;
import java.util.List;

class PhraseService {
	public void addVariation(Page page, int paragraphIndex, String phraseText, String variation, boolean primary) {
		Paragraph paragraph = page.getParagraph(paragraphIndex);
		Phrase phrase = paragraph.getPhrase(phraseText);
		if (phrase == null) {
			phrase = new Phrase(phraseText, primary);
			paragraph.addPhrase(phrase);
		} else if (primary) {
			phrase.setPrimary(true);
		}
		phrase.addVariation(variation);
	}
}

class PageService {
    private List<Page> pages;

    public PageService() {
        this.pages = new ArrayList<>();
    }

    public void addPage(int pageNumber, Page page) {
        pages.add(pageNumber, page);
    }

    public Page getPage(int pageNumber) {
        return pages.get(pageNumber);
    }

    public List<Page> getAllPages() {
        return pages;
    }
}

class ParagraphService {
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