
package com.pages.controller;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pages.service.*;
import com.pages.model.*;

@RestController
@RequestMapping("/pages")
class PageController {
    // Inject a PageService instance
    private PageService pageService;

    @PostMapping("/{pageNumber}")
    public ResponseEntity<Void> addPage(@PathVariable int pageNumber, @RequestBody Page page) throws JAXBException {
        pageService.addPage(pageNumber, page);
        Pages pageWrapper = new Pages();
        pageWrapper.setPageList(pageService.getAllPages());
        pageWrapper.toXml(new File("pages.xml"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{pageNumber}")
    public ResponseEntity<Page> getPage(@PathVariable int pageNumber) throws JAXBException {
        File file = new File("pages.xml");
        if (!file.exists()) {
            Pages defaultPages = new Pages();
            Page defaultPage = new Page("Once there was a robot...");
            List<Page> defaultListPages = new LinkedList<Page> ();
            defaultListPages.add(defaultPage);
            defaultPages.setPageList(defaultListPages);;
            defaultPage.toXml(new File("pages.xml"));
            return ResponseEntity.ok(defaultPage);
        }
        Pages pageWrapper = Pages.fromXml(file);
        List<Page> pages = pageWrapper.getPageList();
        Page page = pages.get(pageNumber);
        return ResponseEntity.ok(page);
    }
}
