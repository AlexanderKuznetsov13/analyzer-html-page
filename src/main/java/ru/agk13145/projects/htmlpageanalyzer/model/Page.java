package ru.agk13145.projects.htmlpageanalyzer.model;

public class Page {
    private Integer id;
    private String url;
    private String statisticJSON;

    public Page() {
    }

    public Page(String url, String statisticJSON) {
        this.url = url;
        this.statisticJSON = statisticJSON;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatisticJSON() {
        return statisticJSON;
    }

    public void setStatisticJSON(String statisticJSON) {
        this.statisticJSON = statisticJSON;
    }
}
