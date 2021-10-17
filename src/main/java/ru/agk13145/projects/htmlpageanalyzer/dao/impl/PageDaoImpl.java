package ru.agk13145.projects.htmlpageanalyzer.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.projects.htmlpageanalyzer.controller.StatisticController;
import ru.agk13145.projects.htmlpageanalyzer.dao.PageDao;
import ru.agk13145.projects.htmlpageanalyzer.model.Page;
import ru.agk13145.projects.htmlpageanalyzer.model.mapper.PageMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PageDaoImpl implements PageDao {

    private static Logger logger = LoggerFactory.getLogger(PageDaoImpl.class);

    private final static String SQL_SELECT_PAGE = "SELECT ID, URL FROM pageanalyzer.pages " +
            "WHERE id = :id";

    private final static String SQL_SELECT_PAGE_BY_URL = "SELECT ID, URL FROM pageanalyzer.pages " +
            "WHERE url = :url";

    private final static String SQL_CREATE_PAGE = "INSERT INTO " +
            "pageanalyzer.pages(url, statistic) VALUES (:url, to_json(:statistic))";

    private final static String SQL_UPDATE_PAGE = "UPDATE pageanalyzer.pages " +
            "SET url = :url WHERE id = :id";

    private final static String SQL_DELETE_PAGE = "DELETE FROM pageanalyzer.pages WHERE id = :id";

    private final static String SQL_SELECT_ALL_PAGES = "SELECT ID, NAME FROM pageanalyzer.pages ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Page getPage(Integer pageId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", pageId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_PAGE, paramMap, new PageMapper());
    }

    @Override
    public Page getPageByUrl(String url) {
        Page page = null;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("url", url);
        try {
            page = namedParameterJdbcTemplate.queryForObject(SQL_SELECT_PAGE_BY_URL, paramMap, new PageMapper());
        } catch (EmptyResultDataAccessException e) {
            logger.warn("HTML page cannot be found in database - {}", url);
        }

        return page;
    }

    @Override
    @Transactional
    public Integer createPage(Page page) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("url", page.getUrl());
        namedParameters.addValue("statistic", page.getStatisticJSON());
        namedParameterJdbcTemplate.update(SQL_CREATE_PAGE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updatePage(Page page) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", page.getId());
        params.put("url", page.getUrl());
        namedParameterJdbcTemplate.update(SQL_UPDATE_PAGE, params);
    }

    @Override
    @Transactional
    public void deletePage(Integer pageId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        namedParameterJdbcTemplate.update(SQL_DELETE_PAGE, params);
    }

    @Override
    public List<Page> getPages() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_PAGES, new PageMapper());
    }
}
