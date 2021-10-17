package ru.agk13145.projects.htmlpageanalyzer.service.impl;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.agk13145.projects.htmlpageanalyzer.dao.PageDao;
import ru.agk13145.projects.htmlpageanalyzer.model.Page;
import ru.agk13145.projects.htmlpageanalyzer.model.Statistic;
import ru.agk13145.projects.htmlpageanalyzer.service.StatisticService;
import ru.agk13145.projects.htmlpageanalyzer.util.Util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {

    private static Logger logger = LoggerFactory.getLogger(StatisticServiceImpl.class);

    private final PageDao pageDao;

    public StatisticServiceImpl(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    @Override
    public Statistic analyzePage(String url) {
        Statistic statistic = new Statistic();

        Page page = pageDao.getPageByUrl(url);
        if (page == null) {
            String text = parseHTML(url);
            if (text != null) {
                Map<String, Integer> mapOfUniqueWords = getUniqueWords(text);
                statistic.setStatOfUniqueWords(mapOfUniqueWords);
                Gson gson = new Gson();
                String jsonString = gson.toJson(statistic);
                page = new Page(url, jsonString);
                Integer pageId = pageDao.createPage(page);
                logger.debug("Page is saved into DB");
            }
        }

        //todo need add constraints
        return statistic;
    }

    @Override
    public Statistic getStatisticsByPageId(Integer pageId) {
        return null;
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return null;
    }

    private String parseHTML(String url) {
        String text = null;
        try {
            Document document = Jsoup.connect(url).get();
            text = document.body().text();
        } catch (IOException e) {
            logger.error("Exception: " + e);
            System.err.println("Page cannot be retrieved");
        }

        return text;
    }

    public Map<String, Integer> getUniqueWords(String text) {
        String[] words = Util.splitWords(text);
        Map<String, Integer> counts = Util.countWords(words);
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            logger.trace("{} counts is - {}", entry.getKey(), entry.getValue());
        }
        return counts;
    }


}
