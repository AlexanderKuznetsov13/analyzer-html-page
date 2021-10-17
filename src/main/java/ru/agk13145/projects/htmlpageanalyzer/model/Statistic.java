package ru.agk13145.projects.htmlpageanalyzer.model;

import java.util.Map;

public class Statistic {

    public Statistic() {
    }

    public Statistic(Map<String, Integer> statOfUniqueWords) {
        this.statOfUniqueWords = statOfUniqueWords;
    }

    private Map<String, Integer> statOfUniqueWords;

    public Map<String, Integer> getStatOfUniqueWords() {
        return statOfUniqueWords;
    }

    public void setStatOfUniqueWords(Map<String, Integer> statOfUniqueWords) {
        this.statOfUniqueWords = statOfUniqueWords;
    }
}
