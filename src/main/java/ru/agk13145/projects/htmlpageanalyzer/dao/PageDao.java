package ru.agk13145.projects.htmlpageanalyzer.dao;

import ru.agk13145.projects.htmlpageanalyzer.model.Page;

import java.util.List;

public interface PageDao {
    Page getPage(Integer pageId);

    Page getPageByUrl(String url);

    Integer createPage(Page page);

    void updatePage(Page page);

    void deletePage(Integer pageId);

    List<Page> getPages();
}
