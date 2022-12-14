
package com.pages.controller;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pages.service.*;
import com.pages.model.*;


@RestController
@RequestMapping("/paragraphs")
class ParagraphController {
    // Inject a ParagraphService instance
    private ParagraphService paragraphService;

    @PostMapping("/{pageNumber}")
    public ResponseEntity<Void> addParagraph(@PathVariable int pageNumber, @RequestBody Paragraph paragraph) throws JAXBException {
        paragraphService.addParagraph(pageNumber, paragraph);
        Pages pageWrapper = new Pages();
        pageWrapper.setPageList(paragraphService.getAllPages());
        pageWrapper.toXml(new File("pages.xml"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{pageNumber}/{paragraphNumber}")
    public ResponseEntity<Paragraph> getParagraph(@PathVariable int pageNumber, @PathVariable int paragraphNumber) throws JAXBException {
        Pages pageWrapper = Pages.fromXml(new File("pages.xml"));
        List<Page> pages = pageWrapper.getPageListField();
        Page page = pages.get(pageNumber);
        List<Paragraph> paragraphs = page.getParagraphs();
        Paragraph paragraph = paragraphs.get(paragraphNumber);
        return ResponseEntity.ok(paragraph);
    }
}