package com.pages.restservice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

class Phrase {
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

class Paragraph {
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

class Page {
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

	public static Page fromXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Page.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Page) jaxbUnmarshaller.unmarshal(file);
    }

    public void toXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Page.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(this, file);
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

@XmlRootElement(name = "pages")
class Pages {
    @XmlElementWrapper(name = "pageList")
    @XmlElement(name = "page")
    private List<Page> pageList;

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public static Pages fromXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Pages.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Pages) jaxbUnmarshaller.unmarshal(file);
    }

    public void toXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Pages.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(this, file);
    }
}