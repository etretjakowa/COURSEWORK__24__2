package ru.sky.coursework._42.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.coursework._42.Question;
import ru.sky.coursework._42.servise.ExaminerServiceImpl;

import java.util.Collection;

@RestController

public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get")
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }

}
