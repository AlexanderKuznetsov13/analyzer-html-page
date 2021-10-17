package ru.agk13145.projects.htmlpageanalyzer.service.impl;

import org.springframework.stereotype.Service;
import ru.agk13145.projects.htmlpageanalyzer.model.Page;
import ru.agk13145.projects.htmlpageanalyzer.model.Statistic;
import ru.agk13145.projects.htmlpageanalyzer.service.StatisticService;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Override
    public Statistic analyzePage(Page page) {
        return null;
    }

    @Override
    public Statistic getStatisticsByPageId(Integer pageId) {
        return null;
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return null;
    }
}
