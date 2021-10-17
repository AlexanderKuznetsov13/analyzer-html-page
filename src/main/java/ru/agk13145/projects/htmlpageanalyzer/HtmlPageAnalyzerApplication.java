package ru.agk13145.projects.htmlpageanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HtmlPageAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtmlPageAnalyzerApplication.class, args);
        System.out.println("Html Page Analyzer Application is running...");
    }

}
