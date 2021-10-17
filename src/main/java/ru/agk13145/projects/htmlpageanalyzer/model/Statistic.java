package ru.agk13145.projects.htmlpageanalyzer.model;

import java.util.Map;

public class Statistic {

    public Statistic() {
    }

    public Statistic(Map<String, Integer> statOfUniqueWords) {
        this.statOfUniqueWords = statOfUniqueWords;
    }

    private Map<String, Integer> statOfUniqueWords;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Map<String, Integer> getStatOfUniqueWords() {
        return statOfUniqueWords;
    }

    public void setStatOfUniqueWords(Map<String, Integer> statOfUniqueWords) {
        this.statOfUniqueWords = statOfUniqueWords;
    }
}
