package ru.agk13145.projects.htmlpageanalyzer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(StatisticController.class);

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/analyzeByURL")
    @ResponseBody
    public ResponseEntity<Statistic> analyzePageByURLparameter(@RequestParam String url) {
        logger.debug("get statistic by url as GET parameter - {}", url);
        Statistic statistic = null;
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @PostMapping("/analyze")
    @ResponseBody
    public ResponseEntity<Statistic> analyzePage(@RequestBody Page pageDto) {
        logger.debug("get statistic by url as POST parameter");
        Statistic statistic = statisticService.analyzePage(pageDto);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Statistic>> findAll() {
        logger.debug("get all statistics");
        List<Statistic> statistics = statisticService.getAllStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/{pageId}")
    @ResponseBody
    public ResponseEntity<Statistic> getStatisticsByPageId(@PathVariable Integer pageId) {
        logger.debug("get statistic by pageId");
        Statistic statistic = statisticService.getStatisticsByPageId(pageId);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

}
