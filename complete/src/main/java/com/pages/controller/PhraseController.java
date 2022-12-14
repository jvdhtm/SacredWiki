package com.pages.controller;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pages.service.*;
import com.pages.model.*;

@RestController
@RequestMapping("/pages/{pageNumber}/phrases")
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController() {
        this.phraseService = new PhraseService();
    }

    @PostMapping
    public ResponseEntity<Void> addVariation(@PathVariable int pageNumber, @RequestBody AddVariationRequest request) {
        Page page = getPage(pageNumber);
        phraseService.addVariation(page, request.getParagraphIndex(), request.getPhraseText(), request.getVariation(), request.isPrimary());
        return savePage(pageNumber, page);
    }

    @GetMapping
    public List<String> getVariations(@PathVariable int pageNumber, @RequestParam int paragraphIndex, @RequestParam String phraseText) {
        Page page = getPage(pageNumber);
        Paragraph paragraph = page.getParagraph(paragraphIndex);
        Phrase phrase = paragraph.getPhrase(phraseText);
        return phrase.getVariations();
    }

    private Page getPage(int pageNumber) {
        try {
            File file = new File("pages.xml");
            if (file.exists()) {
                Pages pages = Pages.fromXml(file);
                return pages.getPageListField().get(pageNumber);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Page();
    }

    private ResponseEntity<Void> savePage(int pageNumber, Page page) {
        try {
            File file = new File("pages.xml");
            Pages pages = Pages.fromXml(file);
            pages.getPageListField().set(pageNumber, page);
            pages.toXml(file);
            return ResponseEntity.ok().build();
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}

class AddVariationRequest {
    private int paragraphIndex;
    private String phraseText;
    private String variation;
    private boolean primary;

    public int getParagraphIndex() {
        return paragraphIndex;
    }

    public void setParagraphIndex(int paragraphIndex) {
        this.paragraphIndex = paragraphIndex;
    }

    public String getPhraseText() {
        return phraseText;
    }

    public void setPhraseText(String phraseText) {
        this.phraseText = phraseText;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}