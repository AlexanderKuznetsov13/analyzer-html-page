package ru.agk13145.projects.htmlpageanalyzer.service;

import ru.agk13145.projects.htmlpageanalyzer.model.Statistic;

import java.util.List;

public interface StatisticService {
    Statistic analyzePage(String url);

    Statistic getStatisticsByPageId(Integer pageId);

    List<Statistic> getAllStatistics();

}
