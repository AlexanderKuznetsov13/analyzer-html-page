package ru.agk13145.projects.htmlpageanalyzer.model;

import java.util.Map;

public class Statistic {

    private Map<String, Integer> mapOfUniqueWords;

    public Map<String, Integer> getMapOfUniqueWords() {
        return mapOfUniqueWords;
    }

    public void setMapOfUniqueWords(Map<String, Integer> mapOfUniqueWords) {
        this.mapOfUniqueWords = mapOfUniqueWords;
    }
}
