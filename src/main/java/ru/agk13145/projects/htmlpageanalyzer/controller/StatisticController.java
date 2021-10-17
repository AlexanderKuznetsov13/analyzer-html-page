package ru.agk13145.projects.htmlpageanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.projects.htmlpageanalyzer.model.Page;
import ru.agk13145.projects.htmlpageanalyzer.model.Statistic;
import ru.agk13145.projects.htmlpageanalyzer.service.StatisticService;

import java.util.List;

@Controller
@RequestMapping(value = "/statistic", produces = "application/json;charset=UTF-8")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/analyzeByURL")
    @ResponseBody
    public ResponseEntity<Statistic> analyzePageByURLparameter(@RequestParam String url) {
        System.out.println("analyzePageByURLparameter");
        System.out.println(url);
        Statistic statistic = null;
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @PostMapping("/analyze")
    @ResponseBody
    public ResponseEntity<Statistic> analyzePage(@RequestBody Page pageDto) {
        System.out.println("analyzePage");
        Statistic statistic = statisticService.analyzePage(pageDto);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Statistic>> findAll() {
        System.out.println("findAll");
        List<Statistic> statistics = statisticService.getAllStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/{pageId}")
    @ResponseBody
    public ResponseEntity<Statistic> getStatisticsByPageId(@PathVariable Integer pageId) {
        System.out.println("getStatisticsByPageId");
        Statistic statistic = statisticService.getStatisticsByPageId(pageId);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

}
