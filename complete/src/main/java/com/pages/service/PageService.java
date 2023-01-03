package com.pages.service;

import java.util.ArrayList;
import java.util.List;
import com.pages.model.*;

public class PageService {
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